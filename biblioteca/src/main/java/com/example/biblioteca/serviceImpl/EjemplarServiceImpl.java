package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.EjemplarModel;
import com.example.biblioteca.repository.EjemplarRepository;
import com.example.biblioteca.service.EjemplarService;

@Service
public class EjemplarServiceImpl implements EjemplarService{
	
	@Autowired
	EjemplarRepository ejemplarRepo;
	
	public EjemplarModel guardaEjemplar(EjemplarModel ejemplar) {
		
		EjemplarModel result = new EjemplarModel();
		
		try {
			result = ejemplarRepo.save(ejemplar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[guardaEjemplar] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public EjemplarModel getEjemplarByID(Integer id) {
		
		EjemplarModel result = new EjemplarModel();
		
		try {
			result = ejemplarRepo.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[getEjemplarByID] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public List<EjemplarModel> getAllEjemplares(){
		
		List<EjemplarModel> result = new ArrayList<>();
		
		try {
			result = ejemplarRepo.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[getAllEjemplares] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public void deleteEjemplarByID(Integer id) {
		
		try {
			ejemplarRepo.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[deleteEjemplarByID] exception: " + e.getMessage());
		}
	}
	
	public EjemplarModel updateEjemplar(EjemplarModel ejemplar) {
		
		EjemplarModel result = new EjemplarModel();
		
		try {
			if (ejemplarRepo.existsById(ejemplar.getId())) {
				
				result = ejemplarRepo.save(ejemplar);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[updateEjemplar] exception: " + e.getMessage());
		}
		
		return result;
	}

}
