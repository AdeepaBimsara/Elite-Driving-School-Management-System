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

public class DashbordUserController implements Initializable {

    public AnchorPane ancMainContainerUser;
    @FXML
    private Button btnLesson;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnStudent;

    @FXML
    private Button btnUserDashbord;

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

    @FXML
    void btnUserDashbordOnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/dashbord/DashbordUser.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.show();
    }

    private void navigateTo(String path){

        try{
            ancMainContainerUser.getChildren().clear();

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));

            anchorPane.prefWidthProperty().bind(ancMainContainerUser.prefWidthProperty());
            anchorPane.prefHeightProperty().bind(ancMainContainerUser.prefHeightProperty());

            ancMainContainerUser.getChildren().add(anchorPane);

        }catch (Exception e){

            new Alert(Alert.AlertType.ERROR, "Page not found..!").show();
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
