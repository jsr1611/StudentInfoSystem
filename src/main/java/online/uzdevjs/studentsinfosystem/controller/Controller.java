package online.uzdevjs.studentsinfosystem.controller;

import online.uzdevjs.studentsinfosystem.dto.Response;
import online.uzdevjs.studentsinfosystem.dto.StudentDTO;
import online.uzdevjs.studentsinfosystem.service.Service;
import org.springframework.web.bind.annotation.*;

/**
 * Project Students Info System
 * Author: jimmy
 * Created: 7/19/2022 - 6:52 PM
 */

@RestController
@RequestMapping("/")
public class Controller {
    private Service service;
    public Controller(Service service){
        this.service = service;
    }

    @GetMapping("/")
    public Response getAll(){
        return service.getAll();
    }

    @PostMapping("/")
    public Response add(@RequestBody StudentDTO student){
        return service.save(student);
    }

    @DeleteMapping("/{studentId}")
    public Response delete(@PathVariable Long studentId){
        return service.delete(studentId);
    }

    @GetMapping("/{studentId}")
    public Response find(@PathVariable Long studentId){
        return service.find(studentId);
    }

}
