package lk.ijse.drivingschoolmanagementsystemorm.dao.custom.impl;

import lk.ijse.drivingschoolmanagementsystemorm.config.FactoryConfiguration;
import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.CourseDAO;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Course;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CourseDAOImpl implements CourseDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public String getLastId() throws SQLException {
        return "";
    }

    @Override
    public boolean save(Object o) throws SQLException {
        return false;
    }

    @Override
    public Optional findById(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List getAll() throws SQLException {
        Session session = factoryConfiguration.getSession();

        try{
            Query<Course> query = session.createQuery("FROM Course" , Course.class);
            List<Course> courseList = query.list();

            System.out.println("DB Courses: " + courseList); // Debug

            return courseList;
        }finally {
            session.close();
        }

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Object o) throws SQLException {
        return false;
    }
}
