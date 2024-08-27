package com.TheFirstChatApp.FirstChatApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TheFirstChatApp.FirstChatApp.models.User;

public interface UserRepository extends MongoRepository<User,String> {
    
}
