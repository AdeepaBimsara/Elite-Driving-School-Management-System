package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOTypes;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.InstructorBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.InstructorDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;
import lk.ijse.drivingschoolmanagementsystemorm.util.NavigationUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddInstructorController implements Initializable {
    public AnchorPane ancAddInstructor;
    public Button btnBack;
    public Label lblinstructorID;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtContact;
    public ComboBox <String> cmbSpecialty;
    public ListView courseListView;
    public Button btnAdd;
    public Button btnRemove;
    public ListView selectedCoursesListView;
    public Button btnSave;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnCancel;

    private final InstructorBO instructorBO = BOFactory.getInstance().getBO(BOTypes.INSTRUCTOR);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try{
            resetPage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setInstructorData(InstructorDTO instructorDTO) {
        lblinstructorID.setText(instructorDTO.getInstructorId());
        txtName.setText(instructorDTO.getName());
        txtEmail.setText(instructorDTO.getEmail());
        txtContact.setText(instructorDTO.getPhone());
        cmbSpecialty.setValue(instructorDTO.getSpecialization());
    }

    public void btnBack(ActionEvent actionEvent) {
        NavigationUtil.navigateTo(ancAddInstructor, "/view/instructor/InstructorPage.fxml");
    }

    public void btnAdd(ActionEvent actionEvent) {
    }

    public void btnRemove(ActionEvent actionEvent) {
    }

    public void btnSave(ActionEvent actionEvent) {
        String id = lblinstructorID.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String phone = txtContact.getText();
        String specialty = cmbSpecialty.getValue();

        InstructorDTO instructorDTO = new InstructorDTO(
                id,
                name,
                email,
                phone,
                specialty
        );

        try {
            instructorBO.saveInstructor(instructorDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"instructor save successfully!").show();

        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"faill to save instructor!").show();
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
                String instructorId = lblinstructorID.getText();

                boolean isDeleted = instructorBO.deleteInstructor(instructorId);

                if (isDeleted){
                    resetPage();
                    new Alert(
                            Alert.AlertType.INFORMATION, "instructor deleted successfully."
                    ).show();
                }else {
                    new Alert(Alert.AlertType.ERROR, "Fail to delete instructor.").show();

                }
            }catch (Exception e){
                e.printStackTrace();
                new Alert(
                        Alert.AlertType.ERROR, "Fail to delete instructor..!"
                ).show();
            }

        }
    }

    public void btnUpdate(ActionEvent actionEvent) {

        String id = lblinstructorID.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String phone = txtContact.getText();
        String specialty = cmbSpecialty.getValue();

        InstructorDTO instructorDTO = new InstructorDTO(
                id,
                name,
                email,
                phone,
                specialty
        );

        try {
            instructorBO.updateInstructor(instructorDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"instructor update successfully!").show();

        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"faill to update instructor!").show();
        }


    }

    public void btnCancel(ActionEvent actionEvent) {

        resetPage();
        
    }

    private void loadNextId() throws SQLException {
        String nextId = instructorBO.getNextId();
        lblinstructorID.setText(nextId);
    }

    private void  resetPage(){
        try{
            loadNextId();

            txtName.setText("");
            txtEmail.setText("");
            txtContact.setText("");
            cmbSpecialty.setValue(null);

        }catch (Exception e){
            e.printStackTrace();
        }




    }


}
