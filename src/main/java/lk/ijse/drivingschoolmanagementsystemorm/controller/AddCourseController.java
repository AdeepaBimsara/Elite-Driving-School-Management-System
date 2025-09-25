package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOTypes;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.CourseBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.CourseDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddCourseController implements Initializable {
    public AnchorPane ancAddCourse;
    public Button btnBack;
    public Label lblCourseID;
    public TextField txtName;
    public TextField txtdis;
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
       String id =  lblCourseID.getText();
       String name = txtName.getText();
       String dis = txtdis.getText();
       Double fee = Double.valueOf(txtFee.getText());
       int dura = Integer.parseInt(txtDuration.getText());

        CourseDTO courseDTO = new CourseDTO(
                id,
                name,
                dis,
                fee,
                dura
        );

        try{

            courseBO.saveCourse(courseDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"course save successfully!").show();

        }catch (Exception e){

            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"faill to save course!").show();
        }
    }

    public void btnDelete(ActionEvent actionEvent) {

        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are your sure ?",
                ButtonType.YES,
                ButtonType.NO
        );

        Optional<ButtonType> response = alert.showAndWait();

        if (response.isPresent() && response.get() == ButtonType.YES){

            try{
                String courseId = lblCourseID.getText();

                boolean isDeleted = courseBO.deleteCourse(courseId);

                if (isDeleted){

                    new Alert(
                            Alert.AlertType.INFORMATION, "course deleted successfully."
                    ).show();
                }else {
                    new Alert(Alert.AlertType.ERROR, "Fail to delete course.").show();

                }
            }catch (Exception e){
                e.printStackTrace();
                new Alert(
                        Alert.AlertType.ERROR, "Fail to delete course..!"
                ).show();
            }

        }
    }

    public void btnUpdate(ActionEvent actionEvent) {

        String id =  lblCourseID.getText();
        String name = txtName.getText();
        String dis = txtdis.getText();
        Double fee = Double.valueOf(txtFee.getText());
        int dura = Integer.parseInt(txtDuration.getText());

        CourseDTO courseDTO = new CourseDTO(
                id,
                name,
                dis,
                fee,
                dura
        );

        try{

            courseBO.updateStudent(courseDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"course update successfully!").show();

        }catch (Exception e){

            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"faill to update course!").show();
        }
    }

    public void btnCancel(ActionEvent actionEvent) {
    }

    public void btnAdd(ActionEvent actionEvent) {
    }

    public void btnRemove(ActionEvent actionEvent) {

    } public void setCourseData(CourseDTO courseDTO) {

        lblCourseID.setText(courseDTO.getCourseId());
        txtName.setText(courseDTO.getName());
        txtdis.setText(courseDTO.getDescription());
        txtFee.setText(String.valueOf(courseDTO.getFee()));
        txtDuration.setText(String.valueOf(courseDTO.getDuration()));
    }



}
