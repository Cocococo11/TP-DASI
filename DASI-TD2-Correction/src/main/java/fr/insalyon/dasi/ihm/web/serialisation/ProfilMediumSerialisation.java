package fr.insalyon.dasi.ihm.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.modele.Cartomancien;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.modele.Spirite;
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
                jsonMedium.addProperty("Type", m.getClass().getSimpleName());
                jsonMedium.addProperty("Genre", m.getGenre());
                jsonMedium.addProperty("Denomination", m.getDenomination());
                jsonMedium.addProperty("Presentation", m.getPresentation());
                if(m instanceof Spirite)
                {
                    Spirite p = (Spirite)m;
                    jsonMedium.addProperty("Support", p.getSupport());
                }
                if(m instanceof Astrologue)
                {
                    Astrologue p = (Astrologue)m;
                    jsonMedium.addProperty("Promotion", p.getPromotion());
                    jsonMedium.addProperty("Formation", p.getFormation());
                }

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
