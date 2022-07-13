package com.pragmatic.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Box <E>{

    List<E> list;

    public Box() {
        this.list = new ArrayList<>();
    }


    public E getLatestItem(){
        return list.get(list.size() - 1);
    }

    public void  addItem(E item){
        list.add(item);
    }

    public List<E> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }
}
