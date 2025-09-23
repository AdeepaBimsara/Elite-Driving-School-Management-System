package lk.ijse.drivingschoolmanagementsystemorm.config;

import lk.ijse.drivingschoolmanagementsystemorm.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        //(xml) load
        Configuration configuration = new Configuration();
        configuration.configure();

        //add entity classes
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Payment.class);
        configuration.addAnnotatedClass(Enrollment.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Learning.class);
        configuration.addAnnotatedClass(Lesson.class);

        //create session factory
        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance(){

            return factoryConfiguration == null ?
                    factoryConfiguration = new FactoryConfiguration() :
                    factoryConfiguration;

    }

//    public Session getSession(){
//        Session session = sessionFactory.openSession();
//        return session;
//    }

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
