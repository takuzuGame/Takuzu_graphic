package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.puzzle.init8;
import sample.puzzle.setPuzzle;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.ResourceBundle;

public class hardController implements Initializable {
   /*@FXML
    private JFXButton hardSubmit;

    int counter;

    private setPuzzle [] tabPuzz=new setPuzzle[2];
    @Override
    */
    public void initialize(URL location, ResourceBundle resources) {

    }/*
    public void setTabPuzz(setPuzzle[] tabPuzz) {
        this.tabPuzz = tabPuzz;
    }


    private setPuzzle[] defaultPuzzle (){
        setPuzzle p= new setPuzzle();
        setPuzzle f= new setPuzzle();
        setPuzzle[] tabPuzz = new setPuzzle[2];
        init8 m8 = new init8();
        p =p.Initialize(6);
        p= p.intialPuzzle8(m8,p);
        f= f.emptycel(p);
        tabPuzz[0]=f;
        tabPuzz[1]=p;
        return (tabPuzz);
    }
    */
    @FXML
    public void Submit8x8(){

    }
    @FXML
    public void Reset8x8(){

    }
}
