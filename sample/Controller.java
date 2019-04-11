package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.concurrent.Task;
import javafx.scene.control.Menu;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Controller {
    //public EmployeeDAO emp1;




    @FXML
    private Menu menu_item;

    @FXML
    private MenuItem new_conn;

    @FXML
    public AnchorPane anchor_main;

    @FXML
    private TextField empIdText;

    @FXML
    private Button searchEmpBtn;

    @FXML
    private Button deleteEmpBtn;

    @FXML
    private Button updateEmpBtn;

    @FXML
    private Button addEmpBtn;

    @FXML
    private TextArea resultArea;

    @FXML
    private TextField newEmailText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField surnameText;

    @FXML
    private TextField emailText;

    @FXML
    public TableView employeeTable;

    @FXML
    private TableColumn<Employee, Integer> empIdColumn;

    @FXML
    private TableColumn<Employee, String> empNameColumn;

    @FXML
    private TableColumn<Employee, String> empLastNameColumn;

    @FXML
    private TableColumn<Employee, String> empEmailColumn;

    @FXML
    private TableColumn<Employee, String> empPhoneNumberColumn;

    @FXML
    private TableColumn<Employee, String> empHireDateColumn;

    @FXML
    private Button searchEmpsBtn;
    private Executor exec;

    @FXML
    void deleteEmployee(ActionEvent event) {

    }


    @FXML
    void initialize(ActionEvent event) {
    }



//    @FXML
//    void initialize() {
//
//         new_conn.setOnAction(event -> {
//            String message = "das";
//            anchor_main.setVisible(true);
//            //int people_result=0;
//            System.out.println(message);
//
//             try {
//                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("connection_form.fxml"));
//                 Parent root1 = (Parent) fxmlLoader.load();
//                 Stage stage = new Stage();
//                 stage.setScene(new Scene(root1));
//                 stage.setTitle("Roma Makeev");
//                 stage.show();
//             }
//             catch(Exception e) {
//                 e.printStackTrace();
//             }
//
//             empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
//             empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
//             empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
//
//
//        });
//
//
//
//    }

    @FXML
    private void initialize () {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */

        //For multithreading: Create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread (runnable);
            t.setDaemon(true);
            return t;
        });

        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        empEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        empPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
       // empHireDateColumn.setCellValueFactory(cellData -> cellData.getValue().hireDateProperty());
    }

    @FXML
    void connect(ActionEvent event) {
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
    }



    @FXML
    private void searchEmployees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {

            //Get all Employees information
            //ObservableList<Employee> empData = EmployeeDAO.searchEmployees();
            ObservableList<Employee> empData = new EmployeeDAO().searchEmployees();
            //Populate Employees on TableView
            populateEmployees(empData);
            employeeTable.setItems(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }


    @FXML
    void insertEmployee(ActionEvent event) {

    }

    @FXML
    void searchEmployee(ActionEvent event) {

    }

    @FXML
    public void populateEmployees (ObservableList<?> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        System.out.println(empData.toString());
        employeeTable.setItems(empData);

    }

    @FXML
    void updateEmployeeEmail(ActionEvent event) {

    }


}

