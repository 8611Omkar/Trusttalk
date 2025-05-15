package com.example.Trusttalk.repository;

import java.util.OptionalDouble;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Trusttalk.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
   boolean existsByEmail(String email);
   boolean findById(String id);
// User findByEmail(String email);
// Boolean existsById(String id);
   boolean existsById(String id);
   void deleteById(String id);
   // OptionalDouble<User> findById(String id);
   // findbyId(String id);


}