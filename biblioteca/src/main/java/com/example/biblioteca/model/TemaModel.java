package com.example.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
@Table(name = "tema")
public class TemaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTema;


    private String descripcion;
    
    @ManyToMany(mappedBy = "lst_temas", cascade = {CascadeType.ALL})
    @JsonIgnoreProperties("lst_temas")
    private List<LibroModel> lst_libros;


    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<LibroModel> getLst_libros() {
        return lst_libros;
    }

    public void setLst_libros(List<LibroModel> lst_libros) {
        this.lst_libros = lst_libros;
    }
}
