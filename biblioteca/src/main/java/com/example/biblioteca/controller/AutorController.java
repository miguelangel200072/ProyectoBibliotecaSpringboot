package com.example.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.AutorModel;
import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.service.AutorService;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {

	@Autowired
	AutorService autorService;
	
	@PostMapping(value = "/save")
	public AutorModel guardaAutor(@RequestBody AutorModel autor) {
		
		AutorModel result = new AutorModel();
		
		result = autorService.guardaAutor(autor);
		
		return result;
	}
	
	@GetMapping(value = "/get/{id}")
	public AutorModel getByID(@PathVariable(value="id") Integer id) {
		
		AutorModel result = new AutorModel();
		
		result = autorService.getAutorByID(id);
		
		return result;
	}
	
	@GetMapping(value = "/getAll")
	public List<AutorModel> getAllAutores(){
		
		List<AutorModel> result = new ArrayList<AutorModel>();
		
		result = autorService.getAllAutores();
		
		return result;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteAutorByID(@PathVariable(value="id")Integer id) {
		
		autorService.deleteAutorByID(id);
		
	}
	
	@PutMapping(value="/update")
	public AutorModel updateAutor(@RequestBody AutorModel autor) {
		
	    AutorModel result = new AutorModel();
	    
	    result = autorService.updateAutor(autor);
	    
	    return result;
	}

	
}
