package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Corentin BEL and Madeleine COMTOIS
 */
public class renvoyerPersonne extends Action {

    @Override
    public void executer(HttpServletRequest request) {
        
        Service service = new Service();
        String mail = request.getParameter("mail");
        Personne personne = service.renvoyerPersonne(mail);
        
        request.setAttribute("personne", personne);

    }
    
}