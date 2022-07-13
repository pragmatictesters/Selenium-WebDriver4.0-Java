package com.pragmatic.java.generics;

public class Book {
    private String author;
    private String name;

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{author='%s', name='%s'}".formatted(author, name);
    }
}
