package com.comarch.szkolenia.car.rent.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
//@EqualsAndHashCode
//@ToString
//@RequiredArgsConstructor
//@Data

public class User {
    private String login;
    private String password;
    private Role role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public enum Role {
        USER,
        ADMIN
    }
}
