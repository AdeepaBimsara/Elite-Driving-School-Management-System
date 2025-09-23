package lk.ijse.drivingschoolmanagementsystemorm.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.StudentBO;
import lk.ijse.drivingschoolmanagementsystemorm.bo.util.EntityDTOConverter;
import lk.ijse.drivingschoolmanagementsystemorm.dao.DAOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.dao.DAOFactoryTypes;
import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.StudentDAO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Student;

import java.sql.SQLException;
import java.util.Optional;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactoryTypes.STUDENT);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public String getNextId() throws SQLException {

        String lastID = studentDAO.getLastId();

        char tableChar = 'S';

        if (lastID != null){

            String lastNumberString = lastID.substring(1);
            int lastIdNumber = Integer.parseInt(lastNumberString);
            int nextIdNumber = lastIdNumber + 1;

            return String.format("%c%03d", tableChar, nextIdNumber);


        }

        return tableChar + "001";

    }

    @Override
    public void saveStudent(StudentDTO studentDTO) throws SQLException {

        Optional <Student> optionalStudent = studentDAO.findById(studentDTO.getStudentId());

        if (optionalStudent.isPresent()){
           new Alert(Alert.AlertType.ERROR,"Duplicate student id").show();
        }

        Student student = converter.getStudent(studentDTO);

        boolean save = studentDAO.save(student);

    }
}
