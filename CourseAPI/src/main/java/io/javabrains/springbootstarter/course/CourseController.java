package io.javabrains.springbootstarter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topic/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getCourses(id);
	}

	@RequestMapping("/topic/{topicId}/course/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topic/{topicId}/course")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/topic/{topicId}/courses")
	public void addTopics(@RequestBody List<Course> courses) {

		courseService.addCourses(courses);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{topicId}/course/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{topicId}/course/{id}")
	public Optional<Course> deleteCourse(@PathVariable String id) {
		return courseService.deleteCourse(id);
	}

}
