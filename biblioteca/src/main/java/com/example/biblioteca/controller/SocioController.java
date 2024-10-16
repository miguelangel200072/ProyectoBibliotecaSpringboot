package com.example.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.SocioModel;
import com.example.biblioteca.service.SocioService;

@RestController
@RequestMapping(value = "/socio")
public class SocioController {

    @Autowired
    SocioService socioService;
    
    @PostMapping(value = "/save")
    public SocioModel guardaSocio(@RequestBody SocioModel socio) {
        
        SocioModel result = new SocioModel();
        result = socioService.guardaSocio(socio);
        
        return result;
    }
    
    @GetMapping(value = "/get/{id}")
    public SocioModel getByID(@PathVariable(value="id") Integer id) {
        
        SocioModel result = new SocioModel();
        result = socioService.getSocioByID(id);
        
        return result;
    }
    
    @GetMapping(value = "/getAll")
    public List<SocioModel> getAllSocios() {
        
        List<SocioModel> result = new ArrayList<>();
        result = socioService.getAllSocios();
        
        return result;
    }
    
    @DeleteMapping(value="/delete/{id}")
    public void deleteSocioByID(@PathVariable(value="id") Integer id) {
        
        socioService.deleteSocioByID(id);
    }
    
    @PutMapping(value="/update")
    public SocioModel updateSocio(@RequestBody SocioModel socio) {
        
        SocioModel result = new SocioModel();
        result = socioService.updateSocio(socio);
        
        return result;
    }
}