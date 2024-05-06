package com.login.java.project;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {

    private static Map<Long, User> users = new HashMap<>();
    private static Long userIdCounter = 0L;

    static {
        User user1 = new User();
        user1.setId(++userIdCounter);
        user1.setEmail("nadira.sofovic@stu.ssst.edu.ba");
        user1.setUsername("nadirasofovic");
        user1.setPassword("password1");
        users.put(userIdCounter, user1);

        User user2 = new User();
        user2.setId(++userIdCounter);
        user2.setEmail("ena.frasto@stu.ssst.edu.ba");
        user2.setUsername("enafrasto");
        user2.setPassword("password2");
        users.put(userIdCounter, user2);
    }
    public String authenticate(String username, String password) {
        return "Authentication successful";
    }

    public User getUserById(Long id) {
        return users.get(id);
    }

    public String updateUser(Long id, User user) {
        if (users.containsKey(id)) {
            users.put(id, user);
            return "User updated successfully";
        } else {
            return "User not found";
        }
    }

    public String deleteUser(Long id) {
        if (users.containsKey(id)) {
            users.remove(id);
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }

    public String createUser(User user) {
        user.setId(++userIdCounter);
        users.put(userIdCounter, user);
        return "User created successfully";
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
