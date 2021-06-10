package com.learn.FeignParent.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learn.model.Books;

@FeignClient(url="http://localhost:9002/book", value="BookService1")
public interface BooksInterface {

	@GetMapping("/allbooks")
	public List<Books> getAllBooks();
	
	@GetMapping("/book/{bookid}")
	public Books getBooks(@PathVariable("bookid") int bookid);
}
