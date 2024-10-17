package com.example.biblioteca.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name="EJEMPLAR")
public class EjemplarModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "idLibro")
	private LibroModel idLibro;
	
	@ManyToMany(cascade = {CascadeType.ALL},
			mappedBy = "lst_ejemplares")
	@JsonIgnoreProperties("lst_ejemplares")
	private List<SocioModel> lst_socios;
	
	public List<SocioModel> getLst_socios() {
		return lst_socios;
	}

	public void setLst_socios(List<SocioModel> lst_socios) {
		this.lst_socios = lst_socios;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LibroModel getId_libro() {
		return idLibro;
	}

	public void setId_libro(LibroModel id_libro) {
		this.idLibro = id_libro;
	}


	
}
