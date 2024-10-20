package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{

	UsuarioModel findByUsername(String username);

}
