package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controllers.DBConnect;

import java.sql.Date;
import java.util.*;
//import sample.util.DBUtil;

import java.sql.*;

public class AdminsDAO {
    PreparedStatement preparedStatement=null;

    private  Admins getDoctorsFromResultSet(ResultSet rs) throws SQLException
    {
        DBConnect.connection();
        Admins adm = null;
        if (rs.next()) {
            adm = new Admins();
            adm.setIdAdmins(rs.getInt("idAdmin"));
            adm.setUserAdmins(rs.getString("userAdmins"));
            adm.setRoolsAdmins(rs.getString("roolsAdmins"));
            adm.setActivityAdmins(rs.getString("activityAdmins"));
        }
        return adm;
    }

    public  ObservableList<Admins> allAdmins () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Admins";
        Connection conn = DBConnect.connection();
        preparedStatement = conn.prepareStatement(selectStmt);


        //Execute SELECT statement
        try {
            ResultSet rsEmps;
            rsEmps = preparedStatement.executeQuery();
            //ResultSet rsEmp = connectController.dbExecuteQuery(selectStmt);
            //rsEmps = me.dbExecuteQuery(selectStmt);
            //System.out.println(preparedStatement.toString());

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Admins> empList = getAdminsList(rsEmps);
            System.out.println(empList.toString());

            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private  static ObservableList<Admins> getAdminsList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Doctors objects
        ObservableList<Admins> admList = FXCollections.observableArrayList();

        while (rs.next()) {
            Admins adm = new Admins();
            //adm = new Admins();
            adm.setIdAdmins(rs.getInt("idAdmin"));
            adm.setUserAdmins(rs.getString("userAdmins"));
            adm.setRoolsAdmins(rs.getString("roolsAdmins"));
            adm.setActivityAdmins(rs.getString("activityAdmins"));
            admList.add(adm);
        }
        return admList;
    }

    public static void insertAdmins (String username, String rools) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("utilDate:" + utilDate);
        System.out.println("sqlDate:" + sqlDate); //sqlDate:2019-05-25

        String insertStmt =
                "BEGIN\n" +
                        "INSERT INTO Admins\n" +
                        "(username, rools, activity)\n" +
                        "VALUES\n" +
                        "('"+username+"', '"+rools+"','"+sqlDate+"');\n" +
                        "END;";

        try {
            DBConnect.dbExecuteQuery(insertStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while Insert Operation: " + e);
            throw e;
        }
    }

    public static void deleteAdmins (Integer idAdmin) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String insertStmt =
                "BEGIN\n" +
                        "DELETE FROM Admins\n" +
                        "WHERE idAdmins =" + idAdmin+ ";\n"+
                        "END;";

        try {
            DBConnect.dbExecuteQuery(insertStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while delete Operation: " + e);
            throw e;
        }
    }

    public static void editAdmins (Integer idAdmin, String permission) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String insertStmt =
                "BEGIN\n" +
                        "UPDATE Admins\n" +
                        "SET rools="+ permission +
                        "WHERE idAdmins =" + idAdmin+ ";\n"+
                        "END;";

        try {
            DBConnect.dbExecuteQuery(insertStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while delete Operation: " + e);
            throw e;
        }
    }

}
