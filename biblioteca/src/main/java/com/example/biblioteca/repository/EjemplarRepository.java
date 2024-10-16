package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.EjemplarModel;

@Repository
public interface EjemplarRepository extends JpaRepository<EjemplarModel, Integer>{

}
