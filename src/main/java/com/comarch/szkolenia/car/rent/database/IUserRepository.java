package com.comarch.szkolenia.car.rent.database;

import com.comarch.szkolenia.car.rent.model.User;

public interface IUserRepository {
    User findUser(String login);
    void persist();
}
