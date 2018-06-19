package io.khasang.rtrail.config;

import io.khasang.rtrail.dao.CatDao;
import io.khasang.rtrail.dao.RoutDao;
import io.khasang.rtrail.dao.EmployeeDao;
import io.khasang.rtrail.dao.MessageDao;
import io.khasang.rtrail.dao.UserDao;
import io.khasang.rtrail.dao.impl.CatDaoImpl;
import io.khasang.rtrail.dao.impl.RoutDaoImpl;
import io.khasang.rtrail.dao.impl.EmployeeDaoImpl;
import io.khasang.rtrail.dao.impl.MessageDaoImpl;
import io.khasang.rtrail.dao.impl.UserDaoImpl;
import io.khasang.rtrail.entity.Cat;
import io.khasang.rtrail.entity.Rout;
import io.khasang.rtrail.entity.Employee;
import io.khasang.rtrail.entity.User;
import io.khasang.rtrail.model.CreateTable;
import io.khasang.rtrail.model.Message;
import io.khasang.rtrail.model.impl.MessageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = "classpath:util.properties")
@PropertySource(value = "classpath:auth.properties")
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    @Scope("prototype")
    public Message message(){
        return new MessageImpl("HelloWorld!");
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.user"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource());
        jdbcDao.setUsersByUsernameQuery(environment.getRequiredProperty("userByQuery"));
        jdbcDao.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return jdbcDao;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public CreateTable createTable(){
        return new CreateTable(jdbcTemplate());
    }

    @Bean
    public CatDao catDao(){
        return new CatDaoImpl(Cat.class);
    }

    @Bean
    public RoutDao routDao() {
        return new RoutDaoImpl(Rout.class);
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl(Employee.class);
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDaoImpl(io.khasang.rtrail.entity.Message.class);
    }

    @Bean
    public UserDao userDao(){
        return new UserDaoImpl(User.class);
    }
}
