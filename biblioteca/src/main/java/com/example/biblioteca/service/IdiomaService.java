package com.example.biblioteca.service;

import java.util.List;
import com.example.biblioteca.model.IdiomaModel;

public interface IdiomaService {

    public IdiomaModel guardaIdioma(IdiomaModel idioma);

    public IdiomaModel getIdiomaByID(Integer id);

    public List<IdiomaModel> getAllIdiomas();

    public void deleteIdiomaByID(Integer id);

    public IdiomaModel updateIdioma(IdiomaModel idioma);
}
