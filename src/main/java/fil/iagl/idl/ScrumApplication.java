package fil.iagl.idl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import fil.iagl.idl.maven.MavenRunner;
import fil.iagl.idl.parser.Resultat;
import fil.iagl.idl.parser.XMLParser;

@Controller
@SpringBootApplication
@MapperScan(value = "fil.iagl.idl.dao")
public class ScrumApplication {

	private static final String PATH_TO_POM = "C:/workspace/HotelApp/HotelDatabase";

	@Bean
	public DataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();

		// url to dev at home
		ds.setUsername("postgres");
		ds.setPassword("postgres");
		ds.setUrl("jdbc:postgresql://localhost:5433/IDL4");

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

	@RequestMapping("/resource")
	@ResponseBody
	public Map<String, Object> test() {
		Map<String, Object> model = new HashMap<>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	public static void main(String[] args) {
		try {
			MavenRunner.cleanCompileTest(PATH_TO_POM);
			XMLParser.readSurefireReport(new File(PATH_TO_POM + "/target"), new Resultat());
		} catch (MavenInvocationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
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
