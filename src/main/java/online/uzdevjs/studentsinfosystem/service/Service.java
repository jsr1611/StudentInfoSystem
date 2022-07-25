/**
 * author: Jumanazar Said
 * email: jumanazarsaidov@gmail.com
 * date: 2022/07/25 17:10
 */

package online.uzdevjs.studentsinfosystem.service;

import online.uzdevjs.studentsinfosystem.dto.Response;
import online.uzdevjs.studentsinfosystem.dto.StudentDTO;
import online.uzdevjs.studentsinfosystem.enums.StudentLevel;
import online.uzdevjs.studentsinfosystem.model.Postgraduate;
import online.uzdevjs.studentsinfosystem.model.Student;
import online.uzdevjs.studentsinfosystem.model.Undergraduate;
import online.uzdevjs.studentsinfosystem.repository.StudentRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    private StudentRepository studentRepo;

    public Service(StudentRepository studentRepo){
        this.studentRepo = studentRepo;
    }

    public Response save(StudentDTO student){
        Student st = findById(student.getStudentID());
        if(st != null){
            return new Response(false, "Student with this ID(" +student.getStudentID()+") already  exists in the database: ", HttpStatus.BAD_REQUEST);
        }
        else if(student.getLevel().equals(StudentLevel.POSTGRADUATE)){
            st = new Postgraduate(
                    student.getStudentID(),
                    student.getFullName(),
                    student.getNationality(),
                    student.getGender(),
                    student.getFaculty(),
                    student.getAdmissionYear(),
                    student.getLevel().name(),
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
                    student.getLevel().name(),
                    student.getResidentialHall()
            );
        }
        else {
            return new Response(false, "Incorrect student record information was provided: " + student.toString(), HttpStatus.BAD_REQUEST);
        }
        studentRepo.save(st);
        return new Response(true, "New student record has been successfully added.", st, HttpStatus.OK);
    }

    public Response delete(Long studentID){
        Response response;
        Student student = findById(studentID);
        if(student != null){
//            allStudents.removeIf(student -> student.getStudentID().equals(studentID));
            studentRepo.delete(student);
            response = new Response(true, "Student record has been successfully deleted", HttpStatus.OK);
        }else {
            response = new Response(false, "Student record with id (" + studentID + ") was not found.", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public Student findById(Long studentId){
        Optional<Student> optionalStudent = studentRepo.findStudentByStudentID(studentId);
        return optionalStudent.orElse(null);
    }

    public Response find(Long studentId){
        Student student = findById(studentId);
        Response response;
        if(student != null){
            response = new Response(true, "Student Record", student, HttpStatus.OK);
        }
        else {
            response = new Response(false, "Student record with id (" + studentId + ") was not found.", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public Response getAll(){
        List<Student> allStudents = studentRepo.findAll();
        return new Response(true, "All Records", allStudents, HttpStatus.OK);
    }
}
