package fr.insalyon.dasi.ihm.web.action;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.ProfilAstro;
import fr.insalyon.dasi.metier.service.Service;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Corentin BEL and Madeleine COMTOIS
 */
public class renvoyerProfilAstral extends Action {

    @Override
    public void executer(HttpServletRequest request) {
        
        Service service = new Service();
        HttpSession session = request.getSession();
        Long id = (Long)session.getAttribute("idPersonne");
        Client client = (Client)service.rechercherPersonneParId(id);
        ProfilAstro pro = new ProfilAstro();
        
        List<String> profil = null;
        try {
            profil = pro.getProfil(client.getPrenom(), client.getDateNaissance());
        } catch (IOException ex) {
            Logger.getLogger(renvoyerProfilAstral.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("profilAstro", profil);

    }
    
}