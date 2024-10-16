package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.model.SocioModel;

public interface SocioRepository extends JpaRepository<SocioModel, Integer>{

}
