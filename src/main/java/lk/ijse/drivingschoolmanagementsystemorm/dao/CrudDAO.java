package lk.ijse.drivingschoolmanagementsystemorm.dao;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO{

    String getLastId() throws SQLException;
}
