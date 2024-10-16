package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.SocioModel;
import com.example.biblioteca.repository.SocioRepository;
import com.example.biblioteca.service.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    SocioRepository socioRepo;

    @Override
    public SocioModel guardaSocio(SocioModel socio) {
        SocioModel result = new SocioModel();
        try {
            result = socioRepo.save(socio);
        } catch (Exception e) {
            System.out.println("[guardaSocio] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public SocioModel getSocioByID(Integer id) {
        SocioModel result = new SocioModel();
        try {
            result = socioRepo.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("[getSocioByID] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<SocioModel> getAllSocios() {
        List<SocioModel> result = new ArrayList<>();
        try {
            result = socioRepo.findAll();
        } catch (Exception e) {
            System.out.println("[getAllSocios] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void deleteSocioByID(Integer id) {
        try {
            socioRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteSocioByID] exception: " + e.getMessage());
        }
    }

    @Override
    public SocioModel updateSocio(SocioModel socio) {
        SocioModel result = new SocioModel();
        try {
            if (socioRepo.existsById(socio.getIdSocio())) {
                result = socioRepo.save(socio);
            }
        } catch (Exception e) {
            System.out.println("[updateSocio] exception: " + e.getMessage());
        }
        return result;
    }
}