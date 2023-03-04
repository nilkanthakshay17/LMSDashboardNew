package com.cognizant.app.lms.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.app.lms.dashboard.communication.CoursesServiceFeignClient;
import com.cognizant.app.lms.dashboard.model.CourseRequestModel;
import com.cognizant.app.lms.dashboard.model.CourseResponseModel;

@RestController
@RequestMapping("/api/v1.0/dashboard")
public class DashboardController {

	@Autowired
	CoursesServiceFeignClient coursesServiceFeignClient;
	
	@GetMapping("/status")
	public String getStatus() {
		return "Working...";
	}

	@PostMapping("/course")
	public ResponseEntity<CourseResponseModel> registerCourse(@RequestBody CourseRequestModel registerRequest)throws Throwable{
		return coursesServiceFeignClient.registerCourse(registerRequest);
	}
	
	@GetMapping("/course")
	public ResponseEntity<List<CourseResponseModel>> getAllCourses()throws Throwable{
		return coursesServiceFeignClient.getAllCourses();
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<CourseResponseModel> getCourseById(@PathVariable(name = "id")String id)throws Throwable{
		return coursesServiceFeignClient.getCourseById(id);
	}
	
	@PutMapping("/course/{id}")
	public ResponseEntity<CourseResponseModel> updateCourseById(@RequestBody CourseRequestModel updateRequest, @PathVariable(name = "id")String id)throws Throwable{
		return coursesServiceFeignClient.updateCourseById(updateRequest, id);
	}
}
