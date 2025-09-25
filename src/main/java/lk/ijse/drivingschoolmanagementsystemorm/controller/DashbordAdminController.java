package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashbordAdminController implements Initializable {

    public AnchorPane ancMainContainer;
    @FXML
    private Button btnAdminDAshbord;

    @FXML
    private Button btnCourse;

    @FXML
    private Button btnInstructor;

    @FXML
    private Button btnLesson;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnStudent;

    @FXML
    void btnAdminDAshbordOnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/dashbord/DashbordAdmin.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.show();


    }

    @FXML
    void btnCourseOnAction(ActionEvent event) {
            navigateTo("/view/course/CoursePage.fxml");
    }

    @FXML
    void btnInstructorOnAction(ActionEvent event) {
            navigateTo("/view/instructor/InstructorPage.fxml");
    }

    @FXML
    void btnLessonOnAction(ActionEvent event) {
            navigateTo("/view/lesson/LessonPage.fxml");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/login/LoginPage.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.show();
    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) {
            navigateTo("/view/payment/PaymentPage.fxml");
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
        navigateTo("/view/student/StudentPage.fxml");
    }

    private void navigateTo(String path){

        try{
            ancMainContainer.getChildren().clear();

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));

            anchorPane.prefWidthProperty().bind(ancMainContainer.prefWidthProperty());
            anchorPane.prefHeightProperty().bind(ancMainContainer.prefHeightProperty());

            ancMainContainer.getChildren().add(anchorPane);

        }catch (Exception e){

            new Alert(Alert.AlertType.ERROR,"Page load faill!");
            e.printStackTrace();
        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//            navigateTo("/view/DashbordAdmin.fxml");
    }
}
