import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.sql.SQLException;
import java.util.*;
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Stage window = stage;
        Parent menu = FXMLLoader.load(getClass().getResource("resources/menu.fxml"));
        window.setTitle("menu");
        window.setScene(new Scene(menu, 1280, 720));
        window.show();
    }

    public static void main (String[] args) throws SQLException, ClassNotFoundException {
        Manager manager = new Manager();
        LogisticWorker lworker = new LogisticWorker();
        CastWorker cworker = new CastWorker();

        manager.loadWorker();
        lworker.loadMaterial();
        lworker.loadWarehouse();
        cworker.loadCast();
        cworker.loadProject();
        cworker.loadForm();

        launch(args);
    }
}
