package com.niit.backend.testCase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.EventDao;
import com.niit.backend.model.Event;

public class eventTest {

	public static void main(String args[]){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		Event event= (Event) context.getBean("event");
		EventDao eventDao=(EventDao) context.getBean("eventDao");
		event.setEventName("sanjeev");
		event.setDescription("this is the event");
		event.setCreatedAt("12/02/2016");
		eventDao.saveOrUpdate(event);
	}
}
