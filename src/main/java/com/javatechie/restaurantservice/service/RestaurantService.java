package com.javatechie.restaurantservice.service;

import com.javatechie.restaurantservice.dto.RestaurantRequest;
import com.javatechie.restaurantservice.dto.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    RestaurantResponse saveRestaurant(RestaurantRequest restaurantRequest);

    List<RestaurantResponse> getAllRestaurants();
}
