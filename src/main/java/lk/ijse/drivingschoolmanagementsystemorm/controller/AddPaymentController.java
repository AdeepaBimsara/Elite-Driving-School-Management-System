package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.util.NavigationUtil;

public class AddPaymentController {
    public AnchorPane ancAddPayment;
    public Button btnBack;
    public Label lblPaymentID;
    public ComboBox<String> cmbStudent;
    public ListView<String> courseListView;
    public Label lblAmount;
    public TextField txtAmountPaid;
    public DatePicker dpDate;
    public ComboBox<String> cmbStatus;
    public Button btnSave;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnCancel;

    public void btnBack(ActionEvent actionEvent) {
        NavigationUtil.navigateTo(ancAddPayment, "/view/payment/PaymentPage.fxml");
    }

    public void btnSave(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void btnCancel(ActionEvent actionEvent) {

    }
}
