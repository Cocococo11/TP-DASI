package fr.insalyon.dasi.ihm.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Spirite;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author B3401
 */
public class CreationConsultationSerialisation extends Serialisation {

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        
        Medium m = (Medium)request.getAttribute("medium");
        
        JsonObject container = new JsonObject();     
        
        Boolean consultation = (m != null);
        System.out.println("medium: "+m);
        container.addProperty("consultation", consultation);
        
        if (m != null) {
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
            container.add("medium",jsonMedium);
        }
        

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }

}
