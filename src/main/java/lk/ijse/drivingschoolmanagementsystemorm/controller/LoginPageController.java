package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.drivingschoolmanagementsystemorm.dto.Roles;
import lk.ijse.drivingschoolmanagementsystemorm.dto.UserDTO;
import lk.ijse.drivingschoolmanagementsystemorm.util.AuthUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    public TextField txtUserName;
    public PasswordField txtPassword;

    private final List<UserDTO> userDTOS = new ArrayList<>();

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        boolean isLogin = false;

        for (UserDTO userDTO : userDTOS){

             isLogin = true;

            if (userDTO.getUserName().equals(userName) && userDTO.getPassword().equals(password)){

                Roles role = userDTO.getRole();
                AuthUtil.setUserDTO(userDTO);

                Stage window = (Stage)txtPassword.getScene().getWindow();
                window.close();

                if (role.equals(Roles.ADMIN)){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/DashbordAdmin.fxml"));
                    Stage stage =  new Stage();
                    stage.setFullScreen(true);
                    stage.setScene(new Scene(fxmlLoader.load()));
                    stage.show();

                }else {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/DashbordUser.fxml"));
                    Stage stage =  new Stage();
                    stage.setFullScreen(true);
                    stage.setScene(new Scene(fxmlLoader.load()));
                    stage.show();

                }
            }
        }

        if (!isLogin){
            new Alert(Alert.AlertType.ERROR,"Invlid username or password").show();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("user");
        userDTO.setPassword("1234");
        userDTO.setRole(Roles.USER);

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setUserName("admin");
        userDTO2.setPassword("1234");
        userDTO2.setRole(Roles.ADMIN);

        userDTOS.add(userDTO);
        userDTOS.add(userDTO2);
    }
}
