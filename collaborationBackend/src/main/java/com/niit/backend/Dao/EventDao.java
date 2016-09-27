package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Event;

public interface EventDao {
	void saveOrUpdate(Event event);
		
	List<Event> listAllEvents();
	
	public Event findByName(String eventName);

		boolean isEventExist(Event event);

		Event findById(String event_id);

		void deleteUserById(String event_id);

		void deleteAllEvents();
		
		

}
