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

    public List<Restaurant> getAllRestaurants()
    {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(int id)
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

    public void deleteRestaurant(int id)
    {
        restaurantRepository.deleteById(id);
    }
}

