package com.example.biblioteca.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "AUTOR_LIBRO", // Tabla intermedia
        joinColumns = @JoinColumn(name = "idLibro"),
        inverseJoinColumns = @JoinColumn(name = "idAutor")
    )
    @JsonIgnoreProperties("libros") // Evita problemas de recursión
    private List<AutorModel> autores;

	public List<AutorModel> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorModel> autores) {
		this.autores = autores;
	}

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
