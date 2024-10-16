package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.SocioModel;

public interface SocioService {

    public SocioModel guardaSocio(SocioModel socio);

    public SocioModel getSocioByID(Integer id);

    public List<SocioModel> getAllSocios();

    public void deleteSocioByID(Integer id);

    public SocioModel updateSocio(SocioModel socio);
}