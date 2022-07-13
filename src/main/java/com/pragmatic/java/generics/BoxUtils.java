package com.pragmatic.java.generics;

import java.util.List;

public class BoxUtils {

    public static <T extends Boxable> int getItemCount(Box<T> list){
        return list.getList().size();
    }
}
