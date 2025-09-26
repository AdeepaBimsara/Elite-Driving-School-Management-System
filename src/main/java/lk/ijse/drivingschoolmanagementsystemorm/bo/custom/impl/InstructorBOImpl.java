package lk.ijse.drivingschoolmanagementsystemorm.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.InstructorBO;
import lk.ijse.drivingschoolmanagementsystemorm.bo.util.EntityDTOConverter;
import lk.ijse.drivingschoolmanagementsystemorm.dao.DAOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.dao.DAOFactoryTypes;
import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.InstructorDAO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.InstructorDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Instructor;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructorBOImpl implements InstructorBO {

    private final InstructorDAO instructorDAO = DAOFactory.getInstance().getDAO(DAOFactoryTypes.INSTRUCTOR);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<InstructorDTO> getAllInstructor() throws SQLException {

        List<Instructor> instructors = instructorDAO.getAll();
        List<InstructorDTO> instructorDTOS = new ArrayList<>();

        for (Instructor instructor : instructors){

            instructorDTOS.add(converter.getInstructorDTO(instructor));

        }

        return instructorDTOS;
    }

    @Override
    public String getNextId() throws SQLException {
        String lastID = instructorDAO.getLastId();

        char tableChar = 'I';

        if (lastID != null){

            String lastNumberString = lastID.substring(1);
            int lastIdNumber = Integer.parseInt(lastNumberString);
            int nextIdNumber = lastIdNumber + 1;

            return String.format("%c%03d", tableChar, nextIdNumber);


        }

        return tableChar + "001";
    }

    @Override
    public void saveInstructor(InstructorDTO instructorDTO) throws SQLException {

        Optional<Instructor> optionalStudent = instructorDAO.findById(instructorDTO.getInstructorId());

        if (optionalStudent.isPresent()){
            new Alert(Alert.AlertType.ERROR,"Duplicate instructor id").show();
        }

        Instructor instructor = converter.getInstructor(instructorDTO);

        boolean save = instructorDAO.save(instructor);
    }

    @Override
    public boolean deleteInstructor(String id) throws Exception {
        Optional<Instructor> optionalStudent = instructorDAO.findById(id);

        if (optionalStudent.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"instructor not found");
        }

        try{
            boolean delete = instructorDAO.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void updateInstructor(InstructorDTO instructorDTO) throws Exception {

        Optional<Instructor> optionalCustomer = instructorDAO.findById(instructorDTO.getInstructorId());

        if (optionalCustomer.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"instructor not found");
        }

        Instructor instructor = converter.getInstructor(instructorDTO);
        instructorDAO.update(instructor);

    }
}
