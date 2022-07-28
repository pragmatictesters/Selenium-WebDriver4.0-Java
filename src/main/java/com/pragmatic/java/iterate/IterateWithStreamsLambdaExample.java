package com.pragmatic.java.iterate;

import com.pragmatic.java.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class IterateWithStreamsLambdaExample {


    public static void main(String[] args) {
        Room mahaweli = new Room("Mahawali", "sute", 5, 200, true);
        Room kelani = new Room("Kelani", "Delux", 3, 150, false);
        Room nilwala = new Room("Nilwala", "Delux", 3, 140, true);

        Collection<Room> roomCollection = new ArrayList<>(Arrays.asList(mahaweli, kelani, nilwala));

       roomCollection.stream()
               .filter(Room::isPetFriendly)
               .forEach(room -> System.out.println(room));

    }
}
