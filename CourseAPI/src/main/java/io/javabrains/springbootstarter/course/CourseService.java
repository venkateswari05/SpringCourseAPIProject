package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		
		return courses;
	}

	public Optional<Course> getCourse(String id) {
		
		return courseRepository.findById(id);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void addCourses(List<Course> courses) {
		courseRepository.saveAll(courses);
	}
	
	public void updateCourse(Course course, String id) {
		courseRepository.save(course);
	}
	
	public Optional<Course> deleteCourse(String id) {
		
		Optional<Course> course = courseRepository.findById(id);
		courseRepository.deleteById(id);
		return course;
	}

}
