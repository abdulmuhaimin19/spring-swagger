package org.dxc.swagger.controller;

import java.util.List;

import org.dxc.swagger.model.Topic;
import org.dxc.swagger.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class TopicController {

@Autowired
private TopicService topicService;

@GetMapping("/topics")
@ApiOperation(value="Get all the topic",notes="All topic displayed from the store",response=Topic.class)
public List<Topic> getAllTopics(){
return topicService.getAllTopics();
}

@GetMapping("/topics/{id}")  
@ApiOperation(value="Get one topic",notes="Provide an topic id to look up specific topic from the store",response=Topic.class)  
public Topic getTopic(@PathVariable String id) {   
	return topicService.getTopic(id); 
	} 

@PostMapping("/topics")  
@ApiOperation(value="create new topic",notes="Add new topic to the store",response=Topic.class)  
public void addTopic(@RequestBody Topic topic) {   
	topicService.addTopic(topic);  
	} 

@PutMapping("/topics/{id}")  
public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {   
	topicService.updateTopic(id, topic);  
	} 

	@DeleteMapping("/topics/{id}")  
public void deleteTopic(@PathVariable String id) {   
	topicService.deleteTopic(id);  } 





}

