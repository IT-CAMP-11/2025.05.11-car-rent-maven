package com.comarch.szkolenia.car.rent.database;

import com.comarch.szkolenia.car.rent.model.User;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();
    @Getter
    private final static UserRepository instance = new UserRepository();

    private UserRepository() {
        this.users.put("admin", new User("admin",
                "73e448ae60c818c23ede44ee35be02b3", User.Role.ADMIN));
        this.users.put("janusz", new User("janusz",
                "49194de393288e58756d8200c5c7b4e7", User.Role.USER));
    }

    public User findUser(String login) {
        return this.users.get(login);
    }
}
