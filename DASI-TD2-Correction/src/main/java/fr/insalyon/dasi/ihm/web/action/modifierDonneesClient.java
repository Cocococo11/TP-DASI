package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Corentin BEL and Madeleine COMTOIS
 */
public class modifierDonneesClient extends Action {

    @Override
    public void executer(HttpServletRequest request) {
        
        String Prenom = request.getParameter("prenom");
        String Nom = request.getParameter("nom");
        String Phone = request.getParameter("telephone");
        String Email = request.getParameter("mail");
        
        
        Service service = new Service();
        HttpSession session = request.getSession();
        Client c = (Client)service.rechercherPersonneParId((Long)session.getAttribute("idClient"));
        c.setPrenom(Prenom);
        c.setTelephone(Phone);
        c.setNom(Nom);
        c.setMail(Email);
        // Il manque juste le service correspondant
        //service.updateClient(c);        

    }
    
}