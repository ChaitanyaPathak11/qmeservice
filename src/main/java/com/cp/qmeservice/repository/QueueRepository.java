package com.cp.qmeservice.repository;

import com.cp.qmeservice.model.QueueEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QueueRepository extends MongoRepository<QueueEntry, String>
{
    List<QueueEntry> findByRestaurantId(String restaurantId);

    QueueEntry findByRestaurantIdAndUserId(String restaurantId, String userId);

    List<QueueEntry> findByUserId(String userId);


}

