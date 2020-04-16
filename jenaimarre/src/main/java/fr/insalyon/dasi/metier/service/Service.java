package fr.insalyon.dasi.metier.service;

import fr.insalyon.dasi.dao.PersonneDao;
import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Consultation;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Madeleine Comtois & Corentin Bel
 */
public class Service {

    protected PersonneDao personneDao = new PersonneDao();

    public Long inscrireClient(Client client) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            client.profilAttributs = client.getProfilAstroClient().getProfil(client.getNom(), client.getDateNaissance());
            personneDao.creer(client);
            JpaUtil.validerTransaction();
            resultat = client.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public void getHistoriqueConsultations(Client c)
    {
        JpaUtil.creerContextePersistance();
        PersonneDao personneDao = new PersonneDao();
        List<Consultation> liste = null;
        try {
            liste = personneDao.recupererConsultations(c.getMail());
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service getHistoriqueConsultations(mail)", ex);
            liste = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        c.setListeConsultations(liste);
    }
    public Personne rechercherClientParId(Long id) {
        Personne resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = personneDao.chercherParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

    public Personne authentifierPersonne(String mail, String motDePasse) {
        Personne resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche de la personne
            Personne personne = personneDao.chercherParMail(mail);
            if (personne != null) {
                // Vérification du mot de passe
                if (personne.getMotDePasse().equals(motDePasse)) {
                    resultat = personne;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierPersonne(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

    /*
    * Demander une consultation avec un medium
    */
    public void demanderConsultation(Client c, long idMedium) {
        JpaUtil.creerContextePersistance();
        PersonneDao consul = new PersonneDao();
        Employe dispo =  consul.trouverEmployeDispo();
        if(dispo != null)
        {
            System.out.println("On a trouvé un employé !!! Son Id est : " + dispo.getId());
            Consultation consultation = new Consultation(   idMedium,  dispo.getId(),c);
            consul.conserverConsultation(consultation);
            dispo.setDisponible(false);
        
        }
        else
        {
            System.out.println("Pas d'employé trouvé");
        }
        JpaUtil.fermerContextePersistance();
    }
    
    public List<Personne> listerPersonnes() {
        List<Personne> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = personneDao.listerPersonnes();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerPersonnes()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public List<Medium> listerMediums() {
        List<Medium> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = personneDao.listerMediums();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerMediums()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public void debuterConsultation(Consultation consultation){
        JpaUtil.creerContextePersistance();
        PersonneDao p = new PersonneDao();
        consultation.setEtat("en cours");
        p.modifierConsultation(consultation);
        JpaUtil.fermerContextePersistance();
        
    }
    
    public void terminerConsultation(Consultation consultation){
        JpaUtil.creerContextePersistance();
        PersonneDao p = new PersonneDao();
        consultation.setEtat("finie");
        p.modifierConsultation(consultation);
        JpaUtil.fermerContextePersistance();
    }

}
