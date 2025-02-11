package tn.esprit.Tests;

import tn.esprit.Entities.Role;
import tn.esprit.Entities.Utilisateur;
import tn.esprit.Services.UtilisateurService;
import tn.esprit.Utils.MyDataBase;

import java.sql.Date;
import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) {
        MyDataBase db = MyDataBase.getInstance();

        Utilisateur user1 = new Utilisateur(
                "John",
                "Doe",
                "john.doe@example.com",
                "password123",
                "profile1.jpg",
                Date.valueOf("1990-01-01"),
                Date.valueOf("2023-05-15"),
                Role.EMPLOYEE
        );

        Utilisateur user2 = new Utilisateur(
                "Jane",
                "Smith",
                "jane.smith@example.com",
                "password456",
                "profile2.jpg",
                Date.valueOf("1992-07-10"),
                Date.valueOf("2023-06-20"),
                Role.RESPONSABLE_RH
        );

        UtilisateurService personService = new UtilisateurService();
        try {
            personService.addUser(user1);
            personService.addUser(user2);
            System.out.println(personService.getUsers());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
