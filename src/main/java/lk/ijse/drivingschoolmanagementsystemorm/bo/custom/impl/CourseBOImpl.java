package lk.ijse.drivingschoolmanagementsystemorm.bo.custom.impl;

import lk.ijse.drivingschoolmanagementsystemorm.bo.SuperBO;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.CourseBO;
import lk.ijse.drivingschoolmanagementsystemorm.bo.util.EntityDTOConverter;
import lk.ijse.drivingschoolmanagementsystemorm.dao.DAOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.dao.DAOFactoryTypes;
import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.CourseDAO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.CourseDTO;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    private final CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOFactoryTypes.COURSE);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<CourseDTO> getAllCourse() throws SQLException {

        List<Course> courses = courseDAO.getAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();

        for (Course course : courses){

            courseDTOS.add(converter.getCourseDTO(course));

        }

        return courseDTOS;

    }

    @Override
    public String getNextId() throws SQLException {

        String lastID = courseDAO.getLastId();

        char tableChar = 'C';

        if (lastID != null){

            String lastNumberString = lastID.substring(1);
            int lastIdNumber = Integer.parseInt(lastNumberString);
            int nextIdNumber = lastIdNumber + 1;

            return String.format("%c%03d", tableChar, nextIdNumber);


        }

        return tableChar + "001";
    }
}
