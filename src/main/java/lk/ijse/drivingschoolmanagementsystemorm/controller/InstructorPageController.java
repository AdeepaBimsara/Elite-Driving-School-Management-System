package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOFactory;
import lk.ijse.drivingschoolmanagementsystemorm.bo.BOTypes;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.InstructorBO;
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.StudentBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.InstructorDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.tm.InstructorTM;
import lk.ijse.drivingschoolmanagementsystemorm.dto.tm.StudentTM;
import lk.ijse.drivingschoolmanagementsystemorm.util.NavigationUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InstructorPageController implements Initializable {
    public AnchorPane ancInstructor;
    public Button btnAddNewInstructor;
    public TableView <InstructorTM> tblInstructor;
    public TableColumn <InstructorTM,String> colInstructorID;
    public TableColumn <InstructorTM,String> colName;
    public TableColumn <InstructorTM,String> colContact;
    public TableColumn <InstructorTM,String> colEmail;
    public TableColumn <InstructorTM,String> colSpeciality;

    private final InstructorBO instructorBO = BOFactory.getInstance().getBO(BOTypes.INSTRUCTOR);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colInstructorID.setCellValueFactory(new PropertyValueFactory<>("InstructorId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colSpeciality.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        try{
            loadTableData();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void btnAddNewInstructor(ActionEvent actionEvent) {
        NavigationUtil.navigateTo(ancInstructor,"/view/instructor/AddInstructors.fxml");
    }

    public void onClickTable(MouseEvent mouseEvent) {

        if (mouseEvent.getClickCount() == 2){

            InstructorTM selectedItem = tblInstructor.getSelectionModel().getSelectedItem();

            try {
                if (selectedItem != null) {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/instructor/AddInstructors.fxml" ));
                    AnchorPane anchorPane = loader.load();

                    AddInstructorController controller = loader.getController();

                    InstructorDTO instructorDTO = new InstructorDTO(
                            selectedItem.getInstructorId(),
                            selectedItem.getName(),
                            selectedItem.getEmail(),
                            selectedItem.getPhone(),
                            selectedItem.getSpecialization()
                    );

                    controller.setInstructorData(instructorDTO);

                    ancInstructor.getChildren().clear();
                    anchorPane.prefWidthProperty().bind(ancInstructor.prefWidthProperty());
                    anchorPane.prefHeightProperty().bind(ancInstructor.prefHeightProperty());
                    ancInstructor.getChildren().add(anchorPane);
                }
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Failed to load student form!").show();

            }
        }
    }

    private void loadTableData() throws SQLException {

        tblInstructor.setItems(FXCollections.observableArrayList(

                instructorBO.getAllInstructor().stream().map(instructorDTO ->
                        new InstructorTM(
                                instructorDTO.getInstructorId(),
                                instructorDTO.getName(),
                                instructorDTO.getEmail(),
                                instructorDTO.getPhone(),
                                instructorDTO.getSpecialization()

                        )).toList()
        ));
    }


}
