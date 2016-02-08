package fil.iagl.idl;


@org.springframework.stereotype.Controller
@org.springframework.boot.autoconfigure.SpringBootApplication
@org.mybatis.spring.annotation.MapperScan(value = "fil.iagl.idl.dao")
public class ScrumApplication {
    public static final java.lang.String PATH_TO_POM = "C:/workspace/HotelApp/HotelDatabase";

    @org.springframework.context.annotation.Bean
    public javax.sql.DataSource dataSource() {
        org.apache.commons.dbcp.BasicDataSource ds = new org.apache.commons.dbcp.BasicDataSource();
        ds.setUsername("postgres");
        ds.setPassword("postgres");
        ds.setUrl("jdbc:postgresql://localhost:5432/IDL4");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setMaxWait(25);
        return ds;
    }

    @org.springframework.context.annotation.Bean
    public org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory(javax.sql.DataSource dataSource) throws java.lang.Exception {
        final org.mybatis.spring.SqlSessionFactoryBean sessionFactory = new org.mybatis.spring.SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        final org.springframework.core.io.support.PathMatchingResourcePatternResolver resolver = new org.springframework.core.io.support.PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/*Mapper.xml"));
        return sessionFactory.getObject();
    }

    public static void main(java.lang.String[] args) {
        java.lang.String[] spoonArgs = new java.lang.String[]{ "-i" , "C:/workspace/idlScrum/src/main/java" , "-p" , "fil.iagl.idl.processor.AnnotationProcessor" , "-x" };
        try {
            spoon.Launcher.main(spoonArgs);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}

