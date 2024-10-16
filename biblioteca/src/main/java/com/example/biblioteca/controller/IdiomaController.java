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

import com.example.biblioteca.model.IdiomaModel;
import com.example.biblioteca.service.IdiomaService;

@RestController
@RequestMapping(value = "/idioma")
public class IdiomaController {

    @Autowired
    IdiomaService idiomaService;

    @PostMapping(value = "/save")
    public IdiomaModel guardaIdioma(@RequestBody IdiomaModel idioma) {
        IdiomaModel result = new IdiomaModel();
        result = idiomaService.guardaIdioma(idioma);
        return result;
    }

    @GetMapping(value = "/get/{id}")
    public IdiomaModel getByID(@PathVariable(value = "id") Integer id) {
        IdiomaModel result = new IdiomaModel();
        result = idiomaService.getIdiomaByID(id);
        return result;
    }

    @GetMapping(value = "/getAll")
    public List<IdiomaModel> getAllIdiomas() {
        List<IdiomaModel> result = new ArrayList<>();
        result = idiomaService.getAllIdiomas();
        return result;
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteIdiomaByID(@PathVariable(value = "id") Integer id) {
        idiomaService.deleteIdiomaByID(id);
    }

    @PutMapping(value = "/update")
    public IdiomaModel updateIdioma(@RequestBody IdiomaModel idioma) {
        IdiomaModel result = new IdiomaModel();
        result = idiomaService.updateIdioma(idioma);
        return result;
    }
}
