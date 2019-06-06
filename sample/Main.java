package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;

//git


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/regform.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        //primaryStage.setAlwaysOnTop(true);
        root.setStyle("-fx-background-color: transparent;");
       // primaryStage.setFill(Color.TRANSPARENT);
       // primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setTitle("Roma Makeev");
        primaryStage.setScene(new Scene(root, 1200, 750, Color.TRANSPARENT));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();


        ////


    }

    public void pressButton(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("connetction_form.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);

    }

}
