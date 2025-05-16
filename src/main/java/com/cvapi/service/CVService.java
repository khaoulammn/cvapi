package com.cvapi.service;

import com.cvapi.model.CV;
import com.cvapi.repository.CVRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service

public class CVService {

    @Autowired
    private CVRepository cvRepository;

   // Enregistrer un CV (dépôt) : recevoir un objet complet
    public CV uploadCv(CV cv) {
        cv.setDateDepot(LocalDate.now());  // On fixe la date ici
        return cvRepository.save(cv);
    }

    // Simuler une extraction OCR
    public CV extractFromPdf(Long id) {
        Optional<CV> optionalCV = cvRepository.findById(id);
        if (optionalCV.isPresent()) {
            CV cv = optionalCV.get();

            // Extraction simulée : on ajoute des données fictives
            cv.setNom("Exemple Nom");
            cv.setEmail("exemple@email.com");
            cv.setCompetences(Arrays.asList("Java", "Spring Boot", "SQL"));

            return cvRepository.save(cv);
        }
        return null;
    }

    // Récupérer tous les CVs
    public List<CV> getAllCvs() {
        return cvRepository.findAll();
    }

    // Récupérer un CV par son ID
    public CV getCvById(Long id) {
        return cvRepository.findById(id).orElse(null);
    }
}