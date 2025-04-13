package com.cp.qmeservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "restaurant_queue")
public class QueueEntry
{
    @Id
    private String id;

    private String userId; // NEW

    private String restaurantId;
    private String name;
    private String phone;
    private String status; // pending, allotted, removed
    private LocalDate date;
    private int peopleCount;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getRestaurantId()
    {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId)
    {
        this.restaurantId = restaurantId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public int getPeopleCount()
    {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount)
    {
        this.peopleCount = peopleCount;
    }
}
