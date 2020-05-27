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
        
        String Prenom = request.getParameter("Prenom");
        String Nom = request.getParameter("Nom");
        String Anniversaire = request.getParameter("Anniversaire");
        String Adresse = request.getParameter("Adresse");
        String Code = request.getParameter("Code");
        String Ville = request.getParameter("Ville");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        String MotDePasse = request.getParameter("MotDePasse");
        
        
        Service service = new Service();
        HttpSession session = request.getSession();
        Client c = (Client)service.rechercherPersonneParId((Long)session.getAttribute("idClient"));
        c.setPrenom(Prenom);
        c.setTelephone(Phone);
        c.setNom(Nom);
        c.setMail(Email);
                

    }
    
}