package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.TemaModel;
import com.example.biblioteca.repository.TemaRepository;
import com.example.biblioteca.service.TemaService;

@Service
public class TemaServiceImpl implements TemaService {

    @Autowired
    TemaRepository temaRepo;

    @Override
    public TemaModel guardaTema(TemaModel tema) {
        TemaModel result = new TemaModel();
        try {
            result = temaRepo.save(tema);
        } catch (Exception e) {
            System.out.println("[guardaTema] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public TemaModel getTemaByID(Integer id) {
        TemaModel result = new TemaModel();
        try {
            result = temaRepo.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[getTemaByID] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<TemaModel> getAllTemas() {
        List<TemaModel> result = new ArrayList<>();
        try {
            result = temaRepo.findAll();
        } catch (Exception e) {
            System.out.println("[getAllTemas] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void deleteTemaByID(Integer id) {
        try {
            temaRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteTemaByID] exception: " + e.getMessage());
        }
    }

    @Override
    public TemaModel updateTema(TemaModel tema) {
        TemaModel result = new TemaModel();
        try {
            if (temaRepo.existsById(tema.getIdTema())) {
                result = temaRepo.save(tema);
            }
        } catch (Exception e) {
            System.out.println("[updateTema] exception: " + e.getMessage());
        }
        return result;
    }
}
