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
import lk.ijse.drivingschoolmanagementsystemorm.bo.custom.CourseBO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.CourseDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.tm.CourseTM;
import lk.ijse.drivingschoolmanagementsystemorm.dto.tm.StudentTM;
import lk.ijse.drivingschoolmanagementsystemorm.util.NavigationUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CoursePageController implements Initializable {

    CourseBO courseBO = BOFactory.getInstance().getBO(BOTypes.COURSE);

    public AnchorPane ancCourse;
    public Button btnAddNewCourse;

    public TableView<CourseTM> tblCourse;

    public TableColumn<CourseTM, String> colCourseID;
    public TableColumn<CourseTM, String> colName;
    public TableColumn<CourseTM, Double> colFee;
    public TableColumn<CourseTM, Integer> colDuration;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colCourseID.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

        try {
            loadTableData();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void btnAddNewCourse(ActionEvent actionEvent) {

        NavigationUtil.navigateTo(ancCourse, "/view/course/AddCourses.fxml");
    }

    private void loadTableData() throws SQLException {

        tblCourse.setItems(FXCollections.observableArrayList(
                courseBO.getAllCourse().stream().map(courseDTO ->
                        new CourseTM(
                                courseDTO.getCourseId(),
                                courseDTO.getName(),
                                courseDTO.getDescription(),
                                courseDTO.getFee(),
                                courseDTO.getDuration()
                        )).toList()
        ));

//        tblCourse.setItems(FXCollections.observableArrayList(
//                new CourseTM("C001", "Car", "Car license", 50000.0, 30),
//                new CourseTM("C002", "Bike", "Bike license", 30000.0, 20)
//        ));

//
//        System.out.println(courseBO.getAllCourse());
//        System.out.println("Course count: " + courseBO.getAllCourse().size());

    }


    public void onMouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {

            CourseTM selectedItem = tblCourse.getSelectionModel().getSelectedItem();

            try {
                if (selectedItem != null) {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/course/AddCourses.fxml"));
                    AnchorPane anchorPane = loader.load();

                    AddCourseController controller = loader.getController();

                    CourseDTO courseDTO = new CourseDTO(
                            selectedItem.getCourseId(),
                            selectedItem.getName(),
                            selectedItem.getDescription(),
                            selectedItem.getFee(),
                            selectedItem.getDuration()
                    );

                    controller.setCourseData(courseDTO);

                    ancCourse.getChildren().clear();
                    anchorPane.prefWidthProperty().bind(ancCourse.prefWidthProperty());
                    anchorPane.prefHeightProperty().bind(ancCourse.prefHeightProperty());
                    ancCourse.getChildren().add(anchorPane);
                }


            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Failed to load student form!").show();

            }
        }
    }
}
