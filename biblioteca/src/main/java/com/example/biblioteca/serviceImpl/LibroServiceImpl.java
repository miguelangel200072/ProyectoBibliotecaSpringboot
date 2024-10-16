package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{
	
	// Inyectar el servicio
	@Autowired
	LibroRepository libroRepo;
	
	@Override
	public LibroModel guardaLibro(LibroModel libro) {
		
		LibroModel result = new LibroModel();
		
		try {
			result = libroRepo.save(libro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[guardaLibro] exception: " + e.getMessage());
		}
		
		return result;
	}
	@Override
	public LibroModel getLibroByID(Integer id) {
		
		LibroModel result = new LibroModel();
		
		try {
			//result = libroRepo.getReferenceById(id);
			result = libroRepo.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[getLibroByID] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public List<LibroModel> getAllLibros(){
		List<LibroModel> result = new ArrayList<LibroModel>();
		
		try {
			result = libroRepo.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[getAllLibros] exception: " + e.getMessage());
		}
		return result;
	}
	
	public void deleteByID(Integer id) {
		
		try {
			libroRepo.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[deleteById] exception: " + e.getMessage());
		}
	}
	
	public LibroModel updateLibro(LibroModel libro) {
		
		LibroModel result = new LibroModel();
		
		try {
			if (libroRepo.existsById(libro.getIdLibro())) {
				result = libroRepo.save(libro);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[updateLibro] exception: " + e.getMessage());
		}
		
		return result;
	}

}
