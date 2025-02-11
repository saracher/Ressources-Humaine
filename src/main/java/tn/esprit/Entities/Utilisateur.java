package tn.esprit.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Utilisateur implements Serializable {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String profilePhoto;
    private Date birthdayDate;
    private Date joiningDate;
    private Role role;

    public Utilisateur() {}

    public Utilisateur(int id, String firstname, String lastname, String email, String password, String profilePhoto, Date birthdayDate, Date joiningDate, Role role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
        this.birthdayDate = birthdayDate;
        this.joiningDate = joiningDate;
        this.role = role;
    }

    // Constructeur utilisé pour la création d'utilisateur
    public Utilisateur(String firstname, String lastname, String email, String password, String profilePhoto, Date birthdayDate, Date joiningDate, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
        this.birthdayDate = birthdayDate;
        this.joiningDate = joiningDate;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", birthdayDate=" + birthdayDate +
                ", joiningDate=" + joiningDate +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(profilePhoto, that.profilePhoto) && Objects.equals(birthdayDate, that.birthdayDate) && Objects.equals(joiningDate, that.joiningDate) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, password, profilePhoto, birthdayDate, joiningDate, role);
    }
}
