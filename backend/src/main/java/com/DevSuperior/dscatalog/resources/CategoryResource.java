package com.DevSuperior.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevSuperior.dscatalog.entities.Category;
import com.DevSuperior.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
     List<Category> list = service.findAll();
     return ResponseEntity.ok().body(list);
		
//EXEMPLO DE LISTA MOCADA 		
//		List<Category> list = new ArrayList<>();
//		list.add(new Category(1L, "Books"));
//		list.add(new Category(2L, "furniture"));
         	 
    	 
     }
			}
