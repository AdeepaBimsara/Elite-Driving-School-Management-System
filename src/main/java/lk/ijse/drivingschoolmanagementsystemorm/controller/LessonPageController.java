package lk.ijse.drivingschoolmanagementsystemorm.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.drivingschoolmanagementsystemorm.util.NavigationUtil;

public class LessonPageController {
    public AnchorPane ancLesson;

    public void btnAddNewLesson(ActionEvent actionEvent) {
        NavigationUtil.navigateTo(ancLesson,"/view/lesson/AddLesson.fxml");
    }
}
