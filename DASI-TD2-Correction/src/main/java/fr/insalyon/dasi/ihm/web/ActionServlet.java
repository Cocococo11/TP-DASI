package fr.insalyon.dasi.ihm.web;

import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.ihm.web.action.Action;
import fr.insalyon.dasi.ihm.web.action.AuthentifierPersonneAction;
import fr.insalyon.dasi.ihm.web.action.InscrireClient;
import fr.insalyon.dasi.ihm.web.action.creerConsultation;
import fr.insalyon.dasi.ihm.web.action.renvoyerListeMediums;
import fr.insalyon.dasi.ihm.web.action.renvoyerPersonne;
import fr.insalyon.dasi.ihm.web.action.renvoyerProfilAstral;
import fr.insalyon.dasi.ihm.web.action.seDeconnecter;
import fr.insalyon.dasi.ihm.web.serialisation.CreationConsultationSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.DeconnecterSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ProfilAstralSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ProfilClientSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ProfilMediumSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.ProfilPersonneSerialisation;
import fr.insalyon.dasi.ihm.web.serialisation.Serialisation;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DASI Team
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.init();
    }

    @Override
    public void destroy() {
        JpaUtil.destroy();
        super.destroy();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("UTF-8");

        String todo = request.getParameter("todo");

        Action action = null;
        Serialisation serialisation = null;

        if (todo != null) {
            switch (todo) {
                case "connecter":
                    action = new AuthentifierPersonneAction();
                    serialisation = new ProfilClientSerialisation();
                    break;
                case "recupererListeMediums":
                    action = new renvoyerListeMediums();
                    serialisation = new ProfilMediumSerialisation();
                    break;
                case "recuperer-donnees":
                    action = new renvoyerPersonne();
                    serialisation = new ProfilPersonneSerialisation();
                    break;
                case "inscrire":
                    action = new InscrireClient();
                    serialisation = new ProfilClientSerialisation();
                    break;
                case "deconnecter":
                    action = new seDeconnecter();
                    serialisation = new DeconnecterSerialisation();
                case "recupererProfilAstral":
                    action = new renvoyerProfilAstral();
                    serialisation = new ProfilAstralSerialisation();   
                case "creer-consultation":
                    action = new creerConsultation();
                    serialisation = new CreationConsultationSerialisation();    
                case "...":
                    break;
            }
        }
        
        if (action != null) {
            action.executer(request);
            serialisation.serialiser(request, response);
        }
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erreur dans les paramètres de la requête");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
