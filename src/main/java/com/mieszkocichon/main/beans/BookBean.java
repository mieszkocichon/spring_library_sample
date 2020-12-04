package com.mieszkocichon.main.beans;

import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class BookBean
{
    private String id;
    private String name;
    private String author;
    private long year;

    public BookBean(String name, String author, long year)
    {
        this.id = UUID.randomUUID() + "";
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public void setId(String id) {
        this.id = id;
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
