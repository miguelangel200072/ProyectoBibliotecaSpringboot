package com.example.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.EjemplarModel;
import com.example.biblioteca.model.SocioModel;
import com.example.biblioteca.repository.EjemplarRepository;
import com.example.biblioteca.repository.SocioRepository;
import com.example.biblioteca.service.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    SocioRepository socioRepo;
    
    @Autowired
    EjemplarRepository ejemplarRepo;

    @Override
    public SocioModel guardaSocio(SocioModel socio) {
        List<EjemplarModel> ejemplares = new ArrayList<>();
        
        // Verifica si la lista de ejemplares no es nula
        if (socio.getLst_ejemplares() != null) {
            // Para cada ejemplar en la lista, busca el ejemplar en la base de datos
            for (EjemplarModel ejemplar : socio.getLst_ejemplares()) {
                EjemplarModel managedEjemplar = ejemplarRepo.findById(ejemplar.getId()).orElse(null);
                if (managedEjemplar != null) {
                    ejemplares.add(managedEjemplar); // Solo añade si el ejemplar existe
                }
            }
        }

        // Asigna los ejemplares gestionados al socio
        socio.setLst_ejemplares(ejemplares);

        // Guarda el socio en la base de datos
        return socioRepo.save(socio);
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
            // Verifica si el socio existe
            if (socioRepo.existsById(socio.getIdSocio())) {

                List<EjemplarModel> ejemplares = new ArrayList<>();
                
                // Verifica si la lista de ejemplares no es nula
                if (socio.getLst_ejemplares() != null) {
                    // Para cada ejemplar en la lista, busca el ejemplar en la base de datos
                    for (EjemplarModel ejemplar : socio.getLst_ejemplares()) {
                        EjemplarModel managedEjemplar = ejemplarRepo.findById(ejemplar.getId()).orElse(null);
                        if (managedEjemplar != null) {
                            ejemplares.add(managedEjemplar); // Solo añade si el ejemplar existe
                        }
                    }
                }
                
                // Asigna los ejemplares gestionados al socio
                socio.setLst_ejemplares(ejemplares);
                
                // Actualiza el socio en la base de datos
                result = socioRepo.save(socio);
            }
        } catch (Exception e) {
            System.out.println("[updateSocio] exception: " + e.getMessage());
        }
        return result;
    }

}