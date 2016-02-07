package fil.iagl.idl;

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

	public static final String PATH_TO_POM = "C:/workspace/HotelApp/HotelDatabase";

	@Bean
	public DataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();

		// url to dev at home
		ds.setUsername("postgres");
		ds.setPassword("postgre");
		ds.setUrl("jdbc:postgresql://localhost:5432/IDL4");

		ds.setDriverClassName("org.postgresql.Driver");
		ds.setMaxWait(25);
		return ds;
	}

	// gnn

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

	// @Override
	// public void run(String... args) throws Exception {
	// RestTemplate restTemplate = new RestTemplate();
	// Report[] quote =
	// restTemplate.getForObject("http://travis-ci.org/Piorunj/HotelApp",
	// Report[].class);
	// ClientHttpRequest client = restTemplate.getRequestFactory()
	// .createRequest(new URI("https://api.travis-ci.org/jobs"),
	// HttpMethod.GET);
	// ClientHttpResponse response = client.execute();
	//
	// System.out.println(quote.toString().length());
	// }

}
