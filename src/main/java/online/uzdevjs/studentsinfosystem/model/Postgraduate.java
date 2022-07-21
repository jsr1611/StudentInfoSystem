package online.uzdevjs.studentsinfosystem.model;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/19/2022 - 6:53 PM
 */


public class Postgraduate extends Student{
    private String supervisorName;
    private String researchTopic;

    public Postgraduate(Long studentID, String fullName, String nationality, String gender, String faculty, Integer admissionYear, String level, String supervisorName, String researchTopic) {
        super(studentID, fullName, nationality, gender, faculty, admissionYear, level);
        this.supervisorName = supervisorName;
        this.researchTopic = researchTopic;
    }

    public Postgraduate(String supervisorName, String researchTopic) {
        this.supervisorName = supervisorName;
        this.researchTopic = researchTopic;
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
        return  "Postgraduate{" +
                super.toString() +
                "supervisorName='" + supervisorName + '\'' +
                ", researchTopic='" + researchTopic + '\'' +
                '}';
    }
}
