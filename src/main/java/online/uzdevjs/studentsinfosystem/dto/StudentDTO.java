package online.uzdevjs.studentsinfosystem.dto;

import online.uzdevjs.studentsinfosystem.enums.StudentLevel;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/20/2022 - 3:17 AM
 */

public class StudentDTO {
    private Long studentID;
    private String fullName;
    private String nationality;
    private String gender;
    private String faculty;
    private Integer admissionYear;
    private StudentLevel level;
    private String residentialHall;
    private String supervisorName;
    private String researchTopic;

    public StudentDTO(Long studentID, String fullName, String nationality, String gender, String faculty, Integer admissionYear, String level, String residentialHall, String supervisorName, String researchTopic) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.nationality = nationality;
        this.gender = gender;
        this.faculty = faculty;
        this.admissionYear = admissionYear;
        setLevel(level);
        this.residentialHall = residentialHall;
        this.supervisorName = supervisorName;
        this.researchTopic = researchTopic;
    }

    public String getResidentialHall() {
        return residentialHall;
    }

    public void setResidentialHall(String residentialHall) {
        this.residentialHall = residentialHall;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }

    public StudentLevel getLevel() {
        return level;
    }

    public void setLevel(String level) {
        if(level != null && level.equalsIgnoreCase("postgraduate")){
            this.level = StudentLevel.POSTGRADUATE;
        }
        else if(level != null && level.equalsIgnoreCase("undergraduate")){
            this.level = StudentLevel.UNDERGRADUATE;
        }
        else {
            throw new IllegalStateException("Wrong student level: " + level);
        }
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentID=" + studentID +
                ", fullName='" + fullName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                ", faculty='" + faculty + '\'' +
                ", admissionYear=" + admissionYear +
                ", level=" + level +
                ", residentialHall='" + residentialHall + '\'' +
                ", supervisorName='" + supervisorName + '\'' +
                ", researchTopic='" + researchTopic + '\'' +
                '}';
    }
}