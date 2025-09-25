package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.util.NavigationUtil;

public class PaymentPageController {
    public AnchorPane ancPayment;

    public void btnAddNewStudent(ActionEvent actionEvent) {

        NavigationUtil.navigateTo(ancPayment,"/view/payment/AddPayment.fxml");

    }
}
