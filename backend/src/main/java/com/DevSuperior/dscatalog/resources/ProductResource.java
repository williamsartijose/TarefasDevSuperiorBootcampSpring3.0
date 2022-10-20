package com.DevSuperior.dscatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.DevSuperior.dscatalog.dto.ProductDTO;
import com.DevSuperior.dscatalog.services.ProductService;

@RestController
@RequestMapping(value = "/ Products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	
	@GetMapping
	public ResponseEntity<Page<ProductDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "ASC") String orderBy,
			@RequestParam(value = "direction", defaultValue = "name") String direction
			){
		PageRequest pageReuest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<ProductDTO> list = service.findAllPaged(pageReuest);
		
       return ResponseEntity.ok().body(list);
			
	}
		
     //BUSCANDO POR ID 
 	@GetMapping(value = "/{id}")
 	public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
      
 		ProductDTO dto = service.findById(id);
      return ResponseEntity.ok().body(dto);   
      
 	}
 	
 	
 	//INSERINDO DADOS COM O POST 201 criado
 	@PostMapping
 	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
 		dto = service.insert(dto);
 		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
 				.buildAndExpand(dto.getId()).toUri();
 		return ResponseEntity.created(uri).body(dto);
 	}
 	
 	//ATUALIZAR OS DADOS COM 0 PUT 
	@PutMapping(value = "/{id}")
 	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto){
 		dto = service.update(id,dto);
 		return ResponseEntity.ok().body(dto);
 	}
	
	//DELETAR  OS DADOS COM 0 DELETE 
		@DeleteMapping(value = "/{id}")
	 	public ResponseEntity<ProductDTO> delete(@PathVariable Long id){
	 	 service.delete(id);
	 		return ResponseEntity.noContent().build();
	 	}
 	
//EXEMPLO DE LISTA MOCADA 		
//		List<Product> list = new ArrayList<>();
//		list.add(new Product(1L, "Books"));
//		list.add(new Product(2L, "furniture"));
         	 
    	 
     }

