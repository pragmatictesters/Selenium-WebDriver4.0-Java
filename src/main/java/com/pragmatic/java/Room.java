package com.pragmatic.java;

public class Room {

    private String name;
    private String type;
    private int capacity;
    double dailyRate;

    private boolean isPetFriendly;

    public Room(String name, String type, int capacity, double dailyRate, boolean isPetFriendly) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.dailyRate = dailyRate;
        this.isPetFriendly = isPetFriendly;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isPetFriendly() {
        return isPetFriendly;
    }

    @Override
    public String toString() {
        return "Room{name='%s', type='%s', capacity=%d, dailyRate=%s, isPetFriendly=%s}".formatted(name, type, capacity, dailyRate, isPetFriendly);
    }
}
