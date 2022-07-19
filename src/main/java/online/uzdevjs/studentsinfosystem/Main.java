package online.uzdevjs.studentsinfosystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/19/2022 - 6:54 PM
 */


public class Main {
    private static List<Student> allStudents = null;
    private static Main singleInstance = null;

    private Main(){
        allStudents = new ArrayList<>();
        Student ali = new Undergraduate(1L, "Ali Talib", "Uzbek", "M", "Computer Science", 2022, "UNDERGRADUATE", "Future Leaders Hall");
        Student vali = new Postgraduate(2L, "Vali Talib", "Uzbek", "M", "Physics", 2021, "POSTGRADUATE", "Alaeldin", "Novel Computer Vision Techniques in the Deep Learning space");
        allStudents.add(ali);
        allStudents.add(vali);
    }
    public static Main getInstance(){
        if(singleInstance == null){
            singleInstance = new Main();
        }
        return singleInstance;
    }

    public void add(StudentDTO student){
        Student st = null;
        if(student.getLevel().equals(StudentLevel.POSTGRADUATE)){
            st = new Postgraduate(
                    student.getStudentID(),
                    student.getFullName(),
                    student.getNationality(),
                    student.getGender(),
                    student.getFaculty(),
                    student.getAddmissionYear(),
                    student.getLevel().toString(),
                    student.getSupervisorName(),
                    student.getResearchTopic());
        }else if(student.getLevel().equals(StudentLevel.UNDERGRADUATE)){
            st = new Undergraduate(
                    student.getStudentID(),
                    student.getFullName(),
                    student.getNationality(),
                    student.getGender(),
                    student.getFaculty(),
                    student.getAddmissionYear(),
                    student.getLevel().toString(),
                    student.getResidentialHall()
            );
        }
        else {
            throw new RuntimeException("Wrong information was provided");
        }
        allStudents.add(st);
    }
    public void remove(final Long studentID){
        allStudents.removeIf(student -> student.getStudentID().equals(studentID));
    }
    public Student findById(Long studentId){
        List<Student> collect = allStudents.stream().filter(student -> student.getStudentID().equals(studentId)).collect(Collectors.toList());

        if(collect.size()>0){
           Student found = collect.get(0);
           return found;
        }
        return null;

    }

    public List<Student> displayAll(){
        return allStudents;
    }
}
