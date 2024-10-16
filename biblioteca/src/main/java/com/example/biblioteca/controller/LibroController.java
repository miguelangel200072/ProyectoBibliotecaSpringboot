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
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.service.LibroService;

@RestController
@RequestMapping(value = "/libro")
public class LibroController {

	@Autowired
	LibroService libroService;
	
	@PostMapping(value = "/save")
	public LibroModel guardaLibro(@RequestBody LibroModel libro) {
		
		LibroModel result = new LibroModel();
		
		result = libroService.guardaLibro(libro);
		
		return result;
	}
	
	@GetMapping(value = "/get/{id}")
	public LibroModel getByID(@PathVariable(value="id") Integer id) {
		//@PathVariable(value="id")
		LibroModel result = new LibroModel();
		
		result = libroService.getLibroByID(id);
		
		return result;
	}
	
	@GetMapping(value="/getAll")
	public List<LibroModel> getAllLibros(){
		
		List<LibroModel> result = new ArrayList<LibroModel>();
		
		result = libroService.getAllLibros();
		
		return result;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteByID(@PathVariable(value="id") Integer id) {
		
		libroService.deleteByID(id);
	}
	
	@PutMapping(value="/update")
	public LibroModel updateLibro(@RequestBody LibroModel libro) {
		
		LibroModel result = new LibroModel();
		
		result = libroService.updateLibro(libro);
		
		return result;
	}
}
