package com.DevSuperior.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevSuperior.dscatalog.dto.CategoryDTO;
import com.DevSuperior.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
     List<CategoryDTO> list = service.findAll();
     return ResponseEntity.ok().body(list);
	}
		
     //BUSCANDO POR ID 
 	@GetMapping(value = "/{id}")
 	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
      
 		CategoryDTO dto = service.findById(id);
      return ResponseEntity.ok().body(dto);     
     
//EXEMPLO DE LISTA MOCADA 		
//		List<Category> list = new ArrayList<>();
//		list.add(new Category(1L, "Books"));
//		list.add(new Category(2L, "furniture"));
         	 
    	 
     }
			}
