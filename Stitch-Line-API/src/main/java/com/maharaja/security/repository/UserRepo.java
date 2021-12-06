package com.maharaja.security.repository;

import com.maharaja.security.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<Users,String>{}