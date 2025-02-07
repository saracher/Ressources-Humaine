package tn.esprit.Services;

import tn.esprit.Utils.MyDataBase;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.Entities.Offre;

public class OffreService implements CRUD<Offre> {

    @Override
    public int insert(Offre offre) throws SQLException {
        return 0;
    }

    @Override
    public int update(Offre offre) throws SQLException {
        return 0;
    }

    @Override
    public int delet(Offre offre) throws SQLException {
        return 0;
    }

    @Override
    public List<Offre> showALL() throws SQLException {
        return List.of();
    }
}
