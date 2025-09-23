package lk.ijse.drivingschoolmanagementsystemorm.bo.custom;

import lk.ijse.drivingschoolmanagementsystemorm.bo.SuperBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;

import java.sql.SQLException;

public interface StudentBO extends SuperBO {

    String getNextId() throws SQLException;

    void saveStudent(StudentDTO studentDTO) throws SQLException;
}
