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
public class ProfilClientSerialisation extends Serialisation {

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Personne personne = (Personne)request.getAttribute("personne");
        
        JsonObject container = new JsonObject();

        Boolean connexion = (personne != null);
        container.addProperty("connexion", connexion);

        if (personne != null) {
            JsonObject jsonPersonne = new JsonObject();
            jsonPersonne.addProperty("id", personne.getId());
            jsonPersonne.addProperty("nom", personne.getNom());
            jsonPersonne.addProperty("prenom", personne.getPrenom());
            jsonPersonne.addProperty("mail", personne.getMail());

            container.add("personne", jsonPersonne);
        }

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }

}
