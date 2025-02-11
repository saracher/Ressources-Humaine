package tn.esprit.Services;

import tn.esprit.Entities.Abonnement;
import tn.esprit.Utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbonnementCRUD implements CRUD<Abonnement> {

    private Connection cnx;

    public AbonnementCRUD() {
        cnx = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Abonnement abonnement) {
        String query = "INSERT INTO abonnement (type_Ab, date_debut, date_exp, prix, id_employe, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, abonnement.getType_Ab());
            preparedStatement.setDate(2, new java.sql.Date(abonnement.getDate_debut().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(abonnement.getDate_exp().getTime()));
            preparedStatement.setDouble(4, abonnement.getPrix());
            preparedStatement.setInt(5, abonnement.getId_employe());
            preparedStatement.setString(6, abonnement.getStatus());

            int rowsInserted = preparedStatement.executeUpdate();
            if (abonnement.getDate_debut().after(abonnement.getDate_exp())) {
                System.err.println("❌ Erreur : La date de début doit être antérieure à la date d'expiration.");
                return;
            }
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        abonnement.setId_Ab(generatedKeys.getInt(1));
                    }
                }
                System.out.println("✅ Abonnement ajouté avec succès ! ID: " + abonnement.getId_Ab());
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'ajout de l'abonnement : " + e.getMessage());
        }
    }


    @Override
    public List<Abonnement> afficher() {
        List<Abonnement> abonnements = new ArrayList<>();
        String query = "SELECT * FROM abonnement";
        try (Statement statement = cnx.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Abonnement abonnement = new Abonnement(
                        resultSet.getInt("id_Ab"),
                        resultSet.getString("type_Ab"),
                        resultSet.getDate("date_debut"),
                        resultSet.getDate("date_exp"),
                        resultSet.getDouble("prix"),
                        resultSet.getInt("id_employe"),
                        resultSet.getString("status")
                );
                abonnements.add(abonnement);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération des abonnements : " + e.getMessage());
        }
        return abonnements;
    }


    public Optional<Abonnement> getById(int id_Ab) {
        String query = "SELECT * FROM abonnement WHERE id_Ab = ?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setInt(1, id_Ab);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Abonnement abonnement = new Abonnement(
                            resultSet.getInt("id_Ab"),
                            resultSet.getString("type_Ab"),
                            resultSet.getDate("date_debut"),
                            resultSet.getDate("date_exp"),
                            resultSet.getDouble("prix"),
                            resultSet.getInt("id_employe"),
                            resultSet.getString("status")
                    );
                    return Optional.of(abonnement);
                }


            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération de l'abonnement ID " + id_Ab + " : " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void modifier(Abonnement abonnement) {
        if (abonnement.getDate_debut().after(abonnement.getDate_exp())) {
            System.err.println("❌ Erreur : La date de début doit être antérieure à la date d'expiration.");
            return;
        }

        String query = "UPDATE abonnement SET type_Ab=?, date_debut=?, date_exp=?, prix=?, id_employe=?, status=? WHERE id_Ab=?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setString(1, abonnement.getType_Ab());
            preparedStatement.setDate(2, new java.sql.Date(abonnement.getDate_debut().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(abonnement.getDate_exp().getTime()));
            preparedStatement.setDouble(4, abonnement.getPrix());
            preparedStatement.setInt(5, abonnement.getId_employe());
            preparedStatement.setString(6, abonnement.getStatus());
            preparedStatement.setInt(7, abonnement.getId_Ab());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Abonnement modifié avec succès !");
            } else {
                System.out.println("⚠️ Aucun abonnement trouvé avec l'ID : " + abonnement.getId_Ab());
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la modification de l'abonnement : " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int id_Ab) {
        if (getById(id_Ab).isEmpty()) {
            System.out.println("⚠️ Aucun abonnement trouvé avec l'ID : " + id_Ab);
            return;
        }

        String query = "DELETE FROM abonnement WHERE id_Ab=?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) {
            preparedStatement.setInt(1, id_Ab);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Abonnement supprimé avec succès !");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la suppression de l'abonnement : " + e.getMessage());
        }
    }

}
