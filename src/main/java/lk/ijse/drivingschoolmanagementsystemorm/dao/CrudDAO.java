package lk.ijse.drivingschoolmanagementsystemorm.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T> extends SuperDAO{

    String getLastId() throws SQLException;

    boolean save(T t) throws SQLException;

    Optional<T> findById(String id) throws SQLException;

    List<T> getAll() throws SQLException;

    boolean delete(String id) throws SQLException;

    boolean update(T t) throws SQLException;

}
