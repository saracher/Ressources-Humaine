package tn.esprit.Tests;

import tn.esprit.Entities.Abonnement;
import tn.esprit.Services.AbonnementCRUD;
import tn.esprit.Utils.MyDataBase;

import java.sql.SQLException;
import java.util.List;

import java.sql.Date;



public class MainTest {
    public static void main(String[] args) {
        MyDataBase db1 = MyDataBase.getInstance();
        AbonnementCRUD abonnementCRUD = new AbonnementCRUD();

        Abonnement ab1 = new Abonnement(0, "Mensuel", new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000), 50.0, 1, "Actif");

        abonnementCRUD.ajouter(ab1);

        // Afficher tous les abonnements
        List<Abonnement> abonnements = abonnementCRUD.afficher();
        for (Abonnement ab : abonnements) {
            System.out.println(ab);
        }

        // Modifier un abonnement existant (exemple avec l'ID 1)
        if (!abonnements.isEmpty()) {
            Abonnement abToUpdate = abonnements.get(0);
            abToUpdate.setPrix(60.0);
            abonnementCRUD.modifier(abToUpdate);
        }

        // Supprimer un abonnement (exemple avec l'ID 1)
        if (!abonnements.isEmpty()) {
            abonnementCRUD.supprimer(abonnements.get(0).getId_Ab());
        }
    }
}
