package lk.ijse.drivingschoolmanagementsystemorm.dao.custom.impl;

import lk.ijse.drivingschoolmanagementsystemorm.config.FactoryConfiguration;
import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.StudentDAO;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO {

    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public String getLastId() {
        Session session = factoryConfiguration.getSession();

        try{
            Query<String> query = session.createQuery(
                    "SELECT stu.studentId FROM Student stu ORDER BY stu.studentId DESC",
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
    public boolean save(Student student) throws SQLException {

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.persist(student);
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
    public Optional<Student> findById(String id) throws SQLException {
        Session session = factoryConfiguration.getSession();

        try {

            Student student = session.get(Student.class, id);
            return Optional.ofNullable(student);

        }finally {

            session.close();
        }
    }

    @Override
    public List<Student> getAll() throws SQLException {
        Session session = factoryConfiguration.getSession();
        try {
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            List<Student> studentList = query.list();

            return studentList;
        }finally {
            session.close();
        }
    }
}
