package lk.ijse.drivingschoolmanagementsystemorm.bo.custom;

import lk.ijse.drivingschoolmanagementsystemorm.bo.SuperBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.CourseDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface CourseBO extends SuperBO {

    List<CourseDTO> getAllCourse() throws SQLException;
}
