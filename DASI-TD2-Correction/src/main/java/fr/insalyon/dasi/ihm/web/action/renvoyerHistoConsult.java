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
public class renvoyerHistoConsult extends Action {
   @Override
    public void executer(HttpServletRequest request) {
        
        Service service = new Service();
        HttpSession session = request.getSession();
        Long id = (Long)session.getAttribute("idPersonne");
        Client client = (Client)service.rechercherPersonneParId(id);
        service.getHistoriqueConsultations(client);
      
        if(client!=null)
        {
            try {
                request.setAttribute("liste", client.getListeConsultations());
            } catch (Exception ex) {
                Logger.getLogger(creerConsultation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
