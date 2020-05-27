package fr.insalyon.dasi.ihm.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Corentin BEL and Madeleine COMTOIS
 */
public class seDeconnecter extends Action {

    @Override
    public void executer(HttpServletRequest request) {
        
        HttpSession session = request.getSession();
        session.setAttribute("idPersonne", null);

    }
    
}