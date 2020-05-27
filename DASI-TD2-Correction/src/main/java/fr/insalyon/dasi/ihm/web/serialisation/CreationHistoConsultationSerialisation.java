package fr.insalyon.dasi.ihm.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Spirite;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author B3401
 */
public class CreationHistoConsultationSerialisation extends Serialisation {

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        
        List<Consultation> liste = (List<Consultation>)request.getAttribute("liste");
        
        JsonObject container = new JsonObject();     
        
        Boolean connexion = (liste != null);
        container.addProperty("connexion", connexion);
        
        if (liste != null) {
            JsonArray jsonListe = new JsonArray();
            for(Consultation c : liste) {
                JsonObject jsonConsultation = new JsonObject();
                
                jsonConsultation.addProperty("id", c.getId());
                jsonConsultation.addProperty("Commentaire", c.getCommentaire());
                jsonConsultation.addProperty("Medium", c.getMedium().getDenomination());
                jsonListe.add( jsonConsultation);
            }
            container.add("liste",jsonListe);
        }
        

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }

}
