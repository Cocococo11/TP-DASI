/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.util.Date;
import java.util.List;

/**
 * @version 08/04/20 19:00 GMT-5
 * @author 
 */
public class Client extends Personne {
    
    private ProfilAstro profil;
    Date dateNaissance;
    List<String> profilAttributs;
    
    public Client(String nom, String prenom, String mail, String motDePasse, String telephone, Date dateNaissance) {
        super(nom, prenom, mail, motDePasse, telephone);
        
        profil = new ProfilAstro();
        this.dateNaissance = dateNaissance;
    }
    
    /*
    Affecter la liste avec les valeurs du profil astro
    */
    private void definirAttributs() {
        try {
            profilAttributs = profil.getProfil(nom, dateNaissance);
        }
        catch(Exception e) {
            System.out.println("/!\\ Erreur d'affectation de la liste des attributs du profil astro !\\");
        }
    }
    
    @Override
    public String toString() {
        return "Client : id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date de Naissance=" + dateNaissance + ", mail=" + mail + ", motDePasse=" + motDePasse + "Telephone=" + telephone;
    }
   
   
   
    
  
}
