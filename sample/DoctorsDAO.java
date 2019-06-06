package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controllers.DBConnect;

import java.sql.*;

public class DoctorsDAO {
    PreparedStatement preparedStatement=null;

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

        try {
            ResultSet rsEmps;
            rsEmps = preparedStatement.executeQuery();
            ObservableList<Doctors> empList = getDoctorsList(rsEmps);
            System.out.println(empList.toString());
            return empList;

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private  static ObservableList<Doctors> getDoctorsList(ResultSet rs) throws SQLException, ClassNotFoundException {
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


    public static void insertDoctors (String name, String lastname, String email, String spec, String city,
                                      String social, Boolean car, Boolean resident) throws SQLException, ClassNotFoundException {
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

    public  ObservableList<Doctors> showWithCar () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM Doctors where car = 1 ";
        Connection conn = DBConnect.connection();
        preparedStatement = conn.prepareStatement(selectStmt);

        try {
            ResultSet rsEmps;
            rsEmps = preparedStatement.executeQuery();
            ObservableList<Doctors> empList = getDoctorsList(rsEmps);
            System.out.println(empList.toString());

            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    public static void deleteDoctors (Integer idDoctor) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String insertStmt =
                "BEGIN\n" +
                        "DELETE FROM Doctors\n" +
                        "WHERE idAdmins =" + idDoctor+ ";\n"+
                        "END;";

        try {
            DBConnect.dbExecuteQuery(insertStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while delete Operation: " + e);
            throw e;
        }
    }

    public ObservableList showSalaryDoc(String param) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement

        String selectStmt =
                "BEGIN\n" +
                        "exec myproc" + "'"+param+"'"+ "\n" +
                        "END;";
        Connection conn = DBConnect.connection();
        preparedStatement = conn.prepareStatement(selectStmt);

        try {
            ResultSet rsEmps;
            rsEmps = preparedStatement.executeQuery();
            ObservableList<Doctors> empList = getDoctorsList(rsEmps);
            System.out.println(empList.toString());
            return empList;

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

}
