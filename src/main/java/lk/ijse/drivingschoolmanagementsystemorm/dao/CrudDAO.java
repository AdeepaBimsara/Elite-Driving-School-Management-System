package lk.ijse.drivingschoolmanagementsystemorm.dao;

import java.sql.SQLException;
import java.util.Optional;

public interface CrudDAO<T> extends SuperDAO{

    String getLastId() throws SQLException;

    boolean save(T student) throws SQLException;

    Optional<T> findById(String id) throws SQLException;

}
