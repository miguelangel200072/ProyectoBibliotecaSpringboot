package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.IdiomaModel;

@Repository
public interface IdiomaRepository extends JpaRepository<IdiomaModel, Integer> {
}
