package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOTypes;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.CourseBO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddCourseController implements Initializable {
    public AnchorPane ancAddCourse;
    public Button btnBack;
    public Label lblCourseID;
    public TextField txtName;
    public TextField txtDuration;
    public TextField txtFee;
    public ListView lessonsListView;
    public Button btnAdd;
    public Button btnRemove;
    public ListView selectedLessonsListView;
    public Button btnSave;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnCancel;

    private final CourseBO courseBO = BOFactory.getInstance().getBO(BOTypes.COURSE);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try{
            loadNextId();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void loadNextId() throws SQLException {
        String nextId = courseBO.getNextId();
        lblCourseID.setText(nextId);
    }

    public void btnBack(ActionEvent actionEvent) {
    }

    public void btnSave(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void btnCancel(ActionEvent actionEvent) {
    }

    public void btnAdd(ActionEvent actionEvent) {
    }

    public void btnRemove(ActionEvent actionEvent) {

    }

}
