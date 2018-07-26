package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.puzzle.init4;
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

public class easyController implements Initializable{
         private setPuzzle [] tabPuzz=new setPuzzle[2];

        @FXML
         private JFXButton easyButton0,easyButton1,easyButton2,easyButton3,easyButton4,easyButton5,easyButton6,easyButton7,easyButton8,easyButton9,
                easyButton10,easyButton11,easyButton12,easyButton13,easyButton14,easyButton15,easySubmit,easyReset;

    int counter=-1;




    @Override
    //initialization of all the button of the 4x4 puzzle
    public void initialize(URL location, ResourceBundle resources) {
        JFXButton easybutton [] = {easyButton0,easyButton1,easyButton2,easyButton3,easyButton4,easyButton5,easyButton6,easyButton7,easyButton8,easyButton9,
                easyButton10,easyButton11,easyButton12,easyButton13,easyButton14,easyButton15};

        setTabPuzz(defaultPuzzle());
        setPuzzle defaut = getTabPuzz()[0];
        counter = -1;
        for (int i = 0; i <4; i++) {

            for (int j = 0; j <4 ; j++) {
                final JFXButton button = easybutton[4*i+j];
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
        if (counter>=15){
            easySubmit.setDisable(false);
        }else{
            easySubmit.setDisable(true);

    }
    }
    private setPuzzle[] defaultPuzzle (){
        setPuzzle p= new setPuzzle();
        setPuzzle f= new setPuzzle();
        setPuzzle[] tabPuzz=new setPuzzle[2];
        init4 m4 = new init4();
        p = p.Initialize(4);
        p= p.intialPuzzle(m4,p);
        f=f.Initialize(4);
        f= f.emptycel(p);
        tabPuzz[0]=f;
        tabPuzz[1]=p;
        return (tabPuzz);
        }

    public setPuzzle[] getTabPuzz() {
        return tabPuzz;
    }

    public void setTabPuzz(setPuzzle[] tabPuzz) {
        this.tabPuzz = tabPuzz;
    }

    @FXML
    private void Submit4x4(){
        JFXButton easybutton [] = {easyButton0,easyButton1,easyButton2,easyButton3,easyButton4,easyButton5,easyButton6,easyButton7,easyButton8,easyButton9,
                easyButton10,easyButton11,easyButton12,easyButton13,easyButton14,easyButton15};
        boolean isValid = true;

        String s;
        setPuzzle solution = getTabPuzz()[1];
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                s = Integer.toString(solution.tab[i][j]);
                if (!easybutton[4 * i + j].getText().equals(s)){
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
    private void Reset4x4(){
        JFXButton easybutton [] = {easyButton0,easyButton1,easyButton2,easyButton3,easyButton4,easyButton5,easyButton6,easyButton7,easyButton8,easyButton9,
                easyButton10,easyButton11,easyButton12,easyButton13,easyButton14,easyButton15};
        for (int i = 0; i <16 ; i++) {
            easybutton[i].setText("");
            easybutton[i].setDisable(false);
            easybutton[i].setOpacity(1);

        }
        setTabPuzz(defaultPuzzle());
        setPuzzle defaut = getTabPuzz()[0];
        counter = -1;
        for (int i = 0; i <4; i++) {

            for (int j = 0; j <4 ; j++) {
                final JFXButton button = easybutton[4*i+j];
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
