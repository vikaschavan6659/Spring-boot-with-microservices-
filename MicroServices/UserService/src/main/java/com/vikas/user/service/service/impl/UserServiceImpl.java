package com.vikas.user.service.service.impl;

import com.vikas.user.service.entity.Hotel;
import com.vikas.user.service.entity.Rating;
import com.vikas.user.service.entity.User;
import com.vikas.user.service.external.services.HotelService;
import com.vikas.user.service.repositery.UserRepositery;
import com.vikas.user.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepositery userRepositery;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        User users = new User();
        users.setUserId(user.getUserId());
        users.setCustomerId(user.getCustomerId());
        users.setEmail(user.getEmail());
        users.setStatus(user.getStatus());
        users.setFirstName(user.getFirstName());
        users.setLastName(user.getLastName());
        users.setUsername(user.getUsername());
        users.setNumberOfFollowups(user.getNumberOfFollowups());
        users.setMobileNumber(user.getMobileNumber());
        users.setIsLeadAdded(user.getIsLeadAdded());
        users.setCreatedAt(user.getCreatedAt());
        userRepositery.save(users);
        return users;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userListr= userRepositery.findAll();
        List<User> modifiedUserList = new ArrayList<>();

        for(User user:userListr){
            ArrayList<Rating> ratingArrayList = restTemplate.getForObject("http://RATING-SERVICE/api/v1/ratings/user/"+user.getUserId(), ArrayList.class);
            user.setRatings(ratingArrayList);
            modifiedUserList.add(user);
        }

        return modifiedUserList;
    }

    @Override
    public User getUser(Long userId) {

         User user=userRepositery.findByUserId(userId);

         if( user!=null && user.getUserId().equals(userId)) {

             Rating[] ratingArrayList = restTemplate.getForObject("http://RATING-SERVICE/api/v1/ratings/user/" + userId, Rating[].class);
             logger.info("Rating of user {}", ratingArrayList);

             List<Rating> ratings = Arrays.stream(ratingArrayList).toList();

             List<Rating> ratingList = ratings.stream().map(rating -> {
                 //api call to hotel service to get hotel
                 logger.info("Hotel id {}", rating.getHotelId());

                 ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/v1/hotels/" + rating.getHotelId(), Hotel.class);
                 Hotel hotel = hotelResponseEntity.getBody();
                 logger.info("Status code: {}", hotelResponseEntity.getStatusCode());


                 //this methode is used for Feign client

                 // Hotel hotel= hotelService.getHotel(rating.getHotelId());

                 //set the hotel to rating
                 rating.setHotel(hotel);
                 //return the rating

                 return rating;
             }).collect(Collectors.toList());

             user.setRatings(ratingList);
         }
         else {
            return null;
         }

        return user;
    }

    @Override
    public User deleteAllUser(Long userId) {

        User user=userRepositery.findByUserId(userId);

//        userRepositery.delete(user);

        return user;
    }

    @Override
    public ResponseEntity<User> updateUser(Long userId) {
        User user=userRepositery.findByUserId(userId);



        return null;
    }
}
