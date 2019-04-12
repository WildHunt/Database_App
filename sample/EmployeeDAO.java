//package sample;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
////import sample.util.DBUtil;
//import javafx.fxml.FXML;
//import sample.connectController;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class EmployeeDAO {
//
//    //*******************************
//    //SELECT an Employee
//    //*******************************
//     public connectController connect;
//     //Connection conn=connectController.connectionme();
//     PreparedStatement preparedStatement=null;
//
//
//    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
//    private  Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException
//    {
//        DBConnect.connection();
//       // connect.connectionme();
//        Employee emp = null;
//        if (rs.next()) {
//            emp = new Employee();
//            emp.setEmployeeId(rs.getInt("id_doctor"));
//            emp.setFirstName(rs.getString("Name"));
//            emp.setLastName(rs.getString("Doctor"));
//            emp.setEmail(rs.getString("spec"));
//        }
//        return emp;
//    }
//
//
//
//    public  ObservableList<Employee> searchEmployees () throws SQLException, ClassNotFoundException {
//        //Declare a SELECT statement
//        String selectStmt = "SELECT * FROM Doctors";
//        //connect.connectionme();
//        Connection conn = DBConnect.connection();
//        preparedStatement = conn.prepareStatement(selectStmt);
//
//
//        //Execute SELECT statement
//        try {
//            //EmployeeDAO.co
//
//           // connectController me = new connectController();
//            //Get ResultSet from dbExecuteQuery method
//            //ResultSet rsEmps = connectController.dbExecuteQuery(selectStmt);
//            ResultSet rsEmps;
//            rsEmps = preparedStatement.executeQuery();
//            //ResultSet rsEmp = connectController.dbExecuteQuery(selectStmt);
//            //rsEmps = me.dbExecuteQuery(selectStmt);
//            System.out.println(preparedStatement.toString());
//
//            //Send ResultSet to the getEmployeeList method and get employee object
//            ObservableList<Employee> empList = getEmployeeList(rsEmps);
//            System.out.println(empList.toString());
//
//            //Return employee object
//            return empList;
//        } catch (SQLException e) {
//            System.out.println("SQL select operation has been failed: " + e);
//            //Return exception
//            throw e;
//        }
//    }
//
//
//
//    //*******************************
//    //SELECT Employees
//    //*******************************
//    public  Employee searchEmployee (String empId) throws SQLException, ClassNotFoundException {
//        //Declare a SELECT statement
//        String selectStmt = "SELECT * FROM Doctors";
//       // Connection connect = DBConnect.connection();
//        DBConnect.connection();
//        //Execute SELECT statement
//        try {
//            DBConnect me = new DBConnect();
//            //Get ResultSet from dbExecuteQuery method
//            ResultSet rsEmp;
//            //ResultSet rsEmp = connectController.dbExecuteQuery(selectStmt);
//            rsEmp = me.dbExecuteQuery(selectStmt);
//
//            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
//            Employee employee = getEmployeeFromResultSet(rsEmp);
//
//            //Return employee object
//            return employee;
//        } catch (SQLException e) {
//            System.out.println("While searching an employee with " + empId + " id, an error occurred: " + e);
//            //Return exception
//            throw e;
//        }
//    }
//
//    //Select * from employees operation
//    private  static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
//        //Declare a observable List which comprises of Employee objects
//        ObservableList<Employee> empList = FXCollections.observableArrayList();
//
//        while (rs.next()) {
//            Employee emp = new Employee();
//            emp.setEmployeeId(rs.getInt("id_doctor"));
//            emp.setFirstName(rs.getString("name"));
//            emp.setLastName(rs.getString("surname"));
//            emp.setEmail(rs.getString("email"));
////            emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
////            emp.setHireDate(rs.getDate("HIRE_DATE"));
////            emp.setJobId(rs.getString("JOB_ID"));
////            emp.setSalary(rs.getInt("SALARY"));
////            emp.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
////            emp.setManagerId(rs.getInt("MANAGER_ID"));
////            emp.setDepartmantId(rs.getInt("DEPARTMENT_ID"));
//            //Add employee to the ObservableList
//            empList.add(emp);
//        }
//        //return empList (ObservableList of Employees)
//        return empList;
//    }
//
//    //*************************************
//    //UPDATE an employee's email address
//    //*************************************
////    public static void updateEmpEmail (String empId, String empEmail) throws SQLException, ClassNotFoundException {
////        //Declare a UPDATE statement
////        String updateStmt =
////                "BEGIN\n" +
////                        "   UPDATE employees\n" +
////                        "      SET EMAIL = '" + empEmail + "'\n" +
////                        "    WHERE EMPLOYEE_ID = " + empId + ";\n" +
////                        "   COMMIT;\n" +
////                        "END;";
////
////        //Execute UPDATE operation
////        try {
////            DBUtil.dbExecuteUpdate(updateStmt);
////        } catch (SQLException e) {
////            System.out.print("Error occurred while UPDATE Operation: " + e);
////            throw e;
////        }
////    }
//
//    //*************************************
//    //DELETE an employee
//    //*************************************
////    public static void deleteEmpWithId (String empId) throws SQLException, ClassNotFoundException {
////        //Declare a DELETE statement
////        String updateStmt =
////                "BEGIN\n" +
////                        "   DELETE FROM employees\n" +
////                        "         WHERE employee_id ="+ empId +";\n" +
////                        "   COMMIT;\n" +
////                        "END;";
////
////        //Execute UPDATE operation
////        try {
////            c.dbExecuteUpdate(updateStmt);
////        } catch (SQLException e) {
////            System.out.print("Error occurred while DELETE Operation: " + e);
////            throw e;
////        }
////    }
//
//    //*************************************
//    //INSERT an employee
//    //*************************************
////    public static void insertEmp (String name, String lastname, String email) throws SQLException, ClassNotFoundException {
////        //Declare a DELETE statement
////        String updateStmt =
////                "BEGIN\n" +
////                        "INSERT INTO employees\n" +
////                        "(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID)\n" +
////                        "VALUES\n" +
////                        "(sequence_employee.nextval, '"+name+"', '"+lastname+"','"+email+"', SYSDATE, 'IT_PROG');\n" +
////                        "END;";
////
////        //Execute DELETE operation
////        try {
////           // connectController.dbExecuteUpdate(updateStmt);
////           int i=0;
////        } catch (SQLException e) {
////            System.out.print("Error occurred while DELETE Operation: " + e);
////            throw e;
////        }
////    }
//}
