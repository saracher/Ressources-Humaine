package tn.esprit.Services;

import tn.esprit.Entities.MoyenTransport;
import java.util.List;

public interface CRUD_M {

    // Ajouter un moyen de transport
    void ajouter(MoyenTransport mt);

    // Lire tous les moyens de transport
    List<MoyenTransport> afficher();

    // Modifier un moyen de transport existant
    void modifier(MoyenTransport mt);

    // Supprimer un moyen de transport par son identifiant
    void supprimer(int id);
}
