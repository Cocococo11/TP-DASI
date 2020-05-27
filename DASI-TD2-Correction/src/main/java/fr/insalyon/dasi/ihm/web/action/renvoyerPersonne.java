package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.service.Service;
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
        Long id = (Long)session.getAttribute("idPersonne");
        System.out.println(id);
        Personne personne = service.rechercherPersonneParId(id);
 
        request.setAttribute("personne", personne);

    }
    
}
