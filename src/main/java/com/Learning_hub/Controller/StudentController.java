package com.Learning_hub.Controller;

import com.Learning_hub.Entity.StudentEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Student")
public class StudentController {
    private final Map<Long , StudentEntity> studentsDetail = new HashMap<>();

    @GetMapping
    public List<StudentEntity>  getAll(){
        return new ArrayList<>(studentsDetail.values());
    };
    @PostMapping
    public StudentEntity postData(@RequestBody StudentEntity studentEntries ){
        studentsDetail.put(studentEntries.getId(),studentEntries);
        return studentEntries;

    }
    @DeleteMapping("id/{StudentId}")
    public StudentEntity DeleteEntries(@PathVariable Long StudentId){
        return studentsDetail.remove(StudentId);
    }
    @PutMapping("id/{StudentId}")
    public StudentEntity PutEntries(@PathVariable Long StudentId,@RequestBody StudentEntity updateEntries ){
        return studentsDetail.put(StudentId,updateEntries);
    }
}
