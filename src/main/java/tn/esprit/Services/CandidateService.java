package tn.esprit.Services;

import tn.esprit.Entities.Candidate;

import java.sql.SQLException;
import java.util.List;
import tn.esprit.Utils.MyDataBase;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;


public class CandidateService implements CRUD<Candidate>{
    @Override
    public int insert(Candidate candidate) throws SQLException {
        return 0;
    }

    @Override
    public int update(Candidate candidate) throws SQLException {
        return 0;
    }

    @Override
    public int delet(Candidate candidate) throws SQLException {
        return 0;
    }

    @Override
    public List<Candidate> showALL() throws SQLException {
        return List.of();
    }
}
