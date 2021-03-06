/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * @version 15/04/20 GMT-5 09:34
 * @author Madeleine Comtois & Corentin Bel
 */
@Entity
public class Consultation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String Commentaire;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date DateHeureDemande;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date DateHeureDebut;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date DateHeureFin;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Medium medium;
    @ManyToOne
    private Employe employe;
    private String etat= null;

    protected Consultation() {
    }
    
    public Consultation(Client client, Employe employe, Medium medium) {
        this.DateHeureDemande = new Date();
        this.client = client;
        this.employe = employe;
        this.medium = medium;
        
    }

    @Override
    public String toString() {
        return "Consultation{" + "Commentaire=" + Commentaire + ", DateHeureDemande=" + DateHeureDemande + ", DateHeureDebut=" + DateHeureDebut + ", DateHeureFin=" + DateHeureFin + '}';
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
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
       
}
