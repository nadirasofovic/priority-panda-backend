package com.login.java.project;

import com.login.java.project.SimpleUser;
import com.login.java.project.User;
import com.login.java.project.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class HabitRebootUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public HabitRebootUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = getFullUserByUsername(userName);
        // todo !!!
        user = new User();
        user.setUsername("heyyou");
        //$2a$12$6zdoF5KmZTdGH2/EkVav0.wQB.K.RxsKb6EfPeXUl0rNQ8xQaRUcS
        user.setPassword("$2a$12$EgZR0vmDaI1u6kv/ePZMG.Mq4gLMIkRagfZVhFLx8gP54XuTyuuwq"); // samsung

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), Collections.emptyList());
    }

    public SimpleUser getUserByUsername(String userName) {
        getFullUserByUsername(userName); // user exists?
        return new SimpleUser(userName);
    }

    private User getFullUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
}