package online.uzdevjs.studentsinfosystem.model;

import online.uzdevjs.studentsinfosystem.enums.StudentLevel;

import javax.persistence.Entity;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/19/2022 - 6:53 PM
 */

@Entity
public class Undergraduate extends Student {
    private String residentialHall;

    public Undergraduate(Long studentID, String fullName, String nationality, String gender, String faculty, Integer admissionYear, String level, String residentialHall) {
        super(studentID, fullName, nationality, gender, faculty, admissionYear, level);
        this.residentialHall = residentialHall;
    }

    public Undergraduate(String residentialHall) {
        this.residentialHall = residentialHall;
    }

    public Undergraduate() {

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

