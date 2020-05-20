/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.service.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maddie
 */
public class InscrireClient extends Action {
   @Override
    public void executer(HttpServletRequest request) {
        
        String Prenom = request.getParameter("Prenom");
        String Nom = request.getParameter("Nom");
        String Anniversaire = request.getParameter("Anniversaire");
        String Adresse = request.getParameter("Adresse");
        String Code = request.getParameter("Code");
        String Ville = request.getParameter("Ville");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        String MotDePasse = request.getParameter("MotDePasse");
        
        Date ann;
       try {
           ann = new SimpleDateFormat("yyyy-MM-DD").parse(Anniversaire);
       } catch (ParseException ex) {
           Logger.getLogger(InscrireClient.class.getName()).log(Level.SEVERE, null, ex);
           ann = null;
       }
        
      
        //IL FAUT GERER LES ATTRIBUTS DANS LA BASE DE DONNEES !!!!!!!
        Service service = new Service();
        Client client = new Client(Nom, Prenom, Email, MotDePasse, Phone, ann, "F");
        
        Long id = service.inscrireClient(client);
                
        System.out.println(client);
        request.setAttribute("personne", client);
        
        // Gestion de la Session: ici, enregistrer le mail de la personne authentifiée
        HttpSession session = request.getSession();
        if (client != null) {
            session.setAttribute("idClient", client.getId());
        }
        else {
            session.removeAttribute("idClient");
        }
    }
    
}
