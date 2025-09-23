package lk.ijse.drivingschoolmanagementsystemorm.dao.custom.impl;

import lk.ijse.drivingschoolmanagementsystemorm.config.FactoryConfiguration;
import lk.ijse.drivingschoolmanagementsystemorm.dao.custom.StudentDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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
}
