package com.valdir.apilibrary.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryResource {
	
	@ApiOperation(value = "return a example of REST OK")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Succes method return")
	})
	@GetMapping
	public String find() {
		return "REST OK";
	}

}
