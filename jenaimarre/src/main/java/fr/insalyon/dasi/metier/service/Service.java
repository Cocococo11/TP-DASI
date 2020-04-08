package fr.insalyon.dasi.metier.service;

import fr.insalyon.dasi.dao.PersonneDao;
import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.modele.Medium;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DASI Team
 */
public class Service {

    protected PersonneDao personneDao = new PersonneDao();

    public Long inscrirePersonne(Personne personne) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            personneDao.creer(personne);
            JpaUtil.validerTransaction();
            resultat = personne.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
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
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierClient(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
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
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerPersonnes()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

}
