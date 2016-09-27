package com.niit.backend.testCase;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.JobDao;
import com.niit.backend.model.Event;
import com.niit.backend.model.Job;

public class JobOpportunitiesTest {
	
	
	public static void main(String[]args){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		Job jobOpportunities =(Job) context.getBean("jobOpportunities");
		JobDao jobOpportunitiesDao = (JobDao) context.getBean("jobOpportunitiesDao");
		jobOpportunities.setCreatedAt(new Date());
		jobOpportunities.setDescription("Job for Faculty");
		jobOpportunities.setTitle("Faculty Needed");
		jobOpportunitiesDao.saveOrUpdate(jobOpportunities);
		
		
		Job jobOpportunities1 =(Job) context.getBean("jobOpportunities");
		JobDao jobOpportunitiesDao1 = (JobDao) context.getBean("jobOpportunitiesDao");
		jobOpportunities.setCreatedAt(new Date());
		jobOpportunities.setDescription("Job for Student");
		jobOpportunities.setTitle(" Developer Needed");
		jobOpportunitiesDao.saveOrUpdate(jobOpportunities);
		
		
		Job jobOpportunities2 =(Job) context.getBean("jobOpportunities");
		JobDao jobOpportunitiesDao2 = (JobDao) context.getBean("jobOpportunitiesDao");
		jobOpportunities.setCreatedAt(new Date());
		jobOpportunities.setDescription("Job for others");
		jobOpportunities.setTitle(" otherJOBS");
		jobOpportunitiesDao.saveOrUpdate(jobOpportunities);
	}
	

}
