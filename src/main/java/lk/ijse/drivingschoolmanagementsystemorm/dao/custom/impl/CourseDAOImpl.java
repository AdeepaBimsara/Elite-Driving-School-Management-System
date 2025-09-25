package lk.ijse.drivingschoolmanagementsystemorm.dao.custom.impl;

import lk.ijse.drivingschoolmanagementsystemorm.config.FactoryConfiguration;
import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.CourseDAO;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Course;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CourseDAOImpl implements CourseDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public String getLastId() throws SQLException {

        Session session = factoryConfiguration.getSession();

        try {
            Query<String> query = session.createQuery(
                    "SELECT c.courseId FROM Course c ORDER BY c.courseId DESC",
                    String.class
            ).setMaxResults(1);

            List<String> list = query.list();

            if (list.isEmpty()){
                return null;
            }
            return list.get(0);
        }finally {
            session.close();
        }
    }

    @Override
    public boolean save(Course course) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.persist(course);
            transaction.commit();
            return true;

        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }


    @Override
    public Optional findById(String id) throws SQLException {
        Session session = factoryConfiguration.getSession();

        try {

            Course course = session.get(Course.class, id);
            return Optional.ofNullable(course);

        }finally {

            session.close();
        }
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
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Course course = session.get(Course.class, id);
            if (course != null){
                session.remove(course);
                transaction.commit();
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();

            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Course course) throws SQLException {
        return false;
    }

}
