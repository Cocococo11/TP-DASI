package fr.insalyon.dasi.ihm.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author B3401
 */
public class ProfilMediumSerialisation extends Serialisation {

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
// Il va falloir séraliser un medium en renvoyant chacun de ses attributs en json pour les afficher en html

        Medium medium = (Medium)request.getAttribute("medium");
        JsonObject container = new JsonObject();
        
        JsonObject jsonPersonne = new JsonObject();
        jsonPersonne.addProperty("id", medium.getId());
        jsonPersonne.addProperty("genre", medium.getGenre());
        jsonPersonne.addProperty("denomination", medium.getDenomination());
        jsonPersonne.addProperty("presentation", medium.getPresentation());



        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }

}
