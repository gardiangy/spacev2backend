package hu.voga.space.service;

import hu.voga.space.entity.User;
import hu.voga.space.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lofut on 2017. 06. 29..
 */

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User getOne(String uuid) { return userRepository.getOne( uuid ); }

    public List<User> finAll() { return userRepository.findAll(); }

}
