/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import javax.persistence.Entity;
/**
 * @version 07/04/20 22:12
 * @author maddie
 */
@Entity
public class Employe extends Personne {
    
    private String genre;
    public Employe(String nom, String prenom, String mail, String motDePasse, String telephone, String genre) {
        super(nom, prenom, mail, motDePasse, telephone);
        this.genre= genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    protected Employe() {
    }
    
    @Override
    public String toString() {
        return "Employe : id=" + this.getId()+ ", nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", mail=" + this.getMail() + ", motDePasse=" + this.getMotDePasse() + "Telephone=" + this.getTelephone();
    }
    
}
