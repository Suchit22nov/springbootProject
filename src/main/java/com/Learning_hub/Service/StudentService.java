package com.Learning_hub.Service;

import com.Learning_hub.Entity.StudentEntity;
import com.Learning_hub.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;

    public StudentEntity createEntry(StudentEntity userEntry) {
        userEntry.setDate(LocalDateTime.now());
        return studentRepository.save(userEntry);
    }

    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


    public List<StudentEntity> getAllDetails() {
        return studentRepository.findAll();
    }

    public void DeleteEntry(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentEntity updateEntry(Long id, StudentEntity studentUpdateEntry) {
        StudentEntity old = studentRepository.findById(id).orElse(null);

        old.setName(studentUpdateEntry.getName());
        old.setWork(studentUpdateEntry.getWork());

        return studentRepository.save(old);
    }
}
