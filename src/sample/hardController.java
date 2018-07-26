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
   @FXML
    private JFXButton hardSubmit,hardButton0,hardButton1,hardButton2,hardButton3,hardButton4,hardButton5,hardButton6,hardButton7,hardButton8,hardButton9,
           hardButton10,hardButton11,hardButton12,hardButton13,hardButton14,hardButton15,hardButton16,hardButton17,hardButton18,hardButton19,hardButton20,hardButton21,hardButton22,
           hardButton23,hardButton24,hardButton25,hardButton26,hardButton27,hardButton28,hardButton29,hardButton30,hardButton31,hardButton32,hardButton33,hardButton34,hardButton35,hardButton36,hardButton37,hardButton38,hardButton39,hardButton40,
           hardButton41,hardButton42,hardButton43,hardButton44,hardButton45,hardButton46,hardButton47,hardButton48,hardButton49,hardButton50,hardButton51,hardButton52,hardButton53,hardButton54,hardButton55,hardButton56,hardButton57,hardButton58,hardButton59,
           hardButton60,hardButton61,hardButton62,hardButton63;


    int counter;

    private setPuzzle [] tabPuzz=new setPuzzle[2];
    @Override

    public void initialize(URL location, ResourceBundle resources) {
        JFXButton [] hardbutton = {hardButton0,hardButton1,hardButton2,hardButton3,hardButton4,hardButton5,hardButton6,hardButton7,hardButton8,hardButton9,
                hardButton10,hardButton11,hardButton12,hardButton13,hardButton14,hardButton15,hardButton16,hardButton17,hardButton18,hardButton19,hardButton20,hardButton21,hardButton22,
                hardButton23,hardButton24,hardButton25,hardButton26,hardButton27,hardButton28,hardButton29,hardButton30,hardButton31,hardButton32,hardButton33,hardButton34,hardButton35,hardButton36,hardButton37,hardButton38,hardButton39,hardButton40,
                hardButton41,hardButton42,hardButton43,hardButton44,hardButton45,hardButton46,hardButton47,hardButton48,hardButton49,hardButton50,hardButton51,hardButton52,hardButton53,hardButton54,hardButton55,hardButton56,hardButton57,hardButton58,hardButton59,
                hardButton60,hardButton61,hardButton62,hardButton63};

        setTabPuzz(defaultPuzzle());
        setPuzzle defaut = getTabPuzz()[0];
        counter = -1;
        for (int i = 0; i <8; i++) {

            for (int j = 0; j <8 ; j++) {
                final JFXButton button = hardbutton[8*i+j];
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
        if (counter>=63){
            hardSubmit.setDisable(false);
        }else{
            hardSubmit.setDisable(true);

        }
    }
    public void setTabPuzz(setPuzzle[] tabPuzz) {
        this.tabPuzz = tabPuzz;
    }


    private setPuzzle[] defaultPuzzle (){
        setPuzzle p= new setPuzzle();
        setPuzzle f= new setPuzzle();
        setPuzzle[] tabPuzz = new setPuzzle[2];
        init8 m8 = new init8();
        p =p.Initialize(8);
        p= p.intialPuzzle8(m8,p);
        f= f.emptycel(p);
        tabPuzz[0]=f;
        tabPuzz[1]=p;
        return (tabPuzz);
    }

    @FXML
    public void Submit8x8(){
        JFXButton [] hardbutton = {hardButton0,hardButton1,hardButton2,hardButton3,hardButton4,hardButton5,hardButton6,hardButton7,hardButton8,hardButton9,
                hardButton10,hardButton11,hardButton12,hardButton13,hardButton14,hardButton15,hardButton16,hardButton17,hardButton18,hardButton19,hardButton20,hardButton21,hardButton22,
                hardButton23,hardButton24,hardButton25,hardButton26,hardButton27,hardButton28,hardButton29,hardButton30,hardButton31,hardButton32,hardButton33,hardButton34,hardButton35,hardButton36,hardButton37,hardButton38,hardButton39,hardButton40,
                hardButton41,hardButton42,hardButton43,hardButton44,hardButton45,hardButton46,hardButton47,hardButton48,hardButton49,hardButton50,hardButton51,hardButton52,hardButton53,hardButton54,hardButton55,hardButton56,hardButton57,hardButton58,hardButton59,
                hardButton60,hardButton61,hardButton62,hardButton63};

        boolean isValid = true;

        String s;
        setPuzzle solution = getTabPuzz()[1];
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                s = Integer.toString(solution.tab[i][j]);
                if (!hardbutton[8 * i + j].getText().equals(s)){
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
    public void Reset8x8(){
        JFXButton [] hardbutton = {hardButton0,hardButton1,hardButton2,hardButton3,hardButton4,hardButton5,hardButton6,hardButton7,hardButton8,hardButton9,
                hardButton10,hardButton11,hardButton12,hardButton13,hardButton14,hardButton15,hardButton16,hardButton17,hardButton18,hardButton19,hardButton20,hardButton21,hardButton22,
                hardButton23,hardButton24,hardButton25,hardButton26,hardButton27,hardButton28,hardButton29,hardButton30,hardButton31,hardButton32,hardButton33,hardButton34,hardButton35,hardButton36,hardButton37,hardButton38,hardButton39,hardButton40,
                hardButton41,hardButton42,hardButton43,hardButton44,hardButton45,hardButton46,hardButton47,hardButton48,hardButton49,hardButton50,hardButton51,hardButton52,hardButton53,hardButton54,hardButton55,hardButton56,hardButton57,hardButton58,hardButton59,
                hardButton60,hardButton61,hardButton62,hardButton63};

        for (int i = 0; i <64 ; i++) {
            hardbutton[i].setText("");
            hardbutton[i].setDisable(false);
            hardbutton[i].setOpacity(1);

        }
        setTabPuzz(defaultPuzzle());
        setPuzzle defaut = getTabPuzz()[0];
        counter = -1;
        for (int i = 0; i <8; i++) {

            for (int j = 0; j <8; j++) {
                final JFXButton button = hardbutton[8*i+j];
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

    public setPuzzle[] getTabPuzz() {
        return tabPuzz;
    }
}
