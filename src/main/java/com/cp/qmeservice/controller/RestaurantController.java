package com.cp.qmeservice.controller;

import com.cp.qmeservice.model.Restaurant;
import com.cp.qmeservice.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController
{
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService)
    {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants()
    {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id)
    {
        return restaurantService.getRestaurantById(id)
                .map(restaurant -> ResponseEntity.ok(restaurant))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant)
    {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant)
    {
        return restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable int id)
    {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok().build();
    }
}
