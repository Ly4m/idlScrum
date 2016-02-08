package fil.iagl.idl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@MapperScan(value = "fil.iagl.idl.dao")
public class ScrumApplication {
	// mvn test -DskipTests
	// mvn dependency:build-classpath

	public static final String PATH_TO_POM = "C:/workspace/CoCoSpoon";

	public static Map<String, List<String>> associationMap;

	@Bean
	public DataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();

		// url to dev at home
		ds.setUsername("postgres");
		ds.setPassword("postgres");
		ds.setUrl("jdbc:postgresql://localhost:5432/IDL4");

		ds.setDriverClassName("org.postgresql.Driver");
		ds.setMaxWait(25);
		return ds;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/*Mapper.xml"));
		return sessionFactory.getObject();
	}

	public static void main(String[] args) {
		SpringApplication.run(ScrumApplication.class, args);
	}

}
