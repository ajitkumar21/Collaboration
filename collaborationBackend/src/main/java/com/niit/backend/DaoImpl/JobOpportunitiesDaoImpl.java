package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.JobOpportunitiesDao;
import com.niit.backend.model.Event;
import com.niit.backend.model.JobOpportunities;


@Repository("jobOpportunitiesDao")
@Transactional
public class JobOpportunitiesDaoImpl implements JobOpportunitiesDao {
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(JobOpportunities jobOpportunities) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(jobOpportunities);
		
	}

	@Override
	public void editJobOpportunities(JobOpportunities jobOpportunities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteJobOpportunities(JobOpportunities jobOpportunities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JobOpportunities get(String jobOpportunities_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobOpportunities> listAllJobOpportunities() {
		String hql="from JobOpportunities";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<JobOpportunities> listEvent=query.getResultList();
		return listEvent;
	}

}
