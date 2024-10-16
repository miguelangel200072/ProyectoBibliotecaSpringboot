package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.IdiomaModel;
import com.example.biblioteca.repository.IdiomaRepository;
import com.example.biblioteca.service.IdiomaService;

@Service
public class IdiomaServiceImpl implements IdiomaService {

    @Autowired
    IdiomaRepository idiomaRepo;

    @Override
    public IdiomaModel guardaIdioma(IdiomaModel idioma) {
        IdiomaModel result = new IdiomaModel();
        try {
            result = idiomaRepo.save(idioma);
        } catch (Exception e) {
            System.out.println("[guardaIdioma] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public IdiomaModel getIdiomaByID(Integer id) {
        IdiomaModel result = new IdiomaModel();
        try {
            result = idiomaRepo.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[getIdiomaByID] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<IdiomaModel> getAllIdiomas() {
        List<IdiomaModel> result = new ArrayList<>();
        try {
            result = idiomaRepo.findAll();
        } catch (Exception e) {
            System.out.println("[getAllIdiomas] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void deleteIdiomaByID(Integer id) {
        try {
            idiomaRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteIdiomaByID] exception: " + e.getMessage());
        }
    }

    @Override
    public IdiomaModel updateIdioma(IdiomaModel idioma) {
        IdiomaModel result = new IdiomaModel();
        try {
            if (idiomaRepo.existsById(idioma.getIdIdioma())) {
                result = idiomaRepo.save(idioma);
            }
        } catch (Exception e) {
            System.out.println("[updateIdioma] exception: " + e.getMessage());
        }
        return result;
    }
}
