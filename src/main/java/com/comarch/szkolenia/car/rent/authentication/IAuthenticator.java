package com.comarch.szkolenia.car.rent.authentication;

public interface IAuthenticator {
    void authenticate(String login, String password);
}
