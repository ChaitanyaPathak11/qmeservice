package com.cp.qmeservice.controller;

import com.cp.qmeservice.model.Restaurant;
import com.cp.qmeservice.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(origins = "*")
public class RestaurantController
{
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService)
    {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Restaurant restaurant)
    {
        try
        {
            Restaurant created = restaurantService.register(restaurant);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e)
        {
            return ResponseEntity
                    .badRequest()
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest)
    {
        try
        {
            Restaurant restaurant = restaurantService.login(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(restaurant);
        } catch (Exception e)
        {
            return ResponseEntity
                    .badRequest()
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @GetMapping
    public List<Restaurant> getAllRestaurants()
    {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String id)
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
    public ResponseEntity<Void> deleteRestaurant(@PathVariable String id)
    {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok().build();
    }

    public static class LoginRequest
    {
        private String email;
        private String password;

        // Getters and Setters
        public String getEmail()
        {
            return email;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }

        public String getPassword()
        {
            return password;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }
    }
}
