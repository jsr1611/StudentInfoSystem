package online.uzdevjs.studentsinfosystem;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/20/2022 - 3:17 AM
 */

public class StudentDTO extends Student{
    private String residentialHall;
    private String supervisorName;
    private String researchTopic;

    public StudentDTO(Long studentID, String fullName, String nationality, String gender, String faculty, Integer addmissionYear, String level, String residentialHall, String supervisorName, String researchTopic) {
        super(studentID, fullName, nationality, gender, faculty, addmissionYear, level);
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                super.toString() +
                "residentialHall='" + residentialHall + '\'' +
                ", supervisorName='" + supervisorName + '\'' +
                ", researchTopic='" + researchTopic + '\'' +
                '}';
    }
}
