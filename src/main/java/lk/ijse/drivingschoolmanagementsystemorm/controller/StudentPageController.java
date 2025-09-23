package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {

    @FXML
    private AnchorPane ancStudent;

    @FXML
    private Button btnAddNewStudent;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colRegDate;

    @FXML
    private TableColumn<?, ?> colStudentId;

    @FXML
    private TableView<?> tblStudent;

    @FXML
    void btnAddNewStudent(ActionEvent event) {

        try{
            ancStudent.getChildren().clear();

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/AddStudent.fxml"));

            anchorPane.prefWidthProperty().bind(ancStudent.prefWidthProperty());
            anchorPane.prefHeightProperty().bind(ancStudent.prefHeightProperty());

            ancStudent.getChildren().add(anchorPane);

        }catch (Exception e){

            new Alert(Alert.AlertType.ERROR,"Page load faill!");
            e.printStackTrace();
        }

    }

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
