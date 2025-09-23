package lk.ijse.drivingschoolmanagementsystemorm.bo.custom.impl;

import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.StudentBO;
import lk.ijse.drivingschoolmanagementsystemorm.dao.DAOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.dao.DAOFactoryTypes;
import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.StudentDAO;

import java.sql.SQLException;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactoryTypes.STUDENT);
    @Override
    public String getNextId() throws SQLException {

        String lastID = studentDAO.getLastId();
        char tableChar = 'S';
        if (lastID != null){
            String lastNumberString = lastID.substring(1);
            int lastIdNumber = Integer.parseInt(lastNumberString);
            int nextIdNumber = lastIdNumber + 1;

            return String.format(tableChar + "%03d" +  nextIdNumber);

        }

        return tableChar + "001";

    }
}
