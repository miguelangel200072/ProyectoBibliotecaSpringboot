package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.AutorModel;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService{
	
	@Autowired
	AutorRepository autorRepo;
	
	public AutorModel guardaAutor(AutorModel autor) {
		
		AutorModel result = new AutorModel();
		
		try {
			result = autorRepo.save(autor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[guardaAutor] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public AutorModel getAutorByID(Integer id) {
		
		AutorModel result = new AutorModel();
		
		try {
			result = autorRepo.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[getAutorByID] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public List<AutorModel> getAllAutores(){
		
		List<AutorModel> result = new ArrayList<AutorModel>();
		
		try {
			result = autorRepo.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[getAllAutores] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public void deleteAutorByID(Integer id) {
		
		try {
			autorRepo.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[deleteAutorByID] exception: " + e.getMessage());
		}
	}
	
	@Override
	public AutorModel updateAutor(AutorModel autor) {
	    AutorModel result = new AutorModel();

	    try {
	        if (autorRepo.existsById(autor.getIdAutor())) {
	            result = autorRepo.save(autor);
	        }
	    } catch (Exception e) {
	        System.out.println("[updateAutor] exception: " + e.getMessage());
	    }

	    return result;
	}


}
