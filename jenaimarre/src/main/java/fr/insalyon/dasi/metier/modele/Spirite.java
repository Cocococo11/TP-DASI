/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import javax.persistence.Entity;
/**
 * @version 01/04/20 13:05
 * @author 
 */
@Entity
public class Spirite extends Medium {
    
    private String support;

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }
    
    public Spirite(String denomination, String genre, String presentation){
        super(denomination, genre, presentation);
        
    }
    
    protected Spirite() {
    }
}