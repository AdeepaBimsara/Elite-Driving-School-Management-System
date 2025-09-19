module lk.ijse.drivingschoolmanagementsystemorm {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;
    requires javafx.graphics;
    requires org.hibernate.orm.core;


    opens lk.ijse.drivingschoolmanagementsystemorm.controller to javafx.fxml;
    exports lk.ijse.drivingschoolmanagementsystemorm;
}