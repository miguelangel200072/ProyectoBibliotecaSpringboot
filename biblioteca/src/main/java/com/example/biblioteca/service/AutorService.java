package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.AutorModel;

public interface AutorService {
	
	public AutorModel guardaAutor(AutorModel autor);
	
	public AutorModel getAutorByID(Integer id);
	
	public List<AutorModel> getAllAutores();
	
	public void deleteAutorByID(Integer id);
	
	public AutorModel updateAutor(AutorModel autor);

}
