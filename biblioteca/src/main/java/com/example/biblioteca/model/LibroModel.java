package com.example.biblioteca.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIBRO")
public class LibroModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLibro;
	
	private Integer anio;
	
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "idIdioma")
	private IdiomaModel idIdioma;
	
	@OneToMany(mappedBy = "idLibro")
	@JsonIgnore
	private List<EjemplarModel> ejemplares;

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

	public IdiomaModel getidIdioma() {
		return idIdioma;
	}

	public void setidIdioma(IdiomaModel id_idioma) {
		this.idIdioma = id_idioma;
	}

}
