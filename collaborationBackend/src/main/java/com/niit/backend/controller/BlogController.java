package com.niit.backend.controller;

import java.sql.Timestamp;
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

import com.niit.backend.Dao.BlogDao;
import com.niit.backend.model.Blog;
import com.niit.backend.model.Event;

@RestController
public class BlogController {
	@Autowired
	BlogDao blogDao;
	
	 Date date=new Date();
     long time = date.getTime();
     Timestamp timeStamp=new Timestamp(time);

     @RequestMapping(value = "/blogs", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> listAllBlog(){
		List<Blog> blogs = blogDao.listAllBlog();
		if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
	}
	
	//-------------------Create a Event--------------------------------------------------------
    
	  @RequestMapping(value = "/blogs", method = RequestMethod.POST)
	  public ResponseEntity<Void> createBlog(@RequestBody Blog blog,UriComponentsBuilder ucBuilder) {
	      System.out.println("Creating Blog " + blog.getTitle());

	      if (blogDao.isBlogExist(blog)) {
	          System.out.println("A Blog with title " + blog.getTitle() + " already exist");
	          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	      }
	     blog.setBlog_id("BLG"+UUID.randomUUID().toString().substring(30).toUpperCase());
	    
	     
	     blog.setCreatedAt(timeStamp);
	     blog.setStatus("pnding");
	     blog.setUserDetails_id("USR011");
	     blogDao.saveOrUpdate(blog);
	     

	      HttpHeaders headers = new HttpHeaders();
	      headers.setLocation(ucBuilder.path("/blogs/{blog_id}").buildAndExpand(blog.getBlog_id()).toUri());
	      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }
	//------------------- Update a Blog--------------------------------------------------------
	  
	  @RequestMapping(value = "/blogs/{blog_id}", method = RequestMethod.PUT)
	  public ResponseEntity<Blog> updateBlog(@PathVariable("blog_id") String blog_id, @RequestBody Blog blog) {
	      System.out.println("Updating Blog " + blog_id);
	        
	      
	      
	      Blog currentBlog=blogDao.findById(blog_id);
	        
	      if (currentBlog==null) {
	          System.out.println("blog with blog_id " + blog_id + " not found");
	          return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	      }

	      currentBlog.setCreatedAt(timeStamp);
	      currentBlog.setStatus("Pending");
	      currentBlog.setUserDetails_id(blog.getUserDetails_id());
	      currentBlog.setDesscription(blog.getDesscription());
	      currentBlog.setTitle(blog.getTitle());
	      blogDao.saveOrUpdate(currentBlog);
	      return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);

	  } 
	//------------------- Delete a Blog --------------------------------------------------------
	  
	  @RequestMapping(value = "/blogs/{blog_id}", method = RequestMethod.DELETE)
	  public ResponseEntity<Blog> deleteUser(@PathVariable("blog_id") String blog_id) {
	      System.out.println("Fetching & Deleting blog with blog_id " + blog_id);

	      Blog blog = blogDao.findById(blog_id);
	      if (blog == null) {
	          System.out.println("Unable to delete. blog with blog_id " + blog_id + " not found");
	          return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	      }

	     blogDao.deleteBlogById(blog_id);
	      return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
	  }
}
