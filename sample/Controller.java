package sample;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Controller {




    @FXML
    private MenuItem new_conn;

    @FXML
    private Menu menu_item;

    @FXML
    private Label label1;

    @FXML
    private Label drag;

    @FXML
    private Button bu1;



    @FXML
    void initialize(ActionEvent event) {
    }



    @FXML
    void initialize() {

         new_conn.setOnAction(event -> {
            String message = "das";
            int people_result=0;
            System.out.println(message);

             try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("connection_form.fxml"));
                 Parent root1 = (Parent) fxmlLoader.load();
                 Stage stage = new Stage();
                 stage.setScene(new Scene(root1));
                 stage.setTitle("Roma Makeev");
                 stage.show();
             }
             catch(Exception e) {
                 e.printStackTrace();
             }









        });


    }



}

