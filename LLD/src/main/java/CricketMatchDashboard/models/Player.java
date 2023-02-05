package CricketMatchDashboard.models;

import CricketMatchDashboard.enums.Gender;

public class Player {
    private String name;
    private Gender gender;
    private int age;

    public Player(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
