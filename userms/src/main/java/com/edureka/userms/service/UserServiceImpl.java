package com.edureka.userms.service;

import com.edureka.userms.model.OrderTO;
import com.edureka.userms.model.User;
import com.edureka.userms.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, @Qualifier("myRestTemplate") RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getAllUsers(Optional<String> name) {
        LOGGER.info("************");
        LOGGER.info("getting all users");
        LOGGER.debug("***");
        LOGGER.error("^^^");

        if (name.isPresent()) {
            Optional<List<User>> optionalUserList = userRepository.findByNameContainingIgnoreCase(name.get());
            return optionalUserList.orElse(Collections.emptyList());
        }
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getSingleUser(Long userId) {
        LOGGER.info("************");
        LOGGER.info("getting single user");
        return userRepository.findById(userId);
    }

    @Override
    public User createUser(User user) {
        User userCreated = userRepository.save(user);
        return userCreated;
    }

    @Override
    public void partiallyUpdateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getAllOrdersFromFallBack")
    public OrderTO[] getAllOrders() {
        return restTemplate.getForObject("http://orderms/orders", OrderTO[].class);
    }

    public OrderTO[] getAllOrdersFromFallBack() {
        // cache
        OrderTO[] orderTOArray = new OrderTO[2];
        orderTOArray[0] = new OrderTO(88L, "Eighty-eight");
        orderTOArray[1] = new OrderTO(99L, "Ninety-Nine");

        return orderTOArray;
    }
}
