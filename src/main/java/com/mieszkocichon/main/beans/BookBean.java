package com.mieszkocichon.main.beans;

import java.util.concurrent.ThreadLocalRandom;

public class BookBean
{
    private final String id;
    private final String name;
    private final String author;
    private final long year;

    public BookBean(String name, String author, long year)
    {
        this.id = ThreadLocalRandom.current().nextInt(20) + 1 + "";
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public long getYear() {
        return year;
    }
}
