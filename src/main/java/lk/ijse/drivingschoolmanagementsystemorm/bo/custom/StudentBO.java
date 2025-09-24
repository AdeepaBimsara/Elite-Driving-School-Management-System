package lk.ijse.drivingschoolmanagementsystemorm.bo.custom;

import lk.ijse.drivingschoolmanagementsystemorm.bo.SuperBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentBO extends SuperBO {

    String getNextId() throws SQLException;

    void saveStudent(StudentDTO studentDTO) throws SQLException;

    List<StudentDTO> getAllStudent() throws SQLException;

    boolean deleteStudent(String id) throws  Exception;

    void updateStudent(StudentDTO studentDTO) throws Exception;


}
