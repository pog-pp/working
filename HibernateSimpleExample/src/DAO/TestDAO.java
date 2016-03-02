package DAO;

import logic.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by paul on 02.03.16.
 */
public interface TestDAO {
    void addTest(Test test) throws SQLException;
    void updateTest(Test test) throws SQLException;
    Test getTestById(long id) throws SQLException;
    List getAllTests() throws SQLException;
    void deleteTest(Test test) throws SQLException;
}
