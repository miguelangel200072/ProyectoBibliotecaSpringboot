package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.AutorModel;
import com.example.biblioteca.model.IdiomaModel;
import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.IdiomaRepository;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{
	
	// Inyectar el servicio
	@Autowired
	LibroRepository libroRepo;
	
	@Autowired
	AutorRepository autorRepo;
	
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
	                System.out.println("[guardaLibro] Idioma no encontrado: " + libro.getidIdioma().getIdIdioma());
	                return null;
	            }
	        }

	        // Maneja los autores
	        if (libro.getAutores() != null) {
	            List<AutorModel> autoresGestionados = new ArrayList<>();
	            for (AutorModel autor : libro.getAutores()) {
	                Optional<AutorModel> autorExistente = autorRepo.findById(autor.getIdAutor());
	                if (autorExistente.isPresent()) {
	                    autoresGestionados.add(autorExistente.get());
	                }
	            }
	            libro.setAutores(autoresGestionados);
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
	
	@Override
	public LibroModel updateLibro(LibroModel libro) {
	    try {
	        // Verifica que el libro existe
	        Optional<LibroModel> libroExistente = libroRepo.findById(libro.getIdLibro());
	        if (libroExistente.isPresent()) {
	            // Actualiza los campos del libro
	            LibroModel libroActualizado = libroExistente.get();
	            libroActualizado.setAnio(libro.getAnio());
	            libroActualizado.setTitulo(libro.getTitulo());
	            libroActualizado.setidIdioma(libro.getidIdioma());

	            // Actualiza la lista de autores
	            List<AutorModel> autoresActualizados = new ArrayList<>();
	            for (AutorModel autor : libro.getAutores()) {
	                AutorModel autorExistente = autorRepo.findById(autor.getIdAutor()).orElse(null);
	                if (autorExistente != null) {
	                    autoresActualizados.add(autorExistente);
	                }
	            }
	            libroActualizado.setAutores(autoresActualizados);

	            return libroRepo.save(libroActualizado);
	        } else {
	            System.out.println("[updateLibro] Libro no encontrado");
	            return null; // o lanzar excepción
	        }
	    } catch (Exception e) {
	        System.out.println("[updateLibro] exception: " + e.getMessage());
	        return null; // o lanzar excepción
	    }
	}


}
