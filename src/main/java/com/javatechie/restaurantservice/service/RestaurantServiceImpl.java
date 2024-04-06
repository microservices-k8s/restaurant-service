package com.javatechie.restaurantservice.service;

import com.javatechie.restaurantservice.dto.RestaurantRequest;
import com.javatechie.restaurantservice.dto.RestaurantResponse;
import com.javatechie.restaurantservice.entity.Restaurant;
import com.javatechie.restaurantservice.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponse saveRestaurant(RestaurantRequest restaurantRequest) {

        Restaurant restaurant = Restaurant.builder()
                .name(restaurantRequest.getName())
                .restaurantDescription(restaurantRequest.getRestaurantDescription())
                .address(restaurantRequest.getAddress())
                .city(restaurantRequest.getCity())
                .build();
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantResponse.builder()
                .id(savedRestaurant.getId())
                .name(savedRestaurant.getName())
                .restaurantDescription(savedRestaurant.getRestaurantDescription())
                .address(savedRestaurant.getAddress())
                .city(savedRestaurant.getCity())
                .build();

    }

    @Override
    public List<RestaurantResponse> getAllRestaurants() {

        List<RestaurantResponse> allRestaurants = restaurantRepository.findAll().stream().map(restaurant -> RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .restaurantDescription(restaurant.getRestaurantDescription())
                .address(restaurant.getAddress())
                .city(restaurant.getCity())
                .build()).toList();
        return allRestaurants;
    }
}
