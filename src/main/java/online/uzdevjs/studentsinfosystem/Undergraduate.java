package online.uzdevjs.studentsinfosystem;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/19/2022 - 6:53 PM
 */


public class Undergraduate extends Student {
    private String residentialHall;

    public Undergraduate(Long studentID, String fullName, String nationality, String gender, String faculty, Integer addmissionYear, String level, String residentialHall) {
        super(studentID, fullName, nationality, gender, faculty, addmissionYear, level);
        this.residentialHall = residentialHall;
    }

    public Undergraduate(String residentialHall) {
        this.residentialHall = residentialHall;
    }

    public String getResidentialHall() {
        return residentialHall;
    }

    public void setResidentialHall(String residentialHall) {
        this.residentialHall = residentialHall;
    }

    @Override
    public String toString() {
        return "Undergraduate{" +
                super.toString() +
                "residentialHall='" + residentialHall + '\'' +
                '}';
    }
}

