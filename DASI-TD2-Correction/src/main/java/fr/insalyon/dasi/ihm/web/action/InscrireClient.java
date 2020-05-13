/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.web.action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author maddie
 */
public class InscrireClient extends Action {
    @Override
    public void executer(HttpServletRequest request) {
        String prenom = request.getParameter("prenom");
        System.out.println(prenom);
    }
    
}
