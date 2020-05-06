package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DASI Team
 */
public class AuthentifierPersonneAction extends Action {

    @Override
    public void executer(HttpServletRequest request) {
        
        String Mail = request.getParameter("Mail");
        String password = request.getParameter("password");

        Service service = new Service();
        Personne personne = service.authentifierPersonne(Mail, password);
        
        System.out.println(personne);
        request.setAttribute("personne", personne);
        
        // Gestion de la Session: ici, enregistrer le mail de la personne authentifiée
        HttpSession session = request.getSession();
        if (personne != null) {
            session.setAttribute("prenomPersonne", personne.getPrenom());
        }
        else {
            session.removeAttribute("prenomPersonne");
        }
    }
    
}
