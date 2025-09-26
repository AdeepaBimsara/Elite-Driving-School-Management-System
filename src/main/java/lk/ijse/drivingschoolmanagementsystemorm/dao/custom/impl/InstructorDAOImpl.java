package lk.ijse.drivingschoolmanagementsystemorm.dao.custom.impl;

import lk.ijse.drivingschoolmanagementsystemorm.config.FactoryConfiguration;
import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.InstructorDAO;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Instructor;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class InstructorDAOImpl implements InstructorDAO {
    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public String getLastId() throws SQLException {
        Session session = factoryConfiguration.getSession();

        try{
            Query<String> query = session.createQuery(
                    "SELECT ins.InstructorId FROM Instructor ins ORDER BY ins.InstructorId DESC",
                    String.class
            ).setMaxResults(1);

            List<String> list = query.list();

            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);

        }finally {

            session.close();

        }
    }

    @Override
    public boolean save(Instructor instructor) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.persist(instructor);
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
    public Optional<Instructor> findById(String id) throws SQLException {
        Session session = factoryConfiguration.getSession();

        try {

            Instructor instructor = session.get(Instructor.class, id);
            return Optional.ofNullable(instructor);

        }finally {

            session.close();
        }
    }

    @Override
    public List<Instructor> getAll() throws SQLException {
        Session session = factoryConfiguration.getSession();
        try {
            Query<Instructor> query = session.createQuery("FROM Instructor", Instructor.class);
            List<Instructor> instructorList = query.list();

            return instructorList;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Instructor instructor = session.get(Instructor.class, id);
            if (instructor != null){
                session.remove(instructor);
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
    public boolean update(Instructor instructor) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try{

            session.merge(instructor);
            transaction.commit();
            return true;

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
}
