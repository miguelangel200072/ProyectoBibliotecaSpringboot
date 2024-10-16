package com.example.biblioteca.service;

import java.util.List;
import com.example.biblioteca.model.TemaModel;

public interface TemaService {

    public TemaModel guardaTema(TemaModel tema);

    public TemaModel getTemaByID(Integer id);

    public List<TemaModel> getAllTemas();

    public void deleteTemaByID(Integer id);

    public TemaModel updateTema(TemaModel tema);
}
