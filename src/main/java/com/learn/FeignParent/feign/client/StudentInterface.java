package com.learn.FeignParent.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learn.model.Student;


@FeignClient(url="http://localhost:9001/student", value="StudentService1")
public interface StudentInterface {

	@GetMapping("/list")
	public List<Student> getAllStudents();
	
	@PutMapping("update")
	public Student updateStudent(@RequestBody Student student);
	
	@GetMapping("/byLastName/{studentLastName}")
	public List<Student> getAllStudentByLastName(@PathVariable String studentLastName);
}
