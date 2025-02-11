package tn.esprit.Tests;

import tn.esprit.Entities.Trajet;
import tn.esprit.Services.TrajetCRUD;
import tn.esprit.Utils.MyDataBase;
import java.sql.Time;
import java.util.List;

public class MainTestT {
    public static void main(String[] args) {
        // Créer une instance de TrajetCRUD
        TrajetCRUD trajetCRUD = new TrajetCRUD();

        // Ajouter un trajet
        System.out.println("Ajout d'un nouveau trajet :");
        Trajet t1 = new Trajet(1, "Tunis", "Sousse", 150.5, new Time(2, 30, 0), 1, 1, "En cours");
        trajetCRUD.ajouter(t1);

        // Afficher tous les trajets
        System.out.println("\nAffichage de tous les trajets :");
        List<Trajet> trajets = trajetCRUD.afficher();
        for (Trajet t : trajets) {
            System.out.println(t);
        }

        // Modifier un trajet (modifier le trajet avec l'ID 1)
        if (!trajets.isEmpty()) {
            System.out.println("\nModification du premier trajet...");
            Trajet tModif = trajets.get(0);
            tModif.setDistance(160.0);  // Modification de la distance
            trajetCRUD.modifier(tModif);
        }

        // Afficher les trajets après modification
        System.out.println("\nAffichage des trajets après modification :");
        trajets = trajetCRUD.afficher();
        for (Trajet t : trajets) {
            System.out.println(t);
        }

        // Supprimer un trajet (supprimer le trajet avec l'ID 1)
        if (!trajets.isEmpty()) {
            System.out.println("\nSuppression du premier trajet...");
            trajetCRUD.supprimer(trajets.get(0).getIdT());
        }

        // Afficher les trajets après suppression
        System.out.println("\nAffichage des trajets après suppression :");
        trajets = trajetCRUD.afficher();
        for (Trajet t : trajets) {
            System.out.println(t);
        }
    }
}
