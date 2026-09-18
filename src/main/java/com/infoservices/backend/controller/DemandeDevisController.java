package com.infoservices.backend.controller;

import com.infoservices.backend.model.DemandeDevis;
import com.infoservices.backend.repository.DemandeDevisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devis")
@CrossOrigin(origins = "*") // 1. Autorise les requêtes provenant du frontend React
public class DemandeDevisController {

    private final DemandeDevisRepository demandeDevisRepository;

    public DemandeDevisController(DemandeDevisRepository demandeDevisRepository) {
        this.demandeDevisRepository = demandeDevisRepository;
    }

    @PostMapping
    public ResponseEntity<?> creerDemandeDevis(@RequestBody DemandeDevis demandeDevis) {
        try {
            // 2. Validation de l'association du service
            if (demandeDevis.getService() == null || demandeDevis.getService().getId() == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Le service sélectionné est invalide.");
            }

            DemandeDevis nouvelleDemande = demandeDevisRepository.save(demandeDevis);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(nouvelleDemande);
                    
        } catch (Exception e) {
            // Affiche l'erreur exacte dans la console Spring Boot pour le débogage
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur serveur : " + e.getMessage());
        }
    }
}