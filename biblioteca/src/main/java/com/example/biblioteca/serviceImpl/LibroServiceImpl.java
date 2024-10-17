package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.AutorModel;
import com.example.biblioteca.model.IdiomaModel;
import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.model.TemaModel;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.IdiomaRepository;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.repository.TemaRepository;
import com.example.biblioteca.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroRepository libroRepo;
	
	@Autowired
	AutorRepository autorRepo;
	
	@Autowired
    private IdiomaRepository idiomaRepo;
	
	@Autowired
    TemaRepository temaRepo;
    


	@Override
	public LibroModel guardaLibro(LibroModel libro) {
	    try {
	        // Verifica que el idioma está existe
	        if (libro.getidIdioma() != null) {
	            Optional<IdiomaModel> idiomaExistente = idiomaRepo.findById(libro.getidIdioma().getIdIdioma());
	            if (idiomaExistente.isPresent()) {
	                libro.setidIdioma(idiomaExistente.get());
	            } else {
	                System.out.println("[guardaLibro] Idioma no encontrado: " + libro.getidIdioma().getIdIdioma());
	                return null;
	            }
	        }

	        // Manejo de los autores
	        List<AutorModel> autoresGestionados = new ArrayList<>();
	        if (libro.getAutores() != null) {
	            for (AutorModel autor : libro.getAutores()) {
	                Optional<AutorModel> autorExistente = autorRepo.findById(autor.getIdAutor());
	                if (autorExistente.isPresent()) {
	                    autoresGestionados.add(autorExistente.get());
	                } else {
	                    System.out.println("[guardaLibro] Autor no encontrado: " + autor.getIdAutor());
	                    return null;
	                }
	            }
	        }
	        libro.setAutores(autoresGestionados);

	        // Manejo de los temas
	        List<TemaModel> temasGestionados = new ArrayList<>();
	        if (libro.getLst_temas() != null) {
	            for (TemaModel tema : libro.getLst_temas()) {
	                Optional<TemaModel> temaExistente = temaRepo.findById(tema.getIdTema());
	                if (temaExistente.isPresent()) {
	                    temasGestionados.add(temaExistente.get());
	                } else {
	                    System.out.println("[guardaLibro] Tema no encontrado: " + tema.getIdTema());
	                    return null;
	                }
	            }
	        }
	        libro.setLst_temas(temasGestionados);

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
			result = libroRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("[getLibroByID] exception: " + e.getMessage());
		}
		
		return result;
	}
	
	public List<LibroModel> getAllLibros(){
		List<LibroModel> result = new ArrayList<LibroModel>();
		
		try {
			result = libroRepo.findAll();
		} catch (Exception e) {
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

	            // Manejo de los autores
	            List<AutorModel> autoresGestionados = new ArrayList<>();
	            if (libro.getAutores() != null) {
	                for (AutorModel autor : libro.getAutores()) {
	                    Optional<AutorModel> autorExistente = autorRepo.findById(autor.getIdAutor());
	                    if (autorExistente.isPresent()) {
	                        autoresGestionados.add(autorExistente.get());
	                    } else {
	                        System.out.println("[updateLibro] Autor no encontrado: " + autor.getIdAutor());
	                        return null;
	                    }
	                }
	            }
	            libro.setAutores(autoresGestionados);

	            // Manejo de los temas
	            List<TemaModel> temasGestionados = new ArrayList<>();
	            if (libro.getLst_temas() != null) {
	                for (TemaModel tema : libro.getLst_temas()) {
	                    Optional<TemaModel> temaExistente = temaRepo.findById(tema.getIdTema());
	                    if (temaExistente.isPresent()) {
	                        temasGestionados.add(temaExistente.get());
	                    } else {
	                        System.out.println("[updateLibro] Tema no encontrado: " + tema.getIdTema());
	                        return null;
	                    }
	                }
	            }
	            libro.setLst_temas(temasGestionados);


	            return libroRepo.save(libro);
	        } else {
	            System.out.println("[updateLibro] El libro no existe con ID: " + libro.getIdLibro());
	            return null;
	        }
	    } catch (Exception e) {
	        System.out.println("[updateLibro] exception: " + e.getMessage());
	        return null;
	    }
	}



}
