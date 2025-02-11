package tn.esprit.Services;

import java.util.List;

public interface CRUD<T> {

    // Ajouter un nouvel élément
    void ajouter(T t);

    // Lire tous les éléments
    List<T> afficher();

    // Modifier un élément existant
    void modifier(T t);

    // Supprimer un élément par son identifiant
    void supprimer(int id);
}
