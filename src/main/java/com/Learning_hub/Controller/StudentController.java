package com.Learning_hub.Controller;

import com.Learning_hub.Entity.StudentEntity;
import com.Learning_hub.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    public StudentService studentServices;
    //Used for local Storage when database is not present
    private final Map<Long, StudentEntity> studentsDetail = new HashMap<>();

    @GetMapping
    public List<StudentEntity> getAll() {
        return new ArrayList<>(studentServices.getAllDetails());
    }

    @GetMapping("id/{studentId}")
    public Optional<StudentEntity> getStudentById(@PathVariable Long studentId) {
        return studentServices.getStudentById(studentId);
    }

    @PostMapping
    public StudentEntity postData(@RequestBody StudentEntity studentEntries) {
        return studentServices.createEntry(studentEntries);
    }

    @DeleteMapping("id/{StudentId}")
    public String DeleteEntries(@PathVariable Long StudentId) {
        studentServices.DeleteEntry(StudentId);
        return "Deleted Entry whose id is " + StudentId;
    }

    @PutMapping("id/{StudentId}")
    public StudentEntity PutEntries(@PathVariable Long StudentId, @RequestBody StudentEntity updateEntries) {
        return null;
    }
}
