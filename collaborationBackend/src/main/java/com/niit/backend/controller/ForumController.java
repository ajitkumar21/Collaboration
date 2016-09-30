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

import com.niit.backend.Dao.ForumDao;
import com.niit.backend.Dao.ForumPostDao;
import com.niit.backend.model.Forum;
import com.niit.backend.model.ForumPost;
import com.niit.backend.model.ModelClass;
import com.niit.backend.model.PostComment;

@RestController
public class ForumController {
	@Autowired
	Forum forum;
	
	@Autowired
	ForumDao forumDao;
	
	@Autowired
	ForumPost forumPost;
	
	@Autowired
	ForumPostDao forumPostDao;
	
	
	@Autowired
	PostComment postComment;
	 Date date=new Date();
	 
     long time = date.getTime();
     Timestamp timeStamp=new Timestamp(time);
     
     
     /*
      * 
      * fetchforum
      * 
      * 
      */
     @RequestMapping(value = "/forums", method = RequestMethod.GET)
 	public ResponseEntity<List<Forum>> listAllBlog(){
 		List<Forum> forums = forumDao.listAllForums();
 		if(forums.isEmpty()){
             return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
         }
         return new ResponseEntity<List<Forum>>(forums, HttpStatus.OK);
 	}
 	
     
     
   /*
    * 
    * 
    * create forum
    */
     
	  @RequestMapping(value = "/forums", method = RequestMethod.POST)
	  public ResponseEntity<Void> createForum(@RequestBody Forum forum,UriComponentsBuilder ucBuilder) {
	      System.out.println("Creating forum " + forum.getTitle());

	      if (forumDao.isForumExist(forum)) {
	          System.out.println("A forum with title " + forum.getTitle() + " already exist");
	          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	          }
	      
	          forum.setForum_id("FRM"+UUID.randomUUID().toString().substring(30).toUpperCase());
	          forum.setCreatedAt(timeStamp);
	          forum.setUserDetails_id("USR0025");
	          forumDao.saveOrUpdate(forum);
	      
	      HttpHeaders headers = new HttpHeaders();
	      headers.setLocation(ucBuilder.path("/forums/{forum_id}").buildAndExpand(forum.getForum_id()).toUri());
	      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }
     
/*
 * 
 * 
 * update forum
 * 
 */
	  
	  @RequestMapping(value = "/forums/{forum_id}", method = RequestMethod.PUT)
	  public ResponseEntity<Forum> updateForum(@PathVariable("forum_id") String forum_id, @RequestBody Forum forum) {
	      System.out.println("Updating Forum " + forum_id);
	        
	      
	      
	      Forum currentForum=forumDao.findById(forum_id);
	        
	      if (currentForum==null) {
	          System.out.println("forum with forum_id " + forum_id + " not found");
	          return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	      }
	      currentForum.setCreatedAt(timeStamp);
	      currentForum.setUserDetails_id(forum.getUserDetails_id());
	      currentForum.setDescription(forum.getDescription());
	      currentForum.setTitle(forum.getTitle());
	      forumDao.saveOrUpdate(currentForum);
	      return new ResponseEntity<Forum>(currentForum, HttpStatus.OK);

	  } 
	  
/*
 * 
 * 
 * delete forum
 */
	  
	  @RequestMapping(value = "/forums/{forum_id}", method = RequestMethod.DELETE)
	  public ResponseEntity<Forum> deleteUser(@PathVariable("forum_id") String forum_id) {
	      System.out.println("Fetching & Deleting forum with forum_id " + forum_id);

	      Forum forum = forumDao.findById(forum_id);
	      if (forum == null) {
	          System.out.println("Unable to delete. forum with forum_id " + forum_id + " not found");
	          return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	      }

	     forumDao.deleteForumById(forum_id);
	      return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
	  }
		
	  
	  
	  
	  
 /*
  * 
  * fetch single forum
  * 
  */
     @RequestMapping(value="/forums/forumView/{forum_id}",method=RequestMethod.GET)
     public ResponseEntity<Forum> listSingleForum(@PathVariable String forum_id){
    	 Forum singleForum=forumDao.findById(forum_id);
    	 return new ResponseEntity<Forum>(singleForum, HttpStatus.OK); 
    	 
     }
     
     //------------------fetchAllComment---------------------------------------------
     @RequestMapping(value="/forums/forumView",method=RequestMethod.GET)
     public ResponseEntity<List<ForumPost>> fetchAllComment(){
    	 List<ForumPost> forumPost=forumPostDao.listAllForumPost();
    	 if(forumPost.isEmpty()){
    		 return new  ResponseEntity<List<ForumPost>>(HttpStatus.NO_CONTENT);
    	 }
    	 return new ResponseEntity<List<ForumPost>>(forumPost,HttpStatus.OK); 
     }
     
     
     
     
     
     /*
      * 
      * post creation
      * 
      * 
      */
     
	  @RequestMapping(value = "/forums/forumView", method = RequestMethod.POST)
	  public ResponseEntity<Void> createPost(@RequestBody ModelClass modelClass,UriComponentsBuilder ucBuilder) {
	      System.out.println("Creating Post " + forum);
	      System.out.println("Creating Post " + forumPost.getForumDescription());
	      
	     /* if (forumPostDao.isForumExist(forumPost)) {
	          System.out.println("A forum with title " + forum.getTitle() + " already exist");
	          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	      }*/
	      forumPost.setForumPost_id("FRMPST"+UUID.randomUUID().toString().substring(30).toUpperCase());
	      forumPost.setCreatedAt(timeStamp);
	      forumPost.setForum(modelClass.getForum());
	      forumPost.setForumDescription(modelClass.getForumPost());
	      forumPost.setUserDetails_id("USR007");
	      forumPostDao.saveOrUpdate(forumPost);
	      HttpHeaders headers = new HttpHeaders();
	      headers.setLocation(ucBuilder.path("/forums/{forum_id}").buildAndExpand(forum.getForum_id()).toUri());
	      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }
/*
 * 
 * delete a post
 * 
 */
	  
	  @RequestMapping(value = "/forums/forumView/{forumPost_id}", method = RequestMethod.DELETE)
	  public ResponseEntity<ForumPost> deleteForum(@PathVariable("forumPost_id") String forumPost_id) {
	      System.out.println("Fetching & Deleting forumPost with forumPost_id " + forumPost_id);
	      ForumPost forumPost = forumPostDao.findById(forumPost_id);
	      if (forumPost == null) {
	          System.out.println("Unable to delete. post with forumPost_id " + forumPost_id + " not found");
	          return new ResponseEntity<ForumPost>(HttpStatus.NOT_FOUND);
	      }

	      forumPostDao.deleteForumPostById(forumPost_id);
	      return new ResponseEntity<ForumPost>(HttpStatus.NO_CONTENT);
	  }
}
