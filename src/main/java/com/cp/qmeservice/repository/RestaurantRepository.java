package com.cp.qmeservice.repository;

import com.cp.qmeservice.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, Integer>
{
    // custom methods
}
