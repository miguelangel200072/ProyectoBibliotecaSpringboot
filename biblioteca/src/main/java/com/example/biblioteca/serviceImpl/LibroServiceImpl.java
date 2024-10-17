package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.IdiomaModel;
import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.repository.IdiomaRepository;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{
	
	// Inyectar el servicio
	@Autowired
	LibroRepository libroRepo;
	
	@Autowired
    private IdiomaRepository idiomaRepo; // Inyección del repositorio de Idioma
    
    @Override
    public LibroModel guardaLibro(LibroModel libro) {
        try {
            // Verifica que el idioma está configurado y existe
            if (libro.getidIdioma() != null) {
                Optional<IdiomaModel> idiomaExistente = idiomaRepo.findById(libro.getidIdioma().getIdIdioma());
                if (idiomaExistente.isPresent()) {
                    libro.setidIdioma(idiomaExistente.get());
                } else {
                    // Manejo si el idioma no existe
                    System.out.println("[guardaLibro] Idioma no encontrado: " + libro.getidIdioma().getIdIdioma());
                    return null;
                }
            }

            return libroRepo.save(libro);
        } catch (Exception e) {
            System.out.println("[guardaLibro] exception: " + e.getMessage());
            return null;
        }
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
        try {
            if (libroRepo.existsById(libro.getIdLibro())) {
                // Verifica que el idioma existe
                if (libro.getidIdioma() != null) {
                    Optional<IdiomaModel> idiomaExistente = idiomaRepo.findById(libro.getidIdioma().getIdIdioma());
                    if (idiomaExistente.isPresent()) {
                        libro.setidIdioma(idiomaExistente.get());
                    } else {
                        System.out.println("[updateLibro] Idioma no encontrado: " + libro.getidIdioma().getIdIdioma());
                        return null;
                    }
                }

                return libroRepo.save(libro);
            }
        } catch (Exception e) {
            System.out.println("[updateLibro] exception: " + e.getMessage());
        }
        return null;
    }

}
