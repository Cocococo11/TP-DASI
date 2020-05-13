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
        HttpSession session = request.getSession();
        String mail = (String)session.getAttribute("mailPersonne");
        Personne personne = service.renvoyerPersonne(mail);
        if(personne!=null){
            request.setAttribute("logged", true);
        }
        request.setAttribute("personne", personne);

    }
    
}
