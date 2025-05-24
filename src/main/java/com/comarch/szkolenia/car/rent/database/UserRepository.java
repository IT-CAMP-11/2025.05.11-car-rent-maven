package com.comarch.szkolenia.car.rent.database;

import com.comarch.szkolenia.car.rent.model.User;
import lombok.Getter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();
    @Getter
    private final static UserRepository instance = new UserRepository();
    private final String DB_FILE = "users.txt";

    private UserRepository() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(DB_FILE))) {
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                String[] parameter = line.split(";");
                User user = new User(parameter[0], parameter[1], User.Role.valueOf(parameter[2]));
                this.users.put(user.getLogin(), user);
            }
        } catch (IOException e) {
            System.out.println("baza nie dziala !!");
        }
    }

    public User findUser(String login) {
        return this.users.get(login);
    }

    public void persist() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(DB_FILE))) {
            for(User u : this.users.values()) {
                writer.write(u.convertToDatabaseLine());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nie dziala zapisywanie !!");
        }
    }
}
