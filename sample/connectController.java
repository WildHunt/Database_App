package sample;

//import com.sun.rowset.CachedRowSetImpl;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javax.sql.rowset.*;
import javax.xml.crypto.Data;
import java.awt.dnd.DropTarget;
import java.sql.*;
import java.lang.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.*;
///

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

        public class connectController {


            @FXML
            private TextField data_adress;


            @FXML
            private TextField data_name;

            @FXML
            private TextField data_port;

            @FXML
            private TextField data_user_name;

            @FXML
            public ProgressBar progressBar;

            @FXML
            private Label isConLabel;

            @FXML
            private Button but_connect;

            @FXML
            private Label output;

            @FXML
            private PasswordField data_user_pass;

            public static Connection conn = null;


            public void initialize() {

//                but_connect.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent mouseEvent) {
//                        //connectionme();
//                        handle(mouseEvent);
//
//                    }
//                });
            }

            public connectController() {
                // conn = connectController.connectionme();
            }

            @FXML
            void goConnect(ActionEvent event) throws SQLException {
               isConLabel.setText("");

                /**
                 *
                 */
                progressBar.setVisible(true);
                DBConnect.dbName= data_name.getText();
                DBConnect.serverip = data_adress.getText();
                DBConnect.serverport = data_port.getText();
                DBConnect.databasePassword= data_user_pass.getText();
                DBConnect.databaseUserName= data_user_name.getText();

                if (DBConnect.connection().isValid(5)){
                    progressBar.setVisible(false);
                    isConLabel.setText("Succsesfull");
                }
//                if (!DBConnect.connection().isValid(0))   {
//                    isConLabel.setText("Failed");
//                    progressBar.setVisible(false);
//                }

                    DBConnect.connection();


            }
        }






