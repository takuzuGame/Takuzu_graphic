package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.puzzle.init6;
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


public class mediumController implements Initializable {
    //Declaration
    private setPuzzle [] tabPuzz = new setPuzzle[2];
    @FXML
    private  JFXButton mediumButton0,mediumButton1,mediumButton2,mediumButton3,mediumButton4,mediumButton5,mediumButton6,
            mediumButton7,mediumButton8,mediumButton9,mediumButton10,mediumButton11,mediumButton12,mediumButton13,mediumButton14,
            mediumButton15,mediumButton16,mediumButton17,mediumButton18,mediumButton19,mediumButton20,mediumButton21,mediumButton22,
            mediumButton23,mediumButton24,mediumButton25,mediumButton26,mediumButton27,mediumButton28,mediumButton29,mediumButton30,mediumButton31,
            mediumButton32,mediumButton33,mediumButton34,mediumButton35,mediumSubmit;

    int counter;



    public setPuzzle[] getTabPuzz() {
        return tabPuzz;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXButton [] mediumbutton ={mediumButton0,mediumButton1,mediumButton2,mediumButton3,mediumButton4,mediumButton5,mediumButton6,
                mediumButton7,mediumButton8,mediumButton9,mediumButton10,mediumButton11,mediumButton12,mediumButton13,mediumButton14,
                mediumButton15,mediumButton16,mediumButton17,mediumButton18,mediumButton19,mediumButton20,mediumButton21,mediumButton22,
                mediumButton23,mediumButton24,mediumButton25,mediumButton26,mediumButton27,mediumButton28,mediumButton29,mediumButton30,mediumButton31,
                mediumButton32,mediumButton33,mediumButton34,mediumButton35};

        setTabPuzz(defaultPuzzle());
        setPuzzle defaut = getTabPuzz()[0];
        counter = -1;
        for (int i = 0; i <6; i++) {

            for (int j = 0; j <6 ; j++) {
                final JFXButton button = mediumbutton[6*i+j];
                if (defaut.tab[i][j] == 1){
                    button.setText("1");
                    button.setFont(Font.font(28));
                    button.setTextFill(Paint.valueOf("white"));
                    counter++;
                    button.setDisable(true);
                    button.setTextFill(Paint.valueOf("black"));
                    button.setOpacity(0.9);
                }else if (defaut.tab[i][j]== 0){
                    button.setText("0");
                    button.setFont(Font.font(28));
                    button.setTextFill(Paint.valueOf("white"));
                    button.setOpacity(0.9);
                    counter++;
                    button.setDisable(true);
                    button.setTextFill(Paint.valueOf("black"));

                }else{
                    button.setText("");
                }




                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        setOneZero(button);

                    }


                });
            }
        }
    }


    public void setTabPuzz(setPuzzle[] tabPuzz) {
        this.tabPuzz = tabPuzz;
    }
    //set zero and ones and empty cell in puzzle
    public void setOneZero(JFXButton button){
        if(button.getText().equals("")){
            button.setText("1");
            button.setFont(Font.font(28));
            button.setTextFill(Paint.valueOf("white"));
            button.setOpacity(0.9);
            counter++;
        }else if (button.getText().equals("1")){
            button.setText("0");
            button.setFont(Font.font(28));
            button.setTextFill(Paint.valueOf("white"));
            button.setOpacity(0.9);
        }else {
            button.setText("");
            button.setOpacity(1);
            counter--;
        }
        if (counter>=35){
            mediumSubmit.setDisable(false);
        }else{
            mediumSubmit.setDisable(true);

        }
    }
    private setPuzzle[] defaultPuzzle (){
        setPuzzle p= new setPuzzle();
        setPuzzle f= new setPuzzle();
        setPuzzle[] tabPuzz = new setPuzzle[2];
        init6 m6 = new init6();
        p =p.Initialize(6);
        p= p.intialPuzzle6(m6,p);
        f= f.emptycel(p);
        tabPuzz[0]=f;
        tabPuzz[1]=p;
        return (tabPuzz);
    }

    @FXML
    public void Submit6x6(){
        JFXButton [] mediumbutton ={mediumButton0,mediumButton1,mediumButton2,mediumButton3,mediumButton4,mediumButton5,mediumButton6,
                mediumButton7,mediumButton8,mediumButton9,mediumButton10,mediumButton11,mediumButton12,mediumButton13,mediumButton14,
                mediumButton15,mediumButton16,mediumButton17,mediumButton18,mediumButton19,mediumButton20,mediumButton21,mediumButton22,
                mediumButton23,mediumButton24,mediumButton25,mediumButton26,mediumButton27,mediumButton28,mediumButton29,mediumButton30,mediumButton31,
                mediumButton32,mediumButton33,mediumButton34,mediumButton35};

        boolean isValid = true;

        String s;
        setPuzzle solution = getTabPuzz()[1];
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                s = Integer.toString(solution.tab[i][j]);
                if (!mediumbutton[6 * i + j].getText().equals(s)){
                    isValid = false;
                }
            }

        }
        if (isValid){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("youWin.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("You Win!");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e){
                System.out.println("Sorry can't load the window");
            }
        }else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("youLoose.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Sorry, You loose");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e){
                System.out.println("Sorry can't load the window");
            }
        }

    }
    @FXML
    public void Reset6x6(){

        JFXButton [] mediumbutton ={mediumButton0,mediumButton1,mediumButton2,mediumButton3,mediumButton4,mediumButton5,mediumButton6,
                mediumButton7,mediumButton8,mediumButton9,mediumButton10,mediumButton11,mediumButton12,mediumButton13,mediumButton14,
                mediumButton15,mediumButton16,mediumButton17,mediumButton18,mediumButton19,mediumButton20,mediumButton21,mediumButton22,
                mediumButton23,mediumButton24,mediumButton25,mediumButton26,mediumButton27,mediumButton28,mediumButton29,mediumButton30,mediumButton31,
                mediumButton32,mediumButton33,mediumButton34,mediumButton35};

        for (int i = 0; i <35 ; i++) {
            mediumbutton[i].setText("");
            mediumbutton[i].setDisable(false);
            mediumbutton[i].setOpacity(1);

        }
        setTabPuzz(defaultPuzzle());
        setPuzzle defaut = getTabPuzz()[0];
        counter = -1;
        for (int i = 0; i <6; i++) {

            for (int j = 0; j <6; j++) {
                final JFXButton button = mediumbutton[6*i +j];
                if (defaut.tab[i][j] == 1){
                    button.setText("1");
                    button.setFont(Font.font(28));
                    button.setTextFill(Paint.valueOf("black"));
                    button.setOpacity(0.9);
                    counter++;
                    button.setDisable(true);
                }else if (defaut.tab[i][j]==0){
                    button.setText("0");
                    button.setFont(Font.font(28));
                    button.setTextFill(Paint.valueOf("black"));
                    button.setOpacity(0.9);
                    counter++;
                    button.setDisable(true);
                }else{
                    button.setText("");

                }
            }
        }

    }

}
