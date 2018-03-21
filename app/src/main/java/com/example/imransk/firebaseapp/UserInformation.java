package com.example.imransk.firebaseapp;

/**
 * Created by imran sk on 3/21/2018.
 */

public class UserInformation {
    String name;
    String number;
    String age;

    public UserInformation() {
    }

    public UserInformation(String name, String number, String age) {

        this.name = name;
        this.number = number;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAge() {
        return age;
    }
}
