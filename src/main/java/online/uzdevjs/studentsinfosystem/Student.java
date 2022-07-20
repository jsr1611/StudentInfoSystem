package online.uzdevjs.studentsinfosystem;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/19/2022 - 6:52 PM
 */

public abstract class Student {
    private Long studentID;
    private String fullName;
    private String nationality;
    private String gender;
    private String faculty;
    private Integer admissionYear;
    private StudentLevel level;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public StudentLevel getLevel() {
        return level;
    }

    public void setLevel(String level) {
        System.out.println(level);
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

    public Student(Long studentID, String fullName, String nationality, String gender, String faculty, Integer admissionYear, String level) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.nationality = nationality;
        this.gender = gender;
        this.faculty = faculty;
        this.admissionYear = admissionYear;
        setLevel(level);
    }

    public Student() {
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", fullName='" + fullName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                ", faculty='" + faculty + '\'' +
                ", admissionYear=" + admissionYear +
                ", level='" + level + '\'' +
                '}';
    }
}
