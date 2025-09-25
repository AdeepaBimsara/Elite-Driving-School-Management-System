package lk.ijse.drivingschoolmanagementsystemorm;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.drivingschoolmanagementsystemorm.config.FactoryConfiguration;
import org.hibernate.Session;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);

        Session currentSession1 = FactoryConfiguration.getInstance().getCurrentSession();
        Session currentSession2 = FactoryConfiguration.getInstance().getCurrentSession();

        System.out.println("=========== Current session");
        System.out.println(currentSession1 == currentSession2);
        System.out.println(currentSession1.equals(currentSession2));

        System.out.println("==============================");
        Session session1 = FactoryConfiguration.getInstance().getSession();
        Session session2 = FactoryConfiguration.getInstance().getSession();

        System.out.println(session1 == session2);
        System.out.println(session1.equals(session2));

    }

    @Override
    public void start(Stage stage) throws IOException {
//         fxmlLoader = new FXMLLoader(AppInitializer.class.getResource("/view/LoginPage.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setMaximized(true);
//        stage.setTitle("DrivingSchool");
//        stage.setScene(scene);
//        stage.show();

        stage.setScene(new Scene(
                new FXMLLoader(getClass().getResource("/view/LoadingScreen.fxml")).load()
        ));
        stage.show();

        Task<Scene> loadingTask = new Task<>() {
            @Override
            protected Scene call() throws Exception {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login/LoginPage.fxml"));
                    return new Scene(fxmlLoader.load());
            }
        };

        loadingTask.setOnSucceeded(event ->{

            Scene value = loadingTask.getValue();

            stage.setTitle("Dashbord");
            stage.setScene(value);

        } );

        loadingTask.setOnFailed(event -> {
            System.out.println("faill to load app ");
            new Alert(Alert.AlertType.ERROR,"faill app").show();
        });

        new Thread(loadingTask).start();
    }


}
