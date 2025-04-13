package com.cp.qmeservice.service;

import com.cp.qmeservice.model.Restaurant;
import com.cp.qmeservice.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService
{
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant register(Restaurant restaurant)
    {
        Restaurant existing = restaurantRepository.findByEmail(restaurant.getEmail());
        if (existing != null)
        {
            throw new RuntimeException("Email already registered.");
        }
        return restaurantRepository.save(restaurant);
    }

    public Restaurant login(String email, String password)
    {
        Restaurant restaurant = restaurantRepository.findByEmail(email);
        if (restaurant == null)
        {
            throw new RuntimeException("Invalid Email.");
        }

        if (!restaurant.getPassword().equals(password))
        {
            throw new RuntimeException("Invalid Password.");
        }
        return restaurant;
    }

    public List<Restaurant> getAllRestaurants()
    {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(String id)
    {
        return restaurantRepository.findById(id);
    }

    public Restaurant addRestaurant(Restaurant restaurant)
    {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Restaurant restaurant)
    {
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(String id)
    {
        restaurantRepository.deleteById(id);
    }
}

