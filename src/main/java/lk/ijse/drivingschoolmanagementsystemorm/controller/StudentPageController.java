package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOTypes;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.StudentBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.tm.StudentTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class StudentPageController implements Initializable {

    private final StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);

    @FXML
    private AnchorPane ancStudent;

    @FXML
    private Button btnAddNewStudent;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<StudentTM, String> colAddress;

    @FXML
    private TableColumn<StudentTM, String> colContact;

    @FXML
    private TableColumn<StudentTM, String> colEmail;

    @FXML
    private TableColumn<StudentTM, String> colName;

    @FXML
    private TableColumn<StudentTM, String> colRegDate;

    @FXML
    private TableColumn<StudentTM, String> colStudentId;

    @FXML
    private TableView<StudentTM> tblStudent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colRegDate.setCellValueFactory(new PropertyValueFactory<>("registrarDate"));

        try {
            loadTableData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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

    private void loadTableData() throws SQLException {

        tblStudent.setItems(FXCollections.observableArrayList(

                studentBO.getAllStudent().stream().map(studentDTO ->
                new StudentTM(
                        studentDTO.getStudentId(),
                        studentDTO.getName(),
                        studentDTO.getAddress(),
                        studentDTO.getPhone(),
                        studentDTO.getEmail(),
                        studentDTO.getRegistrarDate()

                        )).toList()
        ));
    }
}
