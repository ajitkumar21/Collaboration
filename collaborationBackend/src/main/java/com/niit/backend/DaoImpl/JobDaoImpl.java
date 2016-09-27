package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.JobDao;
import com.niit.backend.model.Event;
import com.niit.backend.model.Job;


@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao {
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		
	}

	@Override
	public List<Job> listAllJob() {
		        String hql="from Job";
				Query query=sessionFactory.getCurrentSession().createQuery(hql);
				List<Job> listJob=query.getResultList();
				return listJob;
	}

	@Override
	public Job findByTitle(String title) {
		String hql = "from Job  where title=" + "'" + title + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Job> listJob = (List<Job>) query.getResultList();
		if (listJob  != null && !listJob .isEmpty()) {
			return listJob.get(0);
		}
		return null;
		
	}

	@Override
	public boolean isJobExist(Job job) {
		// TODO Auto-generated method stub
		return findByTitle(job.getTitle())!=null;
	}

	@Override
	public Job findById(String job_id) {
		String hql = "from Job where job_id=" + "'" + job_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Job> listJob = (List<Job>) query.getResultList();
		if (listJob  != null && !listJob .isEmpty()) {
			return listJob.get(0);
		}
		return null;
	}

	@Override
	public void deleteUserById(String job_id) {
		Job jobToDelete = new Job();
		jobToDelete.setJob_id(job_id);
		sessionFactory.getCurrentSession().delete(jobToDelete);
		
	}

	@Override
	public void deleteAllJob() {
		sessionFactory.getCurrentSession().delete(getClass());
		
	}

	

}
