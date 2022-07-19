package online.uzdevjs.studentsinfosystem;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/19/2022 - 6:52 PM
 */

@RestController
@RequestMapping("/")
public class Controller {
    private static final Main main = Main.getInstance();

    @GetMapping("/displayAll")
    public List<Student> getAll(){
        System.out.println("/displayAll API endpoint was called");
        System.out.println(main.displayAll().size());
        return main.displayAll();
    }

    @PostMapping("/add")
    public StudentDTO add(StudentDTO student){
        main.add(student);
        return student;
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Long studentId){
        String result = "";
        if(main.findById(studentId) != null){
            main.remove(studentId);
            result = "Student with ID " + studentId + " was successfully deleted!";
        }
        else {
            result = "Student not found with ID " + studentId;
        }
        return result;
    }

    @GetMapping("/{studentId}")
    public Student findById(@PathVariable Long studentId){
        return main.findById(studentId);
    }

}
