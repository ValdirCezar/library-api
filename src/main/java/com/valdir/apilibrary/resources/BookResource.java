package com.valdir.apilibrary.resources;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class {
	
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
