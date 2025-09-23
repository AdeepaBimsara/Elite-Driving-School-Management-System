package lk.ijse.drivingschoolmanagementsystemorm.bo.custom;

import lk.ijse.drivingschoolmanagementsystemorm.bo.SuperBO;

import java.sql.SQLException;

public interface StudentBO extends SuperBO {

    String getNextId() throws SQLException;
}
