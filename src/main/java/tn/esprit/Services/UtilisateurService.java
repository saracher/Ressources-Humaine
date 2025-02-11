package tn.esprit.Services;

import tn.esprit.Entities.Utilisateur;
import tn.esprit.Entities.Role;
import tn.esprit.Utils.MyDataBase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurService implements CRUD_User<Utilisateur> {
    private Connection cnx = MyDataBase.getInstance().getCnx();;

    private Statement st ;
    private PreparedStatement pst;

    @Override
    public int addUser(Utilisateur user) throws SQLException {
        String req = "INSERT INTO Users (firstname, lastname, email, password, profilePhoto, birthdayDate, joiningDate, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        pst= cnx.prepareStatement(req);
        pst.setString(1, user.getFirstname());
        pst.setString(2, user.getLastname());
        pst.setString(3, user.getEmail());
        pst.setString(4, user.getPassword());
        pst.setString(5, user.getProfilePhoto());
        pst.setDate(6, new java.sql.Date(user.getBirthdayDate().getTime()));
        pst.setDate(7, new java.sql.Date(user.getJoiningDate().getTime()));
        pst.setString(8, user.getRole().name());
        return pst.executeUpdate();
    }

    @Override
    public List<Utilisateur> getUsers() throws SQLException {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String req = "SELECT * FROM `Users`";
        st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);

        while (rs.next()) {
            utilisateurs.add(new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("profilePhoto"),
                    rs.getDate("birthdayDate"),
                    rs.getDate("joiningDate"),
                    Role.valueOf(rs.getString("role"))
            ));
        }

        return utilisateurs;
    }

    @Override
    public int deleteUser(Utilisateur utilisateur) throws SQLException {
        String req = "DELETE FROM Users WHERE id = ?";
        pst = cnx.prepareStatement(req);
        pst.setInt(1, utilisateur.getId());
        return pst.executeUpdate();
    }

    @Override
    public int updateUser(Utilisateur utilisateur) throws SQLException {
        String req = "UPDATE Users SET firstname = ?, lastname = ?, email = ?, password = ?, profilePhoto = ?, birthdayDate = ?, joiningDate = ?, role = ? WHERE id = ?";
        pst = cnx.prepareStatement(req);
        pst.setString(1, utilisateur.getFirstname());
        pst.setString(2, utilisateur.getLastname());
        pst.setString(3, utilisateur.getEmail());
        pst.setString(4, utilisateur.getPassword());
        pst.setString(5, utilisateur.getProfilePhoto());
        pst.setDate(6, new java.sql.Date(utilisateur.getBirthdayDate().getTime()));
        pst.setDate(7, new java.sql.Date(utilisateur.getJoiningDate().getTime()));
        pst.setString(8, utilisateur.getRole().name());
        pst.setInt(9, utilisateur.getId());
        return pst.executeUpdate();
    }
}
