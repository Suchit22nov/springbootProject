package com.Learning_hub.Service;

import com.Learning_hub.Entity.StudentEntity;
import com.Learning_hub.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;

    public StudentEntity createEntry(StudentEntity userEntry){
       return studentRepository.save(userEntry);
    }
    public Optional<StudentEntity> getStudentById(Long id){
        return studentRepository.findById(id);
    }


    public List<StudentEntity> getAllDetails(){
        return studentRepository.findAll();
    }

    public void  DeleteEntry(Long id){
         studentRepository.deleteById(id);
    }
}
