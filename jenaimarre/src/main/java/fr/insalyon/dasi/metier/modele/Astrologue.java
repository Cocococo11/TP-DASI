/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import javax.persistence.Entity;
/**
 * @version 01/04/20 13:05
 * @author Madeleine Comtois & Corentin Bel
 */
@Entity
public class Astrologue extends Medium {
    
    private String promotion;
    private String formation;
    
    public Astrologue(String denomination, String genre, String presentation, String promotion,String formation){
        super(denomination, genre, presentation);
        this.formation = formation;
        this.promotion= promotion;
           
    }
    
    protected Astrologue() {
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    @Override
    public String toString() {
        return "Astrologue{" + "promotion=" + promotion + ", formation=" + formation + '}';
    }

    
    
    
    
}