package sample;
import sample.puzzle.zeroOneButton;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.ResourceBundle;

public class easyController implements Initializable{

        @FXML
         private JFXButton easyButton0,easyButton1,easyButton2,easyButton3,easyButton4,easyButton5,easyButton6,easyButton7,easyButton8,easyButton9,
                easyButton10,easyButton11,easyButton12,easyButton13,easyButton14,easyButton15,easySubmit,easyReset;

        int counter=-1;
        final char ONE='1';
        final char ZERO='0';
        final char BLANK='x';
    @FXML private JFXButton [] easybutton;

    {
        easybutton = new JFXButton[]{easyButton0, easyButton1, easyButton2, easyButton3, easyButton4, easyButton5, easyButton6, easyButton7, easyButton8, easyButton9,
                easyButton10, easyButton11, easyButton12, easyButton13, easyButton14, easyButton15};
    }

    @FXML
    public JFXButton []getEasybutton(){
        return easybutton;
    }
    @Override
    //initialization of all the button of the 4x4 puzzle
    public void initialize(URL location, ResourceBundle resources) {
        JFXButton easybutton [] = {easyButton0,easyButton1,easyButton2,easyButton3,easyButton4,easyButton5,easyButton6,easyButton7,easyButton8,easyButton9,
                easyButton10,easyButton11,easyButton12,easyButton13,easyButton14,easyButton15};
        JFXButton buttonToDisable = easybutton[0];

        buttonToDisable.setOnAction(event -> setOneZero(buttonToDisable));
        for (int i = 0; i <16; i++) {

            easybutton[i].setText("");

           final JFXButton button = easybutton[i];

            button.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    setOneZero(button);

                }


            });

        }

   }
//set zero and ones and empty cell in puzzle

    public void setOneZero(JFXButton button){
        if(button.getText().equals("")){
            button.setText("1");
            button.setFont(Font.font(30));
            button.setTextFill(Paint.valueOf("white"));
            counter++;
        }else if (button.getText().equals("1")){
            button.setText("0");
            button.setFont(Font.font(30));
            button.setTextFill(Paint.valueOf("white"));
        }else {
            button.setText("");
            counter--;
        }
        if (counter>=15){
            easySubmit.setDisable(false);
        }else{
            easySubmit.setDisable(true);
    }
    }



    @FXML
    private void Submit4x4(){

    }
    @FXML
    private void Reset4x4(){

    }
/*
    private boolean isValidePuzzle(char [][] puzzle){
        int zero=0,one=1;
        final int size = 4;
        //checks the rows for too many 1's or 0's
        for (int i = 0; i <size; i++) {
            for (int j = 0; j <size ; j++) {
                if ()
            }
        }
        return true;
    }
*/
}

