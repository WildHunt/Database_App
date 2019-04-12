package sample;
import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import sample.util.DBUtil;
import javafx.fxml.FXML;
import sample.connectController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorsDAO {
    PreparedStatement preparedStatement=null;

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private  Doctors getDoctorsFromResultSet(ResultSet rs) throws SQLException
    {
        DBConnect.connection();
        Doctors dct = null;
        if (rs.next()) {
            dct = new Doctors();
            dct.setId_doctor(rs.getInt("id_doctor"));
            dct.setName(rs.getString("name"));
            dct.setSurname(rs.getString("surname"));
            dct.setEmail(rs.getString("email"));
            dct.setSpec(rs.getString("spec"));
            dct.setCity(rs.getString("city"));
            dct.setSocial(rs.getString("social"));
            dct.setCar(rs.getBoolean("car"));
            dct.setResident(rs.getBoolean("resident"));

        }
        return dct;
    }

    public  ObservableList<Doctors> searchEmployees () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Doctors";
        Connection conn = DBConnect.connection();
        preparedStatement = conn.prepareStatement(selectStmt);


        //Execute SELECT statement
        try {
            //EmployeeDAO.co

            // connectController me = new connectController();
            //Get ResultSet from dbExecuteQuery method
            //ResultSet rsEmps = connectController.dbExecuteQuery(selectStmt);
            ResultSet rsEmps;
            rsEmps = preparedStatement.executeQuery();
            //ResultSet rsEmp = connectController.dbExecuteQuery(selectStmt);
            //rsEmps = me.dbExecuteQuery(selectStmt);
            //System.out.println(preparedStatement.toString());

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Doctors> empList = getDoctorsList(rsEmps);
            System.out.println(empList.toString());

            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    private  static ObservableList<Doctors> getDoctorsList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Doctors objects
        ObservableList<Doctors> dctList = FXCollections.observableArrayList();

        while (rs.next()) {
            Doctors dct = new Doctors();
            dct = new Doctors();
            dct.setId_doctor(rs.getInt("id_doctor"));
            dct.setName(rs.getString("name"));
            dct.setSurname(rs.getString("surname"));
            dct.setEmail(rs.getString("email"));
            dct.setSpec(rs.getString("spec"));
            dct.setCity(rs.getString("city"));
            dct.setSocial(rs.getString("social"));
            dct.setCar(rs.getBoolean("car"));
            dct.setResident(rs.getBoolean("resident"));
            dctList.add(dct);
        }
        return dctList;
    }


    //INSERT an employee
    //*************************************
    public static void insertDoctors (String name, String lastname, String email, String spec, String city,
                                      String social, Boolean car, Boolean resident) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String insertStmt =
                "BEGIN\n" +
                        "INSERT INTO Doctors\n" +
                        "(name, surname, email, spec, city, social,car,resident)\n" +
                        "VALUES\n" +
                        "('"+name+"', '"+lastname+"','"+email+"', '"+spec+"','"+city+"', " +
                        "'"+social+"', '"+car+"', '"+resident+"');\n" +
                        "END;";

        try {
            DBConnect.dbExecuteQuery(insertStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while Insert Operation: " + e);
            throw e;
        }
    }
}
