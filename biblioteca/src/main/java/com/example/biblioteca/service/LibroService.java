package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.LibroModel;

public interface LibroService {

	public LibroModel guardaLibro(LibroModel libro);
	
	//public LibroModel getLibroByID(Integer id);

	public LibroModel getLibroByID(Integer id);
	
	public List<LibroModel> getAllLibros();
	
	public void deleteByID(Integer id);
	
	LibroModel updateLibro(LibroModel libro);
}
