package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.EjemplarModel;
import com.example.biblioteca.model.IdiomaModel;
import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.repository.EjemplarRepository;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.service.EjemplarService;

@Service
public class EjemplarServiceImpl implements EjemplarService{
	
	@Autowired
	EjemplarRepository ejemplarRepo;
	
	@Autowired
	LibroRepository libroRepo;
	
	public EjemplarModel guardaEjemplar(EjemplarModel ejemplar) {
		
		try {
            // Verifica que el idioma existe
            if (ejemplar.getId_libro() != null) {
                Optional<LibroModel> LibroExistente = libroRepo.findById(ejemplar.getId_libro().getIdLibro());
                if (LibroExistente.isPresent()) {
                	ejemplar.setId_libro(LibroExistente.get());
                } else {
                    System.out.println("[guardaEjemplar] Libro no encontrado: " + ejemplar.getId_libro().getIdLibro());
                    return null;
                }
            }

            return ejemplarRepo.save(ejemplar);
        } catch (Exception e) {
            System.out.println("[guardaLibro] exception: " + e.getMessage());
            return null;
        }
	}
	public EjemplarModel getEjemplarByID(Integer id) {
		
		EjemplarModel result = new EjemplarModel();
		
		try {
			result = ejemplarRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("[getEjemplarByID] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public List<EjemplarModel> getAllEjemplares(){
		
		List<EjemplarModel> result = new ArrayList<>();
		
		try {
			result = ejemplarRepo.findAll();
		} catch (Exception e) {
			System.out.println("[getAllEjemplares] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public void deleteEjemplarByID(Integer id) {
		
		try {
			ejemplarRepo.deleteById(id);
		} catch (Exception e) {
			System.out.println("[deleteEjemplarByID] exception: " + e.getMessage());
		}
	}
	
	public EjemplarModel updateEjemplar(EjemplarModel ejemplar) {
	    try {
	        // Verifica que el ejemplar existe en la base de datos
	        if (ejemplarRepo.existsById(ejemplar.getId())) {
	            if (ejemplar.getId_libro() != null) {
	                Optional<LibroModel> libroExistente = libroRepo.findById(ejemplar.getId_libro().getIdLibro());
	                if (libroExistente.isPresent()) {
	                    ejemplar.setId_libro(libroExistente.get());
	                } else {
	                    System.out.println("[updateEjemplar] Libro no encontrado: " + ejemplar.getId_libro().getIdLibro());
	                    return null;
	                }
	            }

	            return ejemplarRepo.save(ejemplar);
	        } else {
	            System.out.println("[updateEjemplar] Ejemplar no encontrado: " + ejemplar.getId());
	            return null;
	        }
	    } catch (Exception e) {
	        System.out.println("[updateEjemplar] exception: " + e.getMessage());
	        return null;
	    }
	}


}
