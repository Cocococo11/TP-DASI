package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DASI Team
 */
public class renvoyerListeMediums extends Action {

    @Override
    public void executer(HttpServletRequest request) {
        // il faut faire cette classe
        
        Service service = new Service();
        List<Medium> liste = service.listerMediums(); // to do


        
        // Gestion de la Session: ici, enregistrer le mail de la personne authentifiée
        HttpSession session = request.getSession();
        if (liste != null) {
            session.setAttribute("listeMediums", liste);
        }
        else {
            session.removeAttribute("listeMediums");
        }

    }
    
}
