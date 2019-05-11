package sample.Controllers;
import sample.Controllers.connectController;

import javax.sql.rowset.*;
import java.lang.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect extends connectController {
    public static Connection conn = null;
    protected static String dbName;
    protected static String databaseUserName;
    protected static String serverip;
    protected static String serverport;
    protected static String databasePassword;
    static protected String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
    final static protected String url2="";


    public static void newconn() throws SQLException{
        dbName="sda";
      //  connection(url,databaseUserName,databasePassword);
    }


    public static Connection connection() throws SQLException{
        url="jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
        try {

            conn = DriverManager.getConnection(url, databaseUserName, databasePassword);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            throw e;
        }
        return conn;
    }

    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;
        //
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        //CachedRowSetImpl crs = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            // connectionme();
            connection();


            System.out.println("Select statement: " + queryStmt + "\n");

            //Create statement
            stmt = conn.createStatement();

            //Execute select (query) operation
            resultSet = stmt.executeQuery(queryStmt);

            //CachedRowSet Implementation
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            //We are using CachedRowSet
            // crs = new CachedRowSetImpl();
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            //  dbDisconnect();
        }
        //Return CachedRowSet
        return crs;
    }

}

