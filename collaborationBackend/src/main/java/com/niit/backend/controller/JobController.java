package com.niit.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.backend.Dao.JobDao;
import com.niit.backend.model.Job;

@RestController
public class JobController {
	
	
	@Autowired
	JobDao jobDao;
	
	@Autowired
	Job job;
	
	//------------ fetch all Job --------//
	
	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> listAllJob(){
		List<Job> job = jobDao.listAllJob();
		if(job.isEmpty()){
            return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Job>>(job, HttpStatus.OK);
	}
	
	//------------create Jobs----------------------//
	
	@RequestMapping(value = "/jobs", method = RequestMethod.POST)
	  public ResponseEntity<Void> createEvent(@RequestBody Job job,UriComponentsBuilder ucBuilder) {
	      System.out.println("Creating Job " + job.getTitle());

	      if (jobDao.isJobExist(job)) {
	          System.out.println("A Job with name " + job.getTitle() + " already exist");
	          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	      }
	      job.setJob_id("JOB"+UUID.randomUUID().toString().substring(30).toUpperCase());
	      job.setCreatedAt(new Date());
	      jobDao.saveOrUpdate(job);

	      HttpHeaders headers = new HttpHeaders();
	      headers.setLocation(ucBuilder.path("/jobs/{job_id}").buildAndExpand(job.getJob_id()).toUri());
	      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }
	
	
	
	
	//-------Update Job -----------------------------//
	
	
	@RequestMapping(value = "/jobs/{job_id}", method = RequestMethod.PUT)
	  public ResponseEntity<Job> updateUser(@PathVariable("job_id") String job_id, @RequestBody Job job) {
	      System.out.println("Updating Job " + job_id);
	        
	      
	      
	      Job currentJob=jobDao.findById(job_id);
	        
	      if (currentJob==null) {
	          System.out.println("job with id " + job_id + " not found");
	          return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
	      }

	      currentJob.setTitle(job.getTitle());
	      currentJob.setDescription(job.getDescription());
	      currentJob.setCreatedAt(new Date());
	        
	      jobDao.saveOrUpdate(currentJob);
	      return new ResponseEntity<Job>(currentJob, HttpStatus.OK);
	  }
	
	//---------------Delete Job ------------------------------//
	
	@RequestMapping(value = "/jobs/{job_id}", method = RequestMethod.DELETE)
	  public ResponseEntity<Job> deleteUser(@PathVariable("job_id") String job_id) {
	      System.out.println("Fetching & Deleting event with job_id " + job_id);

	      Job job = jobDao.findById(job_id);
	      if (job == null) {
	          System.out.println("Unable to delete. Job with job_id " + job_id + " not found");
	          return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
	      }

	      jobDao.deleteUserById(job_id);
	      return new ResponseEntity<Job>(HttpStatus.NO_CONTENT);
	  }
	
	
	
	

}
