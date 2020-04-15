package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Consultation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author DASI Team
 */
public class PersonneDao {
    
    public void creer(Personne personne) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(personne);
    }
    
    public void conserverConsultation(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(consultation);
    }
    
    public Personne chercherParId(Long clientId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Personne.class, clientId); // renvoie null si l'identifiant n'existe pas
    }
    
    public Personne chercherParMail(String idMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p WHERE p.mail = :mail", Personne.class);
        query.setParameter("mail", idMail); // correspond au paramètre ":mail" dans la requête
        List<Personne> personnes = query.getResultList();
        Personne result = null;
        if (!personnes.isEmpty()) {
            result = personnes.get(0); // premier de la liste
        }
        return result;
    }
    
    public List<Personne> listerPersonnes() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Personne> query = em.createQuery("SELECT c FROM Personne c ORDER BY c.nom ASC, c.prenom ASC", Personne.class);
        return query.getResultList();
    }
    
    public List<Medium> listerMediums() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Medium> query = em.createQuery("SELECT c FROM Medium c ORDER BY  c.denomination ASC", Medium.class);
        return query.getResultList();
    }
    
    public Employe trouverEmployeDispo() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Employe> query = em.createQuery("SELECT c FROM Employe c WHERE c.disponibilite = true", Employe.class);
        List<Employe> boom= query.getResultList();
        return boom.get(0);
    }
    
    // modifier / supprimer  ... 
}
