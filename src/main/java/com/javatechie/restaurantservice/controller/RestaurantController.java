package com.javatechie.restaurantservice.controller;

import com.javatechie.restaurantservice.dto.RestaurantRequest;
import com.javatechie.restaurantservice.dto.RestaurantResponse;
import com.javatechie.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
@Slf4j
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/saveRestaurant")
    public ResponseEntity<RestaurantResponse> saveRestaurant(@RequestBody RestaurantRequest restaurantRequest) {

       RestaurantResponse restaurantResponse = restaurantService.saveRestaurant(restaurantRequest);
        return new ResponseEntity<>(restaurantResponse, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<RestaurantResponse>> findAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }
}
