package sample;
import javafx.beans.property.*;

public class Admins {
    private IntegerProperty idAdmins;
    private StringProperty userAdmins;
    private StringProperty roolsAdmins;
    private StringProperty activityAdmins;

    public Admins() {
        this.idAdmins = new SimpleIntegerProperty();
        this.userAdmins = new SimpleStringProperty();
        this.roolsAdmins = new SimpleStringProperty();
        this.activityAdmins = new SimpleStringProperty();
    }

    public int getIdAdmins() {
        return idAdmins.get();
    }

    public IntegerProperty idAdminsProperty() {
        return idAdmins;
    }

    public void setIdAdmins(int idAdmins) {
        this.idAdmins.set(idAdmins);
    }

    public String getUserAdmins() {
        return userAdmins.get();
    }

    public StringProperty userAdminsProperty() {
        return userAdmins;
    }

    public void setUserAdmins(String userAdmins) {
        this.userAdmins.set(userAdmins);
    }

    public String getRoolsAdmins() {
        return roolsAdmins.get();
    }

    public StringProperty roolsAdminsProperty() {
        return roolsAdmins;
    }

    public void setRoolsAdmins(String roolsAdmins) {
        this.roolsAdmins.set(roolsAdmins);
    }

    public String getActivityAdmins() {
        return activityAdmins.get();
    }

    public StringProperty activityAdminsProperty() {
        return activityAdmins;
    }

    public void setActivityAdmins(String activityAdmins) {
        this.activityAdmins.set(activityAdmins);
    }
}
