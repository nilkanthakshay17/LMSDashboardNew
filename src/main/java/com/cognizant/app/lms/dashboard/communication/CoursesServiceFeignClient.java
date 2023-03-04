package com.cognizant.app.lms.dashboard.communication;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.app.lms.dashboard.model.CourseRequestModel;
import com.cognizant.app.lms.dashboard.model.CourseResponseModel;

@FeignClient(name = "lmscourses", fallbackFactory = CoursesServiceFeignClientFallbackFactory.class)
public interface CoursesServiceFeignClient {
	
	@PostMapping("/api/v1.0/course")
	public ResponseEntity<CourseResponseModel> registerCourse(@RequestBody CourseRequestModel registerRequest) throws Throwable;

	@GetMapping("/api/v1.0/course")
	public ResponseEntity<List<CourseResponseModel>> getAllCourses() throws Throwable;
	
	@GetMapping("/api/v1.0/course/{id}")
	public ResponseEntity<CourseResponseModel> getCourseById(@PathVariable(name = "id")String id) throws Throwable;

	@PutMapping("/api/v1.0/course/{id}")
	public ResponseEntity<CourseResponseModel> updateCourseById(@RequestBody CourseRequestModel updateRequest, @PathVariable(name = "id")String id) throws Throwable;
	
}
