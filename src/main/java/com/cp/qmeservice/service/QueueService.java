package com.cp.qmeservice.service;

import com.cp.qmeservice.model.QueueEntry;
import com.cp.qmeservice.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class QueueService
{

    @Autowired
    private QueueRepository queueRepository;

    public List<QueueEntry> getTodayQueue(String restaurantId)
    {
        return queueRepository.findByRestaurantId(restaurantId);
    }

    public void updateStatus(String id, String status)
    {
        QueueEntry entry = queueRepository.findById(id).orElseThrow();
        entry.setStatus(status);
        queueRepository.save(entry);
    }

    public QueueEntry joinQueue(QueueEntry entry)
    {
        QueueEntry existing = queueRepository.findByRestaurantIdAndUserId(
                entry.getRestaurantId(), entry.getUserId());

        if (existing != null)
        {
            return existing;
        }

        entry.setDate(LocalDate.now(ZoneId.of("Asia/Kolkata")));
        entry.setStatus("pending");
        return queueRepository.save(entry);
    }

    public List<QueueEntry> getUserJoinedQueues(String userId)
    {
        return queueRepository.findByUserId(userId);
    }


}

