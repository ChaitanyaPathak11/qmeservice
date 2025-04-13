package com.cp.qmeservice.repository;

import com.cp.qmeservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>
{
    User findByEmail(String email);

    boolean existsByEmail(String email);
}
