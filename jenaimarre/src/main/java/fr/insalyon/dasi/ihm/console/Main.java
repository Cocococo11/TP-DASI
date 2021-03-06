package fr.insalyon.dasi.ihm.console;

import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Personne;
import fr.insalyon.dasi.metier.service.Service;
import fr.insalyon.dasi.metier.modele.Spirite;
import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Cartomancien;
import fr.insalyon.dasi.metier.modele.Consultation;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
// 
/**
 * @version 08/04/20 10:24 GMT-5
 * @author DASI Team
 */
public class Main {

    public static void main(String[] args) {

        // TODO : Pensez à créer une unité de persistance "DASI-PU" et à vérifier son nom dans la classe JpaUtil
        // Contrôlez l'affichage du log de JpaUtil grâce à la méthode log de la classe JpaUtil
        JpaUtil.init();
        System.out.println("Ca marche pas :(");

        initialiserPersonnes();
        afficherMediums();
        //testerInscriptionClient();     
        //testerRechercheClient();       
        //testerListeClients();           
        //testerAuthentificationPersonne();  
        //saisirInscriptionClient();      
        //saisirRechercheClient();
        //testerDemandeConsultation();
        
        JpaUtil.destroy();
    }

    public static void afficherPersonnes(Personne personne) {
        System.out.println("-> " + personne);
    }
    
    public static void afficherMediums() {
        System.out.println();
        System.out.println("**** Les Mediums ****");
        System.out.println();
        
        Service service = new Service();
        List<Medium> listeMediums = service.listerMediums();
        if (listeMediums != null) {
            for (Medium medium : listeMediums) {
                System.out.println("-> " + medium);
            }
        }
        else {
            System.out.println("=> ERREUR...");
        }

    }

    public static void initialiserPersonnes() {
        
        System.out.println();
        System.out.println("**** initialiserPersonnes() ****");
        System.out.println();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DASI-PU");
        EntityManager em = emf.createEntityManager();

        Employe no1 = new Employe("Michel", "Blanc", "m@b.com", "123","066666666", "homme");
        Employe no2 = new Employe("Pascale", "Braise", "p@b.com", "123","066666666", "femme");
        Medium riri = new Cartomancien("Riri","M","Comprenez votre entourage grâce à mes cartes ! Résultats rapides.");
        Medium fifi = new Spirite("Fifi", "F", "Spécialiste des grandes conversations au-delà de TOUTES les frontières", "Boule de cristal");
        Medium loulou = new Astrologue("Loulou","F","Basée à Champigny-sur-Marne, Serena vous révèlera votre avenir pour éclairer votre passé.", "2006", "École Normale Supérieure d’Astrologie (ENS-Astro)");
        Client idiot = new Client("Jesuis", "Pasmart", "j@p.com", "123","066666666",new Date(),"Dr");
        
        System.out.println();

        try {
            em.getTransaction().begin();
            em.persist(no1);
            em.persist(no2);
            em.persist(riri);
            em.persist(fifi);
            em.persist(loulou);
            em.persist(idiot);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service", ex);
            try {
                em.getTransaction().rollback();
            }
            catch (IllegalStateException ex2) {
                // Ignorer cette exception...
            }
        } finally {
            em.close();
        }

        System.out.println();
        System.out.println("** Personnes après persistance: ");
        afficherPersonnes(no1);
        afficherPersonnes(no2);
        afficherPersonnes(idiot);
        afficherMediums();
        System.out.println();
    }

    public static void testerInscriptionClient() {
        
        System.out.println();
        System.out.println("**** testerInscriptionClient() ****");
        System.out.println();
        
        Service service = new Service();
        Client claude = new Client("COCOCOCO", "Tom", "tomco@gmail.com", "asdfaf", "876567899", new Date(), "homme");
        Long idClaude = service.inscrireClient(claude);
        if (idClaude != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherPersonnes(claude);

        Client clode = new Client("COCOCOCO", "Tom", "tomco@gail.com", "asdfaf", "876567899", new Date(), "homme");
        Long idClode = service.inscrireClient(clode);
        if (idClode != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherPersonnes(clode);

        
    }
/*
    public static void testerRechercheClient() {
        
        System.out.println();
        System.out.println("**** testerRechercheClient() ****");
        System.out.println();
        
        Service service = new Service();
        long id;
        Personne client;

        id = 1;
        System.out.println("** Recherche du Client #" + id);
        client = service.rechercherClientParId(id);
        if (client != null) {
            afficherPersonnes(client);
        } else {
            System.out.println("=> Client non-trouvé");
        }

        id = 3;
        System.out.println("** Recherche du Client #" + id);
        client = service.rechercherClientParId(id);
        if (client != null) {
            afficherPersonnes(client);
        } else {
            System.out.println("=> Client non-trouvé");
        }

        id = 17;
        System.out.println("** Recherche du Client #" + id);
        client = service.rechercherClientParId(id);
        if (client != null) {
            afficherPersonnes(client);
        } else {
            System.out.println("=> Client #" + id + " non-trouvé");
        }
    }

    public static void testerListeClients() {
        
        System.out.println();
        System.out.println("**** testerListeClients() ****");
        System.out.println();
        
        Service service = new Service();
        List<Personne> listeClients = service.listerPersonnes();
        System.out.println("*** Liste des Clients");
        if (listeClients != null) {
            for (Personne client : listeClients) {
                afficherPersonnes(client);
            }
        }
        else {
            System.out.println("=> ERREUR...");
        }
    }
*/
    public static void testerAuthentificationPersonne() {
        
        System.out.println();
        System.out.println("**** testerAuthentificationPersonne() ****");
        System.out.println();
        
        Service service = new Service();
        Personne personne;
        String mail;
        String motDePasse;

        mail = "j@p.com";
        motDePasse = "123";
        personne = service.authentifierPersonne(mail, motDePasse);
        if (personne != null) {
            System.out.println("Authentification réussie avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
            afficherPersonnes(personne);
        } else {
            System.out.println("Authentification échouée avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
        }

        mail = "ada.lovelace@insa-lyon.fr";
        motDePasse = "Ada2020";
        personne = service.authentifierPersonne(mail, motDePasse);
        if (personne != null) {
            System.out.println("Authentification réussie avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
            afficherPersonnes(personne);
        } else {
            System.out.println("Authentification échouée avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
        }

        mail = "etudiant.fictif@insa-lyon.fr";
        motDePasse = "********";
        personne = service.authentifierPersonne(mail, motDePasse);
        if (personne != null) {
            System.out.println("Authentification réussie avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
            afficherPersonnes(personne);
        } else {
            System.out.println("Authentification échouée avec le mail '" + mail + "' et le mot de passe '" + motDePasse + "'");
        }
    }
/*
    public static void saisirInscriptionClient() {
        Service service = new Service();

        System.out.println();
        System.out.println("Appuyer sur Entrée pour passer la pause...");
        Saisie.pause();

        System.out.println();
        System.out.println("**************************");
        System.out.println("** NOUVELLE INSCRIPTION **");
        System.out.println("**************************");
        System.out.println();

        String nom = Saisie.lireChaine("Nom ? ");
        String prenom = Saisie.lireChaine("Prénom ? ");
        String mail = Saisie.lireChaine("Mail ? ");
        String motDePasse = Saisie.lireChaine("Mot de passe ? ");

        Personne client = new Employe(nom, prenom, mail, motDePasse,"066666666");
        Long idClient = service.inscrirePersonne(client);

        if (idClient != null) {
            System.out.println("> Succès inscription");
        } else {
            System.out.println("> Échec inscription");
        }
        afficherPersonnes(client);

    }

    public static void saisirRechercheClient() {
        Service service = new Service();

        System.out.println();
        System.out.println("*********************");
        System.out.println("** MENU INTERACTIF **");
        System.out.println("*********************");
        System.out.println();

        Saisie.pause();

        System.out.println();
        System.out.println("**************************");
        System.out.println("** RECHERCHE de CLIENTS **");
        System.out.println("**************************");
        System.out.println();
        System.out.println();
        System.out.println("** Recherche par Identifiant:");
        System.out.println();

        Integer idClient = Saisie.lireInteger("Identifiant ? [0 pour quitter] ");
        while (idClient != 0) {
            Personne client = service.rechercherClientParId(idClient.longValue());
            if (client != null) {
                afficherPersonnes(client);
            } else {
                System.out.println("=> Client #" + idClient + " non-trouvé");
            }
            System.out.println();
            idClient = Saisie.lireInteger("Identifiant ? [0 pour quitter] ");
        }

        System.out.println();
        System.out.println("********************************");
        System.out.println("** AUTHENTIFICATION de CLIENT **");
        System.out.println("********************************");
        System.out.println();
        System.out.println();
        System.out.println("** Authentifier Client:");
        System.out.println();

        String clientMail = Saisie.lireChaine("Mail ? [0 pour quitter] ");

        while (!clientMail.equals("0")) {
            String clientMotDePasse = Saisie.lireChaine("Mot de passe ? ");
            Personne client = service.authentifierPersonne(clientMail, clientMotDePasse);
            if (client != null) {
                afficherPersonnes(client);
            } else {
                System.out.println("=> Client non-authentifié");
            }
            clientMail = Saisie.lireChaine("Mail ? [0 pour quitter] ");
        }

        System.out.println();
        System.out.println("*****************");
        System.out.println("** AU REVOIR ! **");
        System.out.println("*****************");
        System.out.println();

    }
*/
    public static void testerDemandeConsultation() {
        
        System.out.println();
        System.out.println("**** testerDemandeConsultation() ****");
        System.out.println();
        
        Service service = new Service();  
        Medium wouhou = new Cartomancien("pouf","pif","paf");
        Client claude = new Client("COCOCOCO", "Tom", "tomco@gmail.com", "asdfaf", "876567899", new Date(), "homme");
        service.listerPersonnes();
        //service.demanderConsultation(claude, wouhou);
        service.getHistoriqueConsultations(claude);
        for(Consultation c : claude.getListeConsultations())
        {
            System.out.println(" CONSULTATION : "+c);
        }
        

        
    }
}
