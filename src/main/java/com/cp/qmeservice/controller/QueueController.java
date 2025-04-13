package com.cp.qmeservice.controller;

import com.cp.qmeservice.model.QueueEntry;
import com.cp.qmeservice.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/queue")
@CrossOrigin(origins = "*")
public class QueueController
{

    @Autowired
    private QueueService queueService;

    @GetMapping("/{restaurantId}/today")
    public List<QueueEntry> getTodayQueue(@PathVariable String restaurantId)
    {
        return queueService.getTodayQueue(restaurantId);
    }

    @PutMapping("/update/{id}")
    public void updateStatus(@PathVariable String id, @RequestBody StatusUpdate request)
    {
        queueService.updateStatus(id, request.getStatus());
    }

    @PostMapping("/join")
    public ResponseEntity<?> joinQueue(@RequestBody QueueEntry entry)
    {
        try
        {
            QueueEntry saved = queueService.joinQueue(entry);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e)
        {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @GetMapping("/user/{userId}/today")
    public ResponseEntity<List<QueueEntry>> getUserQueues(@PathVariable String userId)
    {
        return ResponseEntity.ok(queueService.getUserJoinedQueues(userId));
    }


    public static class StatusUpdate
    {
        private String status;

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }
    }

}
