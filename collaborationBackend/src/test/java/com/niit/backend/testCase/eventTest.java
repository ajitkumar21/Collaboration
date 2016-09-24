 package com.niit.backend.testCase;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.EventDao;
import com.niit.backend.model.Event;

public class EventTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		Event event=(Event) context.getBean("event");
		EventDao eventDao=(EventDao) context.getBean("eventDao");
		
		event.setCreatedAt(new Date());
		event.setDescription("All events");
		event.setEventName("name of event");
		eventDao.saveOrUpdate(event);
	}
}
