package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOTypes;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.StudentBO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {

    private final StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try{
            loadNextId();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

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

    }

    @FXML
    void btnRemove(ActionEvent event) {

    }

    @FXML
    void btnSave(ActionEvent event) {

    }

    @FXML
    public void btnBack(ActionEvent actionEvent) {
    }

    private void loadNextId() throws SQLException {
        String nextId = studentBO.getNextId();
        lblStudentID.setText(nextId);
    }


}
