package com.example.Trusttalk.service;

import com.example.Trusttalk.model.User;
import com.example.Trusttalk.repository.UserRepository;
import org.apache.kafka.common.message.DescribeUserScramCredentialsRequestData;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User username){
        userRepository.save(username);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

//    public Optional<User> findById(long id){
//        return userRepository.findById(id);
//    }


}