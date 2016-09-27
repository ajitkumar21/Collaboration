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
	public List<Event> listAllEvents() {
		// TODO Auto-generated method stub
		String hql="from Event";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listEvent=query.getResultList();
		return listEvent;
	
	}

	@Override
	public boolean isEventExist(Event event) {
		// TODO Auto-generated method stub
		
		return findByName(event.getEventName())!=null;
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
	public void deleteAllEvents() {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getClass());
	}


	@Override
	public Event findByName(String eventName) {
		// TODO Auto-generated method stub
		String hql = "from Event where eventName=" + "'" + eventName + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listEvent = (List<Event>) query.getResultList();
		if (listEvent  != null && !listEvent .isEmpty()) {
			return listEvent.get(0);
		}
		return null;
	}

}
