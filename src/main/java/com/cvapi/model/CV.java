package com.cvapi.model;

// Imports pour les annotations JPA et types utiles
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

/// Dit à Spring : cette classe correspond à une table SQL
@Entity
public class    CV {
    @Id //identifiant unique
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; // id généré automatiquement

    private String nomFichier;
    private String nom;
    private String email;

    @ElementCollection // pour stocker une liste simple (de Strings)
    private List<String> competences;

    private LocalDate dateDepot;

    // declaration des geters et setters

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id= id;
    }
     public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public LocalDate getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
    }

}
