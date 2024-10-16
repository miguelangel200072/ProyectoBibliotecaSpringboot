package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Integer> {
}
