package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.dto.tm.StudentTM;
import lk.ijse.drivingschoolmanagementsystemorm.util.NavigationUtil;

public class CoursePageController {
    public AnchorPane ancCourse;
    public Button btnAddNewCourse;

    public TableView tblCourse;

    public TableColumn colCourseID;
    public TableColumn colName;
    public TableColumn colFee;
    public TableColumn colDuration;

    public void btnAddNewCourse(ActionEvent actionEvent) {

        NavigationUtil.navigateTo(ancCourse,"/view/course/AddCourses.fxml");
    }
}
