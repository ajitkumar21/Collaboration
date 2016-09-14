package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.EventDao;
import com.niit.backend.model.Event;
@Repository("eventDao")
@Transactional
public class EventDaoImpl implements EventDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(Event event) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}

	@Override
	public void editEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event get(String event_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event getEventByName(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
