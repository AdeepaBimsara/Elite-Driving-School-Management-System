package lk.ijse.drivingschoolmanagementsystemorm.bo.custom;

import lk.ijse.drivingschoolmanagementsystemorm.bo.SuperBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.InstructorDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface InstructorBO extends SuperBO {

    List<InstructorDTO> getAllInstructor() throws SQLException;

    String getNextId() throws SQLException;

    void saveInstructor(InstructorDTO instructorDTO) throws SQLException;

    boolean deleteInstructor(String id) throws  Exception;

    void updateInstructor(InstructorDTO instructorDTO) throws Exception;
}
