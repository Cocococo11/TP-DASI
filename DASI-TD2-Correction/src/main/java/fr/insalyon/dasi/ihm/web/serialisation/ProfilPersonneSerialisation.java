package fr.insalyon.dasi.ihm.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.metier.modele.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author B3401
 */
public class ProfilPersonneSerialisation extends Serialisation {

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
// Il va falloir séraliser un medium en renvoyant chacun de ses attributs en json pour les afficher en html

        Personne p = (Personne)request.getAttribute("personne");
        
        JsonObject container = new JsonObject();     
        
        Boolean connexion = (p != null);
        container.addProperty("connexion", connexion);
        
        if (p != null) {
            JsonObject jsonPersonne = new JsonObject();
            jsonPersonne.addProperty("id", p.getId());
            jsonPersonne.addProperty("nom", p.getNom());
            jsonPersonne.addProperty("prenom", p.getPrenom());
            jsonPersonne.addProperty("mail", p.getMail());
            jsonPersonne.addProperty("telephone", p.getTelephone());
            
            container.add("personne", jsonPersonne);
        }
        

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }

}
