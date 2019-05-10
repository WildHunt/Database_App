package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXPasswordField;
import javafx.stage.Stage;


public class loginController {

    @FXML
    private Button but1;

    @FXML
    private ImageView image;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXButton exitbut;

    @FXML
    private JFXButton gobut;

    @FXML
    private JFXPasswordField password;

    private String user;
    private String pass;


    public void initialize() {
       // username.setStyle("-fx-text-inner-color: red");
    }

    @FXML
    void logIn(ActionEvent event) {
        user = username.getText();
        pass = password.getText();

        if (pass.matches("roma")==true){
            try {
                Stage stage1 = (Stage) gobut.getScene().getWindow();
                // do what you have to do
                stage1.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/main_page.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Roma Makeev");
                stage.show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

    }




    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

}