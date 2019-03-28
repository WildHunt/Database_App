package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
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
        private Button but_connect;

        @FXML
        private PasswordField data_user_pass;

        @FXML
        void goConnect(ActionEvent event) {

        }
            public void initialize(){
                but_connect.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        connection();

                    }
                });
            }


            private void connection(){
                Connection conn = null;
                String dbName =data_name.getText();
                String serverip=data_adress.getText();
                String serverport=data_port.getText();
                String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
                Statement stmt = null;
                ResultSet result = null;
                String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                String databaseUserName =data_user_name.getText();
                String databasePassword = data_user_pass.getText();
                try {
                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url, databaseUserName, databasePassword);
                    stmt = conn.createStatement();
                    result = null;
                    String pa,us;
                    result = stmt.executeQuery("select * from age ");

//            while (result.next()) {
//                us=result.getString("nazwisko");
//                pa = result.getString("wzrost");
//                System.out.println(us+"  "+pa);
//            }


                    while (result.next()) {
                        System.out.println(result.getString("nazwisko") + " " + result.getString("wzrost"));
                    }

                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }


