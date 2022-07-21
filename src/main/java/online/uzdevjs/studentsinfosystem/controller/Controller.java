package online.uzdevjs.studentsinfosystem.controller;

import online.uzdevjs.studentsinfosystem.dto.Response;
import online.uzdevjs.studentsinfosystem.dto.StudentDTO;
import online.uzdevjs.studentsinfosystem.service.Main;
import org.springframework.web.bind.annotation.*;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/19/2022 - 6:52 PM
 */

@RestController
@RequestMapping("/")
public class Controller {
    private static final Main main = Main.getInstance();

    @GetMapping("/")
    public Response getAll(){
        return main.getAll();
    }

    @PostMapping("/")
    public Response add(@RequestBody StudentDTO student){
        return main.add(student);
    }

    @DeleteMapping("/{studentId}")
    public Response delete(@PathVariable Long studentId){
        System.out.println(studentId);
        return main.remove(studentId);
    }

    @GetMapping("/{studentId}")
    public Response find(@PathVariable Long studentId){
        return main.find(studentId);
    }

}
