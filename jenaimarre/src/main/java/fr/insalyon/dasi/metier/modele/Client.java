/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import javax.persistence.Entity;
/**
 * @version 01/04/20 13:05
 * @author 
 */
@Entity
public class Client extends Personne {
    
    private String civilite;
    private String dateDeNaissance;
    
    public Client(String nom, String prenom, String mail, String motDePasse, String telephone) {
        super(nom, prenom, mail, motDePasse, telephone);
        
    }
    
    protected Client() {
    }
    

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }
    
    @Override
    public String toString() {
        return "Client : id=" + this.getId()+ ", nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", mail=" + this.getMail() + ", motDePasse=" + this.getMotDePasse() + "Telephone=" + this.getTelephone();
    }
    
}
