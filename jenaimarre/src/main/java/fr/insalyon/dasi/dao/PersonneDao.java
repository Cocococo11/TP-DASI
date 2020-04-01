package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Personne;
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
    
    public Personne chercherParId(Long clientId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Personne.class, clientId); // renvoie null si l'identifiant n'existe pas
    }
    
    public Personne chercherParMail(String clientMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Personne> query = em.createQuery("SELECT c FROM Client c WHERE c.mail = :mail", Personne.class);
        query.setParameter("mail", clientMail); // correspond au paramètre ":mail" dans la requête
        List<Personne> clients = query.getResultList();
        Personne result = null;
        if (!clients.isEmpty()) {
            result = clients.get(0); // premier de la liste
        }
        return result;
    }
    
    public List<Personne> listerClients() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Personne> query = em.createQuery("SELECT c FROM Client c ORDER BY c.nom ASC, c.prenom ASC", Personne.class);
        return query.getResultList();
    }
    
    // modifier / supprimer  ... 
}
