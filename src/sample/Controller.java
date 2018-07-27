/*
* this file is the controller of the main window that manipulate all the window to pup up
* */

package sample;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private JFXButton HowToPlay;

    @FXML
    private void showDialog(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HowToPlay.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("How To Play");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Sorry can't load the window");
        }
    }
    @FXML
    private void OpenEasy(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Easy4x4.fxml"));
            Parent Easy = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            stage.getIcons().add(icon);
            stage.setTitle("Takuzu Easy Level");
            stage.setScene(new Scene(Easy, 265, 358));
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            System.out.println("Sorry can't load the window");
        }
    }
    @FXML
    private void OpenMedium(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Medium6x6.fxml"));
            Parent Medium = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            stage.getIcons().add(icon);
            stage.setTitle("Takuzu Medium Level");
            stage.setScene(new Scene(Medium, 395, 494));
            stage.setResizable(false);
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            System.out.println("Sorry can't load the window");
        }
    }
    @FXML
    private void OpenHard(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Hard8x8.fxml"));
            Parent Hard = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            Image icon = new Image(getClass().getResourceAsStream("icon.png"));
            stage.getIcons().add(icon);
            stage.setTitle("Takuzu Medium Level");
            stage.setScene(new Scene(Hard, 529, 615));
            stage.setResizable(false);

            stage.show();
        }catch (Exception e){
            System.out.println("Sorry can't load the window");
        }
    }

}
