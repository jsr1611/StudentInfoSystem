package online.uzdevjs.studentsinfosystem.service;

import online.uzdevjs.studentsinfosystem.dto.Response;
import online.uzdevjs.studentsinfosystem.enums.StudentLevel;
import online.uzdevjs.studentsinfosystem.dto.StudentDTO;
import online.uzdevjs.studentsinfosystem.model.Postgraduate;
import online.uzdevjs.studentsinfosystem.model.Student;
import online.uzdevjs.studentsinfosystem.model.Undergraduate;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Response add(StudentDTO student){
        Student st = null;
        if(student.getLevel().equals(StudentLevel.POSTGRADUATE)){
            st = new Postgraduate(
                    student.getStudentID(),
                    student.getFullName(),
                    student.getNationality(),
                    student.getGender(),
                    student.getFaculty(),
                    student.getAdmissionYear(),
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
                    student.getAdmissionYear(),
                    student.getLevel().toString(),
                    student.getResidentialHall()
            );
        }
        else {
            return new Response(false, "Incorrect student record information was provided: " + student.toString(), HttpStatus.OK);
        }
        allStudents.add(st);
        return new Response(true, "New student record has been successfully added.", st, HttpStatus.OK);
    }

    public Response remove(final Long studentID){
        Response response;
        if(findById(studentID) != null){
            allStudents.removeIf(student -> student.getStudentID().equals(studentID));
            response = new Response(true, "Student record has been successfully deleted", HttpStatus.OK);
        }else {
            response = new Response(false, "Student record with id (" + studentID + ") was not found.", HttpStatus.OK);
        }
        return response;
    }
    public Student findById(Long studentId){
        List<Student> collect = allStudents.stream().filter(student -> student.getStudentID().equals(studentId)).collect(Collectors.toList());

        if(collect.size()>0){
           Student found = collect.get(0);
           return found;
        }
        return null;
    }

    public Response find(Long studentId){
        Student student = findById(studentId);
        Response response;
        if(student != null){
            response = new Response(true, "Student Record", student, HttpStatus.OK);
        }
        else {
            response = new Response(false, "Student record with id (" + studentId + ") was not found.", HttpStatus.OK);
        }
            return response;
    }

    public Response getAll(){
        return new Response(true, "All Records", allStudents, HttpStatus.OK);
    }
}
