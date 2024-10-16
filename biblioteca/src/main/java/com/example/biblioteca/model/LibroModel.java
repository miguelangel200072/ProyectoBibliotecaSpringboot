package com.example.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIBRO")
public class LibroModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idLibro;
	
	private Integer anio;
	
	private String titulo;
	
	private Integer idIdioma;

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getidIdioma() {
		return idIdioma;
	}

	public void setidIdioma(Integer id_idioma) {
		this.idIdioma = id_idioma;
	}

}
