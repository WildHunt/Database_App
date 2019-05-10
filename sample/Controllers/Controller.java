package sample.Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import sample.Doctors;
import sample.DoctorsDAO;

import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;


public class Controller {

    @FXML
    private MenuItem logoutbut;

    @FXML
    private AnchorPane lab;

    @FXML
    private Label nameError;

    @FXML
    private Label emailError;

    @FXML
    private Label surnameError;

    @FXML
    private Label specError;

    @FXML
    private Label phoneError;

    @FXML
    private Label socialError;

    @FXML
    private Label cityError;

    @FXML
    private CheckBox carRadio;

    @FXML
    private CheckBox residentRadio;

    @FXML
    private Button addEmpBtn;

    @FXML
    private TextField aName;

    @FXML
    private TextField cityBox;

    @FXML
    private TextField socialBox;

    @FXML
    private TextField aSurname;

    @FXML
    private TextField aSpec;

    @FXML
    private TextField aEmail;
    @FXML
    private Menu menu_item;

    @FXML
    private MenuItem new_conn;

    @FXML
    private MenuItem logout;

    @FXML
    private AnchorPane anchor_adding;

    @FXML
    private Button finishBut;

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
    public TableView doctorsTable;

    @FXML
    private TableColumn<Doctors, Integer> dctIdColumn;

    @FXML
    private TableColumn<Doctors, String> dctNameColumn;

    @FXML
    private TableColumn<Doctors, String> dctSurnameColumn;

    @FXML
    private TableColumn<Doctors, String> dctEmailColumn;

    @FXML
    private TableColumn<Doctors, String> dctSpecColumn;

    @FXML
    private TableColumn<Doctors, String> dctCityColumn;

    @FXML
    private TableColumn<Doctors, String> dctSocialColumn;

    @FXML
    private TableColumn<Doctors, Boolean> dctCarColumn;

    @FXML
    private TableColumn<Doctors, Boolean> dctResidentColumn;

    @FXML
    private ComboBox<String> specBox;

    @FXML
    private TextField nameBox;

    @FXML
    private TextField emailBox;

    @FXML
    private TextField surnameBox;

    @FXML
    private Button searchEmpsBtn;
    private Executor exec;

    @FXML
    private Button checkBut;

    @FXML
    private TextField phoneBox;

    @FXML
    private Label checkLab;

    @FXML
    void deleteEmployee(ActionEvent event) {

    }


    @FXML
    void initialize(ActionEvent event) {
        anchor_adding.setVisible(false);
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

        specBox.getItems().addAll("Dentist", "Surgeon", "Nurse","Mediс");
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

        dctIdColumn.setCellValueFactory(cellData -> cellData.getValue().id_doctorProperty().asObject());
        dctNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        dctSurnameColumn.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        dctEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        dctSpecColumn.setCellValueFactory(cellData -> cellData.getValue().specProperty());
        dctCityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        dctCarColumn.setCellValueFactory(cellData -> cellData.getValue().carProperty());
        dctResidentColumn.setCellValueFactory(cellData -> cellData.getValue().residentProperty());

//        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
//        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
//        empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
//        empEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
//        empPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
       // empHireDateColumn.setCellValueFactory(cellData -> cellData.getValue().hireDateProperty());
    }

    @FXML
    void connect(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/connection_form.fxml"));
//
           // FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/connection_form.fxml"));
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



    @FXML
    private void searchEmployees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {

            //Get all Employees information
            //ObservableList<Employee> empData = EmployeeDAO.searchEmployees();
            ObservableList<Doctors> dctData = new DoctorsDAO().searchEmployees();
           // ObservableList<Employee> empData = new EmployeeDAO().searchEmployees();
            //Populate Employees on TableView
            populateEmployees(dctData);
            doctorsTable.setItems(dctData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    void switchAnchor(ActionEvent event) {
        anchor_main.setVisible(false);
        anchor_adding.setVisible(true);

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
        doctorsTable.setItems(empData);

    }

    @FXML
    void updateEmployeeEmail(ActionEvent event) {

    }
    @FXML
    void switchBack(ActionEvent event) {
    anchor_adding.setVisible(false);
    anchor_main.setVisible(true);
    }

    @FXML
    void addDoctor(ActionEvent event) throws ClassNotFoundException, SQLException{
        try {
            System.out.println(nameBox.getText());
            System.out.println(specBox.getValue());
            System.out.println(cityBox.getText());
            System.out.println(socialBox.getText());
            DoctorsDAO.insertDoctors(nameBox.getText(),surnameBox.getText(),emailBox.getText(),
                    specBox.getValue(),
                    cityBox.getText(),
                    socialBox.getText(),
                    carRadio.isSelected(),
                    residentRadio.isSelected());

        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    void checkBut(ActionEvent event) {
        specError.setText("");
        surnameError.setText("");
        nameError.setText("");
        checkLab.setText("");
        String phone;
        phone = phoneBox.getText();

       // if(phone == null || phone.length() < 5 || phone.matches("-?\\d+(\\.\\d+)?"))
        if (phone.matches("-?\\d+(\\.\\d+)?"))
            checkLab.setText("Valid");

        else
            checkLab.setText("Not valid");

        if (nameBox.getText().matches("^\\D*$")== false){
            nameError.setText("Error");
        }
        if (surnameBox.getText().matches("^\\D*$")== false){
            surnameError.setText("Error");
        }
        if (specBox.getValue()==null){
            specError.setText("Error");
        }

    }

    @FXML
    void logout(ActionEvent event) {

        try {

            Stage stage1 = (Stage) checkBut.getScene().getWindow();
            // do what you have to do
            stage1.close();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/regform.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/regform.fxml"));

            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
           // stage.initStyle(StageStyle.TRANSPARENT);
            //primaryStage.setAlwaysOnTop(true);
            root.setStyle("-fx-background-color: transparent;");
          //  stage.setTitle("Roma Makeev");
            stage.setScene(new Scene(root, 1200, 750, Color.TRANSPARENT));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        }
        catch(Exception e) {
            e.printStackTrace();
        }




    }



}

