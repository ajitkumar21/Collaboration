package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.EventDao;
import com.niit.backend.model.Event;

@Repository("eventDao")
@Transactional
public class EventDaoImpl implements EventDao {

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
	public List<Event> listAllEvents() {
	
		String hql="from Event";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listEvent=query.getResultList();
		return listEvent;
	
	}

	@Override
	public boolean isEventExist(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Event findById(String event_id) {
		// TODO Auto-generated method stub
		String hql = "from Event where event_id=" + "'" + event_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listEvent = (List<Event>) query.getResultList();
		if (listEvent  != null && !listEvent .isEmpty()) {
			return listEvent.get(0);
		}
		return null;
	}
	
	@Override
	public void deleteUserById(String event_id) {
		// TODO Auto-generated method stub
		Event eventToDelete = new Event();
		eventToDelete.setEvent_id(event_id);
		sessionFactory.getCurrentSession().delete(eventToDelete);
		
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

}
