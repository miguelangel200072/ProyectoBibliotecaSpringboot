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

import com.example.biblioteca.model.EjemplarModel;
import com.example.biblioteca.service.EjemplarService;

@RestController
@RequestMapping(value="/ejemplar")
public class EjemplarController {
	
	@Autowired
	EjemplarService ejemplarService;
	
	@PostMapping(value="/save")
	public EjemplarModel guardaEjemplar(@RequestBody EjemplarModel ejemplar) {
		
		EjemplarModel result = new EjemplarModel();
		
		result = ejemplarService.guardaEjemplar(ejemplar);
		
		return result;
	}
	
	@GetMapping(value="/get/{id}")
	public EjemplarModel getEjemplarByID(@PathVariable(value="id") Integer id) {
		
		EjemplarModel result = new EjemplarModel();
		
		result = ejemplarService.getEjemplarByID(id);
		
		return result;
	}
	
	@GetMapping(value="/getAll")
	public List<EjemplarModel> getAllEjemplares(){
		
		List<EjemplarModel> result = new ArrayList<>();
		
		result = ejemplarService.getAllEjemplares();
		
		return result;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteEjemplarByID(@PathVariable(value="id") Integer id) {
		
		ejemplarService.deleteEjemplarByID(id);
	}
	
	@PutMapping(value="/update")
	public EjemplarModel updateEjemplar(@RequestBody EjemplarModel ejemplar) {
		
		EjemplarModel result = ejemplarService.updateEjemplar(ejemplar);
		
		return result;
	}

}
