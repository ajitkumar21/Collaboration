package com.niit.backend.testCase;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.JobOpportunitiesDao;
import com.niit.backend.model.Event;
import com.niit.backend.model.JobOpportunities;

public class JobOpportunitiesTest {
	
	
	public static void main(String[]args){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		JobOpportunities jobOpportunities =(JobOpportunities) context.getBean("jobOpportunities");
		JobOpportunitiesDao jobOpportunitiesDao = (JobOpportunitiesDao) context.getBean("jobOpportunitiesDao");
		jobOpportunities.setCreatedAt(new Date());
		jobOpportunities.setDescription("Job for Faculty");
		jobOpportunities.setTitle("Faculty Needed");
		jobOpportunitiesDao.saveOrUpdate(jobOpportunities);
		
		
		JobOpportunities jobOpportunities1 =(JobOpportunities) context.getBean("jobOpportunities");
		JobOpportunitiesDao jobOpportunitiesDao1 = (JobOpportunitiesDao) context.getBean("jobOpportunitiesDao");
		jobOpportunities.setCreatedAt(new Date());
		jobOpportunities.setDescription("Job for Student");
		jobOpportunities.setTitle(" Developer Needed");
		jobOpportunitiesDao.saveOrUpdate(jobOpportunities);
		
		
		JobOpportunities jobOpportunities2 =(JobOpportunities) context.getBean("jobOpportunities");
		JobOpportunitiesDao jobOpportunitiesDao2 = (JobOpportunitiesDao) context.getBean("jobOpportunitiesDao");
		jobOpportunities.setCreatedAt(new Date());
		jobOpportunities.setDescription("Job for others");
		jobOpportunities.setTitle(" otherJOBS");
		jobOpportunitiesDao.saveOrUpdate(jobOpportunities);
	}
	

}
