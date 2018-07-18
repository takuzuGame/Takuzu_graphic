package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Button EasyButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent Easy = FXMLLoader.load(getClass().getResource("Easy4x4.fxml"));
        Parent Medium = FXMLLoader.load(getClass().getResource("Medium6x6.fxml"));
        Parent Hard = FXMLLoader.load(getClass().getResource("Hard8x8.fxml"));
        window = primaryStage;
        window.setTitle("Takuzu");
        //window.setScene(new Scene(root, 670, 376));
        window.setScene(new Scene(Easy, 265, 358));
        window.setScene(new Scene(Medium, 395, 494));
        window.setScene(new Scene(Hard, 529, 615));

       // StackPane layout = new StackPane();


        //window.setScene(scene);
        window.show();
    }


}