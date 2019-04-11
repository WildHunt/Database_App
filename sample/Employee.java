package sample;

import javafx.beans.property.*;

import java.sql.Date;


public class Employee {
    //Declare Employees Table Columns
    private IntegerProperty id_doctor;
    private StringProperty Name;
    private StringProperty Doctor;
    private StringProperty email;
    private StringProperty phone_number;
    private SimpleObjectProperty<Date> hire_date;
    private StringProperty job_id;
    private IntegerProperty salary;
    private DoubleProperty commission_pct;
    private IntegerProperty manager_id;
    private IntegerProperty department_id;

    //Constructor
    public Employee() {
        this.id_doctor = new SimpleIntegerProperty();
        this.Name = new SimpleStringProperty();
        this.Doctor = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.phone_number = new SimpleStringProperty();
        this.hire_date = new SimpleObjectProperty<>();
        this.job_id = new SimpleStringProperty();
        this.salary = new SimpleIntegerProperty();
        this.commission_pct = new SimpleDoubleProperty();
        this.manager_id = new SimpleIntegerProperty();
        this.department_id = new SimpleIntegerProperty();
    }

    //employee_id
    public int getEmployeeId() {
        return id_doctor.get();
    }

    public void setEmployeeId(int employeeId){
        this.id_doctor.set(employeeId);
    }

    public IntegerProperty employeeIdProperty(){
        return id_doctor;
    }

    //first_name
    public String getFirstName () {
        return Name.get();
    }

    public void setFirstName(String firstName){
        this.Name.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return Name;
    }

    //last_name
    public String getLastName () {
        return Doctor.get();
    }

    public void setLastName(String lastName){
        this.Doctor.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return Doctor;
    }

    //email
    public String getEmail () {
        return email.get();
    }

    public void setEmail (String email){
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    //phone_number
    public String getPhoneNumber () {
        return phone_number.get();
    }

    public void setPhoneNumber (String phoneNumber){
        this.phone_number.set(phoneNumber);
    }

    public StringProperty phoneNumberProperty() {
        return phone_number;
    }

    //hire_date
    public Object getHireDate(){
        return hire_date.get();
    }

    public void setHireDate(Date hireDate){
        this.hire_date.set(hireDate);
    }

    public SimpleObjectProperty<Date> hireDateProperty(){
        return hire_date;
    }

    //job_id
    public String getJobId () {
        return job_id.get();
    }

    public void setJobId (String jobId){
        this.job_id.set(jobId);
    }

    public StringProperty jobIdProperty() {
        return job_id;
    }

    //salary
    public int getSalary() {
        return salary.get();
    }

    public void setSalary(int salary){
        this.salary.set(salary);
    }

    public IntegerProperty salaryProperty(){
        return salary;
    }

    //commission_pct
    public double getCommissionPct() {
        return commission_pct.get();
    }

    public void setCommissionPct(double commissionPct){
        this.commission_pct.set(commissionPct);
    }

    public DoubleProperty commissionPctProperty(){
        return commission_pct;
    }

    //manager_id
    public int getManagerId() {
        return manager_id.get();
    }

    public void setManagerId(int managerId){
        this.manager_id.set(managerId);
    }

    public IntegerProperty managerIdProperty(){
        return manager_id;
    }

    //department_id
    public int getDepartmanId() {
        return department_id.get();
    }

    public void setDepartmantId(int departmentId){
        this.manager_id.set(departmentId);
    }

    public IntegerProperty departmentIdProperty(){
        return department_id;
    }
}
