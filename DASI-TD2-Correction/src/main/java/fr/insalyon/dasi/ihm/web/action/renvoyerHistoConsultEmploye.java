/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.service.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maddie
 */
public class renvoyerHistoConsultEmploye extends Action {
   @Override
    public void executer(HttpServletRequest request) {
        
        List<Consultation> liste = null;
        Service service = new Service();
        for(long i=0;i<5;i++)
        {
            Client client = (Client)service.rechercherPersonneParId(i);
            service.getHistoriqueConsultations(client);

            if(client!=null)
            {
                liste.addAll(client.getListeConsultations());
            }
        }
        try {
                    
                    request.setAttribute("liste", liste);
                } catch (Exception ex) {
                    Logger.getLogger(creerConsultation.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }
    
}
