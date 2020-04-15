/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import fr.insalyon.dasi.metier.service.Service;
import java.util.Date;
import java.util.List;

/**
 * @version 15/04/20 GMT-5 09:34
 * @author Comtois
 */
public class Consultation {
    public String Commentaire;
    public Date DateHeureDemande;
    public Date DateHeureDebut;
    public Date DateHeureFin;
    
    public Consultation(Date DateHeureDemande) {
        this.DateHeureDemande = DateHeureDemande;
        
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
