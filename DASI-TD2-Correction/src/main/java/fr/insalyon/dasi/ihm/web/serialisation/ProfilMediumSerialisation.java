package fr.insalyon.dasi.ihm.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

        List<Medium> mediums = (List<Medium>)request.getAttribute("listeMediums");
        
        JsonObject container = new JsonObject();     
        
        Boolean connexion = (mediums != null);
        container.addProperty("connexion", connexion);
        
        if (mediums != null) {
            int i=0;
            for(Medium m : mediums) {
                JsonObject jsonMedium = new JsonObject();
                
                jsonMedium.addProperty("id", m.getId());
                jsonMedium.addProperty("genre", m.getGenre());
                jsonMedium.addProperty("denomination", m.getDenomination());
                jsonMedium.addProperty("presentation", m.getPresentation());
                ++i;
                container.add("listeMediums"+i, jsonMedium);
            }
        }
        

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }

}
