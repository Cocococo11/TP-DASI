package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Employe;
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
        Personne personne = service.rechercherPersonneParId(id);
        
        System.out.println(" client ?" +(personne instanceof Client));
        System.out.println(" Personne ?" +(personne instanceof Personne));
        System.out.println(" Employe ?" +(personne instanceof Employe));
        
        request.setAttribute("personne", personne);

        if(personne instanceof Client)
        {
            request.setAttribute("type1", "Client");
            System.out.println(" Client !" +(personne instanceof Employe));
            
        }
        else if(personne instanceof Employe)
        {
            request.setAttribute("type1", "Employe");
            System.out.println(" Employe !" +(personne instanceof Employe));
        }
        else if(personne instanceof Personne)
        {
            request.setAttribute("type1", "Employe");
            System.out.println(" Personne !" +(personne instanceof Employe));
        }


                
    }
    
}
