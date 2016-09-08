package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.AuthoritiesDao;
import com.niit.backend.model.Authorities;

public class AuthoritiesDaoImpl implements AuthoritiesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public AuthoritiesDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;

		}
	@Transactional
	public void saveOrUpdate(Authorities authorities) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(authorities);

	}

	@Transactional
	public void editAuthorities(Authorities authorities) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(authorities);
	}

	@Transactional
	public Authorities get(String authorities_id) {
		
		//return sessionFactory.getCurrentSession().get(Authorities.class, authorities_id);
		String hql = "from Authorities where authorities_id=" + "'" + authorities_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Authorities> listAuthorities= (List<Authorities>) query.getResultList();
		if (listAuthorities!= null && !listAuthorities.isEmpty()) {
			return listAuthorities.get(0);
		}
		return null;
	}

	@Transactional
	public List<Authorities> list() {
		
		@SuppressWarnings("unchecked")
		List<Authorities> listAuthorities= (List<Authorities>) sessionFactory.getCurrentSession()
		.createCriteria(Authorities.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listAuthorities;
	}
}
