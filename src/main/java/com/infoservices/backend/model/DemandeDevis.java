
package com.infoservices.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "demandes_devis")
public class DemandeDevis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String telephone;

    private String description;

    private String urgence;

    private BigDecimal budget;

    @Column(name = "date_souhaitee")
    private LocalDate dateSouhaitee;

    // Relation avec Service
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;


    // ==============================
    // Constructeur vide
    // ==============================
    public DemandeDevis() {
    }


    // ==============================
    // Getters et Setters
    // ==============================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrgence() {
        return urgence;
    }

    public void setUrgence(String urgence) {
        this.urgence = urgence;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public LocalDate getDateSouhaitee() {
        return dateSouhaitee;
    }

    public void setDateSouhaitee(LocalDate dateSouhaitee) {
        this.dateSouhaitee = dateSouhaitee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
