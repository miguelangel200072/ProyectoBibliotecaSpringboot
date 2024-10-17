package com.example.biblioteca.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SOCIO")
public class SocioModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSocio;
	
    private String nombre;

    private String domicilio;
    
    private String telefono;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
    		name="SOCIO_EJEMPLAR",
    		joinColumns=@JoinColumn(name="idSocio"),
    		inverseJoinColumns = @JoinColumn(name="id"))
    @JsonIgnoreProperties("lst_socios")
    private List<EjemplarModel> lst_ejemplares;
    
    public List<EjemplarModel> getLst_ejemplares() {
		return lst_ejemplares;
	}

	public void setLst_ejemplares(List<EjemplarModel> lst_ejemplares) {
		this.lst_ejemplares = lst_ejemplares;
	}

    
    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
