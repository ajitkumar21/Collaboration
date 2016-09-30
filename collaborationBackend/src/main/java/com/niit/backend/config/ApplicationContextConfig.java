package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.model.Authorities;
import com.niit.backend.model.Blog;
import com.niit.backend.model.BlogComment;
import com.niit.backend.model.Event;
import com.niit.backend.model.Forum;
import com.niit.backend.model.ForumPost;
import com.niit.backend.model.PostComment;
import com.niit.backend.model.Job;
import com.niit.backend.model.User;
import com.niit.backend.model.UserDetails;

@Configuration
@ComponentScan("com.niit.backend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name="dataSource")
	public DataSource getOracleDataSource(){
		DriverManagerDataSource dataSource=  new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/collaboration");		
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	private Properties getHibernateProperties(){	
		Properties properties=new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");		
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
		}
	
	
	@Autowired
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder= new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		sessionBuilder.addAnnotatedClass(Authorities.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(Event.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(ForumPost.class);
		sessionBuilder.addAnnotatedClass(PostComment.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(User.class);
		
        return sessionBuilder.buildSessionFactory();
		
	}
	
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager =new HibernateTransactionManager(sessionFactory);		
		return transactionManager;
	}
}
