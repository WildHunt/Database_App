package sample;

import javafx.beans.property.*;

import java.sql.Date;

public class Doctors {
    private IntegerProperty id_doctor;
    private StringProperty name;
    private StringProperty surname;
    private StringProperty email;
    private StringProperty spec;
    private StringProperty city;
    private StringProperty phone_number;
    private StringProperty social;
    private BooleanProperty car;
    private BooleanProperty resident;

    public Doctors() {
        this.id_doctor = new SimpleIntegerProperty();;
        this.name = new SimpleStringProperty();
        this.surname = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.spec = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.phone_number = new SimpleStringProperty();
        this.social = new SimpleStringProperty();
        this.car = new SimpleBooleanProperty();
        this.resident = new SimpleBooleanProperty();
    }

    public int getId_doctor() {
        return id_doctor.get();
    }

    public IntegerProperty id_doctorProperty() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor.set(id_doctor);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getSpec() {
        return spec.get();
    }

    public StringProperty specProperty() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec.set(spec);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getPhone_number() {
        return phone_number.get();
    }

    public StringProperty phone_numberProperty() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }

    public String getSocial() {
        return social.get();
    }

    public StringProperty socialProperty() {
        return social;
    }

    public void setSocial(String social) {
        this.social.set(social);
    }

    public boolean isCar() {
        return car.get();
    }

    public BooleanProperty carProperty() {
        return car;
    }

    public void setCar(boolean car) {
        this.car.set(car);
    }

    public boolean isResident() {
        return resident.get();
    }

    public BooleanProperty residentProperty() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident.set(resident);
    }
}
