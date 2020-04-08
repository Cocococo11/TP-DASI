/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Id;

/**
 *
 * @author Corentin ☺
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Medium implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private String denomination;
    private String genre;
    private String presentation;
    
    protected Medium() {
        
    }
    
    public Medium(String denomination, String genre, String presentation) {
        this.denomination = denomination;
        this.genre = genre;
        this.presentation = presentation;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    @Override
    public String toString() {
        return "Medium{" + "denomination=" + denomination + ", genre=" + genre + ", presentation=" + presentation + '}';
    }
    
    
    
    
    
}
