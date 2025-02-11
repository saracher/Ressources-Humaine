package tn.esprit.Services;

import java.sql.SQLException;
import java.util.List;

public interface CRUD_User <T>{
    int addUser(T t) throws SQLException;
    int updateUser(T t) throws SQLException;
    int deleteUser(T t) throws SQLException;
    List<T> getUsers() throws SQLException;
}
