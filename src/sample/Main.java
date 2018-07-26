package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application  {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        window = primaryStage;
        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        window.getIcons().add(icon);
        window.setTitle("Takuzu");
        window.setScene(new Scene(root, 653, 540));
        window.setResizable(false);


        window.show();
        for (int i = 0; i <16 ; i++) {

    }


}
}