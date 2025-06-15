package com.Learning_hub.Repository;

import com.Learning_hub.Entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentEntity,Long> {
}
