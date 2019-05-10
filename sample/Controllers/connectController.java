package sample.Controllers;

//import com.sun.rowset.CachedRowSetImpl;
import java.io.IOException;
import java.net.InetAddress;
import javafx.scene.control.ProgressBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
///

import java.sql.Connection;
import java.sql.SQLException;

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

//            @FXML
//            void goConnect(ActionEvent event) throws SQLException {
//               isConLabel.setText("");
//
//                /**
//                 *
//                 */
//                progressBar.setVisible(true);
//                DBConnect.dbName= data_name.getText();
//                DBConnect.serverip = data_adress.getText();
//                DBConnect.serverport = data_port.getText();
//                DBConnect.databasePassword= data_user_pass.getText();
//                DBConnect.databaseUserName= data_user_name.getText();
//
//                if (DBConnect.connection().isValid(5)){
//                    progressBar.setVisible(false);
//                    isConLabel.setText("Succsesfull");
//                }
//                else {
//                    progressBar.setVisible(true);
//                    isConLabel.setText("Failed");
//                }
////                if (!DBConnect.connection().isValid(0))   {
////                    isConLabel.setText("Failed");
////                    progressBar.setVisible(false);
////                }
//
//                    DBConnect.connection();
//
//
//            }
    boolean check()  throws  IOException {
        String ipAddress = data_adress.getText();
        InetAddress inet = InetAddress.getByName(ipAddress);

        System.out.println("Sending Ping Request to " + ipAddress);
        isConLabel.setText(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
        System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
        return inet.isReachable(5000) != false;

//        ipAddress = "173.194.32.38";
//        inet = InetAddress.getByName(ipAddress);
//
//        System.out.println("Sending Ping Request to " + ipAddress);
//        System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");

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




        try {
            if (check()==true) {

                if (DBConnect.connection().isValid(1) == true) {
                    progressBar.setVisible(true);
                    DBConnect.connection();
                } else {
                    progressBar.setVisible(false);
                    isConLabel.setText("Failed");
                }
            }
        }
        catch (SQLException E ){
            isConLabel.setText(E.toString());
            progressBar.setVisible(false);
            throw E;

        }
        catch (IOException I){
            I.printStackTrace();
        }


    }

        }






