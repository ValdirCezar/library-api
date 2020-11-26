package com.valdir.apilibrary.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.valdir.apilibrary.domain.Book;
import com.valdir.apilibrary.dtos.BookDTO;
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
	@PostMapping(value = "/{id}")
	public ResponseEntity<BookDTO> insert(@PathVariable Integer id, @Valid @RequestBody BookDTO obj) {
		Book newObj = service.insert(id, obj);
		obj = new BookDTO(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	@ApiOperation(value = "return a list of Books")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success method return")
	} )
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<BookDTO>> findAll(@PathVariable Integer id) {
		List<Book> list = service.findAllByCategory(id);
		List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@ApiOperation(value = "return a book by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success method")
	})
	@GetMapping(value = "/books/{id}")
	public ResponseEntity<BookDTO> findById(@PathVariable Integer id) {
		BookDTO obj = new BookDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "delete a book by id")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "no content")
	})
	@DeleteMapping(value = "/books/{id}")
	public ResponseEntity<Book> deleteById(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
