package com.Learning_hub.Controller;

import com.Learning_hub.Entity.StudentEntity;
import com.Learning_hub.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<StudentEntity>> getAll() {
        ArrayList<StudentEntity>  all = new ArrayList<>(studentServices.getAllDetails());
        if (all.isEmpty()){
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(all, HttpStatus.OK);

    }



    @GetMapping("id/{studentId}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long studentId ) {
        StudentEntity getwork= studentServices.getStudentById(studentId);
        if(getwork!= null){
            return  new ResponseEntity<>(getwork, HttpStatus.OK);
        }
        return  new ResponseEntity<>( HttpStatus.BAD_REQUEST);



    @PostMapping
    public ResponseEntity<StudentEntity> postData(@RequestBody StudentEntity studentEntries) {
        StudentEntity postData =   studentServices.createEntry(studentEntries);
        if (postData!= null){
            return new ResponseEntity<>(postData,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("id/{StudentId}")
    public ResponseEntity<?> DeleteEntries(@PathVariable Long StudentId) {
        studentServices.DeleteEntry(StudentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{StudentId}")
    public ResponseEntity<?> PutEntries(@PathVariable Long StudentId, @RequestBody StudentEntity updateEntries) {
        StudentEntity updateWork = studentServices.updateEntry(StudentId,updateEntries);
        if(updateWork!= null){
            return  new ResponseEntity<>(updateWork, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
