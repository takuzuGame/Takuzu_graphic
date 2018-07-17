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
        window = primaryStage;
        window.setTitle("Takuzu");
        window.setScene(new Scene(root, 300, 250));
        EasyButton = new Button("Easy");

        StackPane layout = new StackPane();
        layout.getChildren().add(EasyButton);
        //Scene scene = new Scene(layout, 300, 250);

        //window.setScene(scene);
        window.show();
    }


}