package lk.ijse.drivingschoolmanagementsystemorm.dao;

import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.impl.*;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Student;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){

        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;

    }

    public <T extends SuperDAO> T getDAO(DAOFactoryTypes daoTypes){

       return switch (daoTypes){
           case STUDENT -> (T) new StudentDAOImpl();
           case COURSE -> (T) new CourseDAOImpl();
           case INSTRUCTOR -> (T) new InstructorDAOImpl();
           case LESSON -> (T) new LessonDAOImpl();
           case PAYMENT -> (T) new PaymentDAOImpl();
           case QUERY -> (T) new QueryDAOImpl();
        };
    }
}
