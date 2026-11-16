package com.infoservices.backend.controller;

import com.infoservices.backend.model.DemandeDevis;
import com.infoservices.backend.repository.DemandeDevisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devis")
@CrossOrigin(origins = "*")
public class DemandeDevisController {

    private final DemandeDevisRepository demandeDevisRepository;

    public DemandeDevisController(DemandeDevisRepository demandeDevisRepository) {
        this.demandeDevisRepository = demandeDevisRepository;
    }

    @PostMapping
    public ResponseEntity<?> creerDemandeDevis(@RequestBody DemandeDevis demandeDevis) {
        try {
            // On ne vérifie PLUS le service_id, parce qu'il n'existe plus
            // On vérifie juste que la personne a bien tapé son service recherché
            if (demandeDevis.getServiceRecherche() == null || demandeDevis.getServiceRecherche().isBlank()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Veuillez taper le service recherché.");
            }

            DemandeDevis nouvelleDemande = demandeDevisRepository.save(demandeDevis);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(nouvelleDemande);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur serveur : " + e.getMessage());
        }
    }
}