package com.niit.backend.Dao;

import java.util.List;


import com.niit.backend.model.Job;

public interface JobDao {
	
	void saveOrUpdate(Job job);
	
	List<Job> listAllJob();
	
	public Job findByTitle(String title);

		boolean isJobExist(Job job);

		Job findById(String job_id);

		void deleteUserById(String job_id);

		void deleteAllJob();

}
