package fil.iagl.idl;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@SpringBootApplication
@MapperScan(value = "fil.iagl.cookorico.dao")
public class ScrumApplication {

    @Bean
    public DataSource dataSource() {

        BasicDataSource ds = new BasicDataSource();

        // url to dev at home
        ds.setUsername("postgres");
        ds.setPassword("postgres");
        ds.setUrl("jdbc:postgresql://localhost:5432/idl4");


        ds.setDriverClassName("org.postgresql.Driver");
        ds.setMaxWait(25);
        return ds;
    }

    //gnn

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/*Mapper.xml"));
        return sessionFactory.getObject();
    }

    @RequestMapping("/resource")
    @ResponseBody
    public Map<String, Object> test() {
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }


    public static void main(String[] args) {
        SpringApplication.run(ScrumApplication.class, args);
    }

}
