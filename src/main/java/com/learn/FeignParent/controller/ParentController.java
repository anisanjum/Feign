package com.learn.FeignParent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.FeignParent.feign.client.BooksInterface;
import com.learn.FeignParent.feign.client.StudentInterface;
import com.learn.model.Books;
import com.learn.model.Student;

@RestController
@RequestMapping("/parent")
public class ParentController {
	
	@Autowired
	StudentInterface studentInterface;
	
	@Autowired
	BooksInterface booksInterface;

	@GetMapping("/allbooks")
	private List<Books> getAllBooksDetails() 
	{
		return booksInterface.getAllBooks();
	}
	//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/book/{bookid}")
	private Books getBooksById(@PathVariable("bookid") int bookid) 
	{
		return booksInterface.getBooks(bookid);
	}
	
	@GetMapping("/list")
	public List<Student> getAllStudentsDetails() {
		return studentInterface.getAllStudents();
	}

	@PutMapping("update")
	public Student updateStudent(@RequestBody Student student) {
		return studentInterface.updateStudent(student);
	}
	
	@GetMapping("/byLastName/{studentLastName}")
	public List<Student> getAllStudentByLastName(@PathVariable String studentLastName) {
		return (List<Student>) studentInterface.getAllStudentByLastName(studentLastName);
	}
	
}
