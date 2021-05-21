package io.javabrains.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topic")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopics(@RequestBody List<Topic> topics) {
		topicService.addTopics(topics);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{id}")
	public Optional<Topic> deleteTopic(@PathVariable String id) {
		return topicService.deleteTopic(id);
	}

}
