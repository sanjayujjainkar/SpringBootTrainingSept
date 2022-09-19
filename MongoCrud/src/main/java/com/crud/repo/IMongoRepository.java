package com.crud.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.entity.Student;

public interface IMongoRepository extends MongoRepository<Student, Integer> {

}
