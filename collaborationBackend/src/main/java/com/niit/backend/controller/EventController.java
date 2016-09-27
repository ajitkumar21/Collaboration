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

import com.niit.backend.Dao.EventDao;
import com.niit.backend.model.Event;

@RestController
public class EventController {
	@Autowired
	EventDao eventDao;
	@Autowired
	Event event;
	
	/*
	 * 
	 * fetch all events
	 * 
	 */
	
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> listAllEvents(){
		List<Event> events = eventDao.listAllEvents();
		if(events.isEmpty()){
            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
    
  /*
   * 
   * create event
   * 
   */
    
  @RequestMapping(value = "/events", method = RequestMethod.POST)
  public ResponseEntity<Void> createEvent(@RequestBody Event event,UriComponentsBuilder ucBuilder) {
      System.out.println("Creating Event " + event.getEventName());

      if (eventDao.isEventExist(event)) {
          System.out.println("A Event with name " + event.getEventName() + " already exist");
          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
      }
      event.setEvent_id("EVT"+UUID.randomUUID().toString().substring(30).toUpperCase());
     event.setCreatedAt(new Date());
     eventDao.saveOrUpdate(event);

      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(ucBuilder.path("/events/{event_id}").buildAndExpand(event.getEvent_id()).toUri());
      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

   
  /*
   * 
   * 
   * update event
   * 
   * 
   */
  
  @RequestMapping(value = "/events/{event_id}", method = RequestMethod.PUT)
  public ResponseEntity<Event> updateUser(@PathVariable("event_id") String event_id, @RequestBody Event event) {
      System.out.println("Updating event " + event_id);
        
      
      
      Event currentEvent=eventDao.findById(event_id);
        
      if (currentEvent==null) {
          System.out.println("event with id " + event_id + " not found");
          return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
      }

      currentEvent.setEventName(event.getEventName());
      currentEvent.setDescription(event.getDescription());
      currentEvent.setCreatedAt(new Date());
        
      eventDao.saveOrUpdate(currentEvent);
      return new ResponseEntity<Event>(currentEvent, HttpStatus.OK);
  } 

  
  /*
   * 
   * Delete a event
   * 
   */
  
  @RequestMapping(value = "/events/{event_id}", method = RequestMethod.DELETE)
  public ResponseEntity<Event> deleteUser(@PathVariable("event_id") String event_id) {
      System.out.println("Fetching & Deleting event with event_id " + event_id);

      Event event = eventDao.findById(event_id);
      if (event == null) {
          System.out.println("Unable to delete. Event with event_id " + event_id + " not found");
          return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
      }

      eventDao.deleteUserById(event_id);
      return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
  }

}