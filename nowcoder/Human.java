package com.nowcoder;

public class Human extends Animal {
    private String country;

    public Human(String name, int age, String county) {
        super(name, age);
        this.country = county;
    }

    public void say() {
        System.out.println("This is " + getName() + " from " + country);
    }
}