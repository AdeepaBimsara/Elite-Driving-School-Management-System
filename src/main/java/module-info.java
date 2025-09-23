module lk.ijse.drivingschoolmanagementsystemorm {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;
    requires javafx.graphics;

    requires java.naming; //naming

    //entity package not open Hibernate module
    requires org.hibernate.orm.core; //add Hirbernate module
    requires jakarta.persistence; //JPA

    //access  to Hibernate
    opens lk.ijse.drivingschoolmanagementsystemorm.entity to org.hibernate.orm.core;

    opens lk.ijse.drivingschoolmanagementsystemorm.controller to javafx.fxml;
    exports lk.ijse.drivingschoolmanagementsystemorm;
}