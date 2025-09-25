package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.util.NavigationUtil;

public class InstructorPageController {
    public AnchorPane ancInstructor;
    public Button btnAddNewInstructor;
    public TableView tblInstructor;
    public TableColumn colInstructorID;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colEmail;
    public TableColumn colSpeciality;

    public void btnAddNewInstructor(ActionEvent actionEvent) {
        NavigationUtil.navigateTo(ancInstructor,"/view/course/AddCourses.fxml");
    }

    public void onClickTable(MouseEvent mouseEvent) {
    }
}
