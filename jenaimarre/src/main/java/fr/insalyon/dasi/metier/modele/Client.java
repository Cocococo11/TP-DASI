/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import fr.insalyon.dasi.metier.service.Service;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Entity;

/**
 * @version 08/04/20 19:00 GMT-5
 * @author 
 */
@Entity
public class Client extends Personne {
    
    private ProfilAstro profil;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    private List<String> profilAttributs;
    private String civilite;
    
    public Client(String nom, String prenom, String mail, String motDePasse, String telephone, Date dateNaissance, String civilite) {
        super(nom, prenom, mail, motDePasse, telephone);
        
        profil = new ProfilAstro();
        this.dateNaissance = dateNaissance;
        this.civilite=civilite;
    }

    public ProfilAstro getProfil() {
        return profil;
    }

    public void setProfil(ProfilAstro profil) {
        this.profil = profil;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<String> getProfilAttributs() {
        return profilAttributs;
    }

    public void setProfilAttributs(List<String> profilAttributs) {
        this.profilAttributs = profilAttributs;
    }
    
     
    protected Client() {
        
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
    
    /*
    * Demander une consultation avec un medium
    */
    public void demanderConsultation() {
        System.out.println();
        System.out.println("**** Les Mediums ****");
        System.out.println();
        
        Service service = new Service();
        List<Medium> listeMediums = service.listerMediums();
        if (listeMediums != null) {
            for (Medium medium : listeMediums) {
                System.out.println("-> " + medium);
            }
        }
        else {
            System.out.println("=> ERREUR...");
        }
        
        long choix = 2;
        
    }
    
    @Override
    public String toString() {
        return "Client : id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date de Naissance=" + dateNaissance + ", mail=" + mail + ", motDePasse=" + motDePasse + "Telephone=" + telephone;

    }
   
  
}
