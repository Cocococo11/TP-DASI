package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Corentin BEL and Madeleine COMTOIS
 */
public class renvoyerListeMediums extends Action {

    @Override
    public void executer(HttpServletRequest request) {
        
        Service service = new Service();
        List<Medium> liste = service.listerMediums();
        
        request.setAttribute("listeMediums", liste);
        
    }
    
}
