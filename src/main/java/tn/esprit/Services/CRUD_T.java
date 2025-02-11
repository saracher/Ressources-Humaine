package tn.esprit.Services;

import java.util.List;

public interface CRUD_T<T> {
    void ajouter(T t);
    List<T> afficher();
    void modifier(T t);
    void supprimer(int id);
}
