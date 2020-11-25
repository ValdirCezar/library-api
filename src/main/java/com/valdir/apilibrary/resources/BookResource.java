package com.valdir.apilibrary.resources;

import java.net.URI;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.valdir.apilibrary.domain.Book;
import com.valdir.apilibrary.services.BookService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class BookResource {
	
	@Autowired
	private BookService service;
	
	@NotNull(message = "Required field")
	@Size(min = 4, max = 40, message = "This field shoud have between 4 and 40 characters")
	@ApiOperation(value = "return a 201 created")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "created method return")
	})
	@PostMapping(value = "/{id}/books")
	public ResponseEntity<Book> insert(@PathVariable Integer id, @RequestBody Book obj) {
		obj = service.insert(id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	
}
