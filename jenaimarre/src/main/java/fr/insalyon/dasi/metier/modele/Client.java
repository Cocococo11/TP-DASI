/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.Embedded;
import javax.persistence.TemporalType;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @version 08/04/20 19:00 GMT-5
 * @author Madeleine Comtois & Corentin Bel
 */
@Entity
public class Client extends Personne {
    
    @Embedded
    private ProfilAstro profilAstroClient;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    public List<String> profilAttributs;
    @OneToMany(mappedBy="client")
    private List<Consultation> listeConsultations;
    private String civilite;
    
    public Client(String nom, String prenom, String mail, String motDePasse, String telephone, Date dateNaissance, String civilite) {
        super(nom, prenom, mail, motDePasse, telephone);
        
        profilAstroClient = new ProfilAstro();
        this.dateNaissance = dateNaissance;
        this.civilite=civilite;
    }

    public List<Consultation> getListeConsultations() {
        return listeConsultations;
    }

    public void setListeConsultations(List<Consultation> listeConsultations) {
        this.listeConsultations = listeConsultations;
    }

    public ProfilAstro getProfilAstroClient() {
        return profilAstroClient;
    }

    public void setProfilAstroClient(ProfilAstro profilAstroClient) {
        this.profilAstroClient = profilAstroClient;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
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
    
    
    
    
    @Override
    public String toString() {
        return "Client : id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date de Naissance=" + dateNaissance + ", mail=" + mail + ", motDePasse=" + motDePasse + ", Telephone=" + telephone;

    }
   
  
}
