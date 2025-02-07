package tn.esprit.Services;

import java.sql.SQLException;
import java.util.List;

public interface CRUD <T>{

    int insert(T t) throws SQLException;

    int update(T t)throws SQLException;

    int delet( T t)throws SQLException;

    List<T> showALL()throws SQLException;
}

