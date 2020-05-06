/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 * @version 07/04/20 22:12
 * @author maddie
 */
@Entity
public class Employe extends Personne {
    
    protected boolean disponible;
    private String genre;
    @OneToMany(mappedBy="employe")
    private List<Consultation> listeConsultations;
    
    public Employe(String nom, String prenom, String mail, String motDePasse, String telephone, String genre) {
        super(nom, prenom, mail, motDePasse, telephone);
        disponible = true;
        this.genre = genre;
    }
    
    protected Employe() {
    }

    public List<Consultation> getListeConsultations() {
        return listeConsultations;
    }

    public void setListeConsultations(List<Consultation> listeConsultations) {
        this.listeConsultations = listeConsultations;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    @Override
    public String toString() {
        return "Employe : id=" + this.getId()+ ", nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", mail=" + this.getMail() + ", motDePasse=" + this.getMotDePasse() + "Telephone=" + this.getTelephone();
    }
    
    public void creerConsultation() {
        
    }
    
}
