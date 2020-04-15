/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import fr.insalyon.dasi.metier.service.Service;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 * @version 15/04/20 GMT-5 09:34
 * @author Comtois
 */
@Entity
public class Consultation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String Commentaire;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateHeureDemande;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateHeureDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateHeureFin;

    protected Consultation() {
    }
    
    public Consultation(Date DateHeureDemande) {
        this.DateHeureDemande = DateHeureDemande;
        
    }

    @Override
    public String toString() {
        return "Consultation{" + "Commentaire=" + Commentaire + ", DateHeureDemande=" + DateHeureDemande + ", DateHeureDebut=" + DateHeureDebut + ", DateHeureFin=" + DateHeureFin + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public Date getDateHeureDemande() {
        return DateHeureDemande;
    }

    public void setDateHeureDemande(Date DateHeureDemande) {
        this.DateHeureDemande = DateHeureDemande;
    }

    public Date getDateHeureDebut() {
        return DateHeureDebut;
    }

    public void setDateHeureDebut(Date DateHeureDebut) {
        this.DateHeureDebut = DateHeureDebut;
    }

    public Date getDateHeureFin() {
        return DateHeureFin;
    }

    public void setDateHeureFin(Date DateHeureFin) {
        this.DateHeureFin = DateHeureFin;
    }
    
    public void listerMedium() {
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
        
    }
    
}
