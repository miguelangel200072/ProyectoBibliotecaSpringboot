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

import com.example.biblioteca.model.TemaModel;
import com.example.biblioteca.service.TemaService;

@RestController
@RequestMapping(value = "/tema")
public class TemaController {

    @Autowired
    TemaService temaService;

    @PostMapping(value = "/save")
    public TemaModel guardaTema(@RequestBody TemaModel tema) {
        TemaModel result = new TemaModel();
        result = temaService.guardaTema(tema);
        return result;
    }

    @GetMapping(value = "/get/{id}")
    public TemaModel getByID(@PathVariable(value = "id") Integer id) {
        TemaModel result = new TemaModel();
        result = temaService.getTemaByID(id);
        return result;
    }

    @GetMapping(value = "/getAll")
    public List<TemaModel> getAllTemas() {
        List<TemaModel> result = new ArrayList<>();
        result = temaService.getAllTemas();
        return result;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteTemaByID(@PathVariable(value = "id") Integer id) {
        temaService.deleteTemaByID(id);
    }

    @PutMapping(value = "/update")
    public TemaModel updateTema(@RequestBody TemaModel tema) {
        TemaModel result = new TemaModel();
        result = temaService.updateTema(tema);
        return result;
    }
}
