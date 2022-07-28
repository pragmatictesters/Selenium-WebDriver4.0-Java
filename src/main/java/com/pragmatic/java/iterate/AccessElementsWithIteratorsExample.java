package com.pragmatic.java.iterate;

import com.pragmatic.java.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class AccessElementsWithIteratorsExample {


    public static void main(String[] args) {
        Room mahaweli = new Room("Mahawali", "sute", 5, 200, true);
        Room kelani = new Room("Kelani", "Delux", 3, 150, false);
        Room nilwala = new Room("Nilwala", "Delux", 3, 140, false);

        Collection<Room> roomCollection = new ArrayList<>(Arrays.asList(mahaweli, kelani, nilwala));

        Iterator<Room> iterator = roomCollection.iterator();
        
        while (iterator.hasNext()){
            Room room = iterator.next();
            System.out.println("room.getName() = " + room.getName());
            
        }

        for (Room room : roomCollection) {
            System.out.println("room.getName() = " + room.getName());
        }


    }
}
