package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.EjemplarModel;

public interface EjemplarService {
	
	public EjemplarModel guardaEjemplar(EjemplarModel ejemplar);
	
	public EjemplarModel getEjemplarByID(Integer id);
	
	public List<EjemplarModel> getAllEjemplares();
	
	public void deleteEjemplarByID(Integer id);
	
	public EjemplarModel updateEjemplar(EjemplarModel ejemplar);

}
