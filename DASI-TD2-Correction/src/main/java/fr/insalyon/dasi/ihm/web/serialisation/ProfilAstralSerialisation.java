package fr.insalyon.dasi.ihm.web.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author B3401
 */
public class ProfilAstralSerialisation extends Serialisation {

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
// Il va falloir séraliser un medium en renvoyant chacun de ses attributs en json pour les afficher en html

        List<String> p = (List<String>)request.getAttribute("profilAstro");
        JsonObject container = new JsonObject();     
        
        Boolean connexion = (p != null);
        container.addProperty("connexion", connexion);
        
        
        if (p != null) {
            JsonObject jsonProfil = new JsonObject();
            jsonProfil.addProperty("signezodiaque", p.get(0));
            jsonProfil.addProperty("signechinois", p.get(1));
            jsonProfil.addProperty("couleur",p.get(2));
            jsonProfil.addProperty("animal",p.get(3)); 
            container.add("profil", jsonProfil);
        }
        

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(container, out);
        out.close();
    }

}
