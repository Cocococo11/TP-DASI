package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
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

        request.setAttribute("personne", personne);
        
        // Gestion de la Session: ici, enregistrer l'ID du Client authentifié
        HttpSession session = request.getSession();
        if (personne != null) {
            session.setAttribute("mailPersonne", personne.getMail());
        }
        else {
            session.removeAttribute("mailPersonne");
        }
    }
    
}
