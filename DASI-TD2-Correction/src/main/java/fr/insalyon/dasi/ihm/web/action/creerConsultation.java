/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.service.Service;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maddie
 */
public class creerConsultation extends Action {
   @Override
    public void executer(HttpServletRequest request) {
        
        String nomedium = (String)request.getParameter("medium");
        System.out.println("nommedium : "+ nomedium);
        Service service = new Service();
        Medium medium;
        
       switch (nomedium) {
           case "medium1":
               medium = service.rechercherMediumId((long)1);
               System.out.println("Recherche du 1 medium :");
               break;
           case "medium2":
               medium = service.rechercherMediumId((long)2);
               System.out.println("Recherche du 2 medium :");
               break;
           case "medium3":
               medium = service.rechercherMediumId((long)3);
               System.out.println("Recherche du 3 medium :");
               break;
           default:
               medium =null;
               System.out.println("Pas de bon nom medium");
               break;
       }
        
        HttpSession session = request.getSession();
        Long id = (Long)session.getAttribute("idPersonne");
        Client c = (Client)service.rechercherPersonneParId(id);

        System.out.println("Client :"+c +" et medium: "+medium);
        
        request.setAttribute("medium", medium);
        if(medium!=null)
        {
            try {
                service.demanderConsultation(c,medium);
            } catch (Exception ex) {
                Logger.getLogger(creerConsultation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
