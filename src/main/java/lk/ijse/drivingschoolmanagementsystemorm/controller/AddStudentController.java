package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOTypes;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.StudentBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {

    private final StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
    public Button btnDelete;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try{
            loadNextId();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public AnchorPane ancAddStudent;

    @FXML
    private AnchorPane ancStudentRegisteration;

    @FXML
    public Button btnBack;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ListView<?> coursesListView;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label lblStudentID;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    void btnAdd(ActionEvent event) {

    }

    @FXML
    void btnCancel(ActionEvent event) {
        resetPage();
    }

    @FXML
    void btnRemove(ActionEvent event) {

    }

    @FXML
    void btnSave(ActionEvent event) {

        String studentId = lblStudentID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtContact.getText();
        String email = txtEmail.getText();
        LocalDate regDate = datePicker.getValue();

        StudentDTO studentDTO = new StudentDTO(
                studentId,
                name,
                address,
                phone,
                email,
                regDate
        );

        try {

            studentBO.saveStudent(studentDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"student save successfully!").show();
            resetPage();
        }catch (Exception e){

            e.printStackTrace();
            new Alert(Alert.AlertType.CONFIRMATION,"faill to save student!").show();

        }

    }

    @FXML
    public void btnBack(ActionEvent actionEvent) throws IOException {

       ancAddStudent.getChildren().clear();

       AnchorPane load = FXMLLoader.load(getClass().getResource("/view/StudentPage.fxml"));



       ancAddStudent.getChildren().add(load);
    }

    private void loadNextId() throws SQLException {
        String nextId = studentBO.getNextId();
        lblStudentID.setText(nextId);
    }

    private void  resetPage(){
        try {
            loadNextId();

            txtName.setText("");
            txtEmail.setText("");
            txtAddress.setText("");
            txtContact.setText("");
            datePicker.setValue(null);

        } catch (Exception e){

        }

    }

    public void setStudentData(StudentDTO studentDTO) {
        lblStudentID.setText(studentDTO.getStudentId());
        txtName.setText(studentDTO.getName());
        txtAddress.setText(studentDTO.getAddress());
        txtContact.setText(studentDTO.getPhone());
        txtEmail.setText(studentDTO.getEmail());
        datePicker.setValue(studentDTO.getRegistrarDate());
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
                String studentId = lblStudentID.getText();

                boolean isDeleted = studentBO.deleteStudent(studentId);

                if (isDeleted){
                    resetPage();
                    new Alert(
                            Alert.AlertType.INFORMATION, "student deleted successfully."
                    ).show();
                }else {
                    new Alert(Alert.AlertType.ERROR, "Fail to delete customer.").show();

                }
            }catch (Exception e){
                e.printStackTrace();
                new Alert(
                        Alert.AlertType.ERROR, "Fail to delete student..!"
                ).show();
            }

        }
    }

    public void btnUpdate(ActionEvent actionEvent) {

        String studentId = lblStudentID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtContact.getText();
        String email = txtEmail.getText();
        LocalDate regDate = datePicker.getValue();

        StudentDTO studentDTO = new StudentDTO(
                studentId,
                name,
                address,
                phone,
                email,
                regDate
        );


        try {

            studentBO.updateStudent(studentDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"student update successfully!").show();
            resetPage();

        }catch (Exception e){

            e.printStackTrace();
            new Alert(Alert.AlertType.CONFIRMATION,"faill to update student!").show();

        }
    }
}
