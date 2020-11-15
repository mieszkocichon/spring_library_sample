package com.mieszkocichon.main.services;

import com.mieszkocichon.main.beans.BookBean;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {
    private List<BookBean> books;

    public DashboardService()
    {
        List<BookBean> bookInit = Arrays.asList(
                new BookBean("Jaś i Małgosia", "Wilhelm Karl Grimm", 1_950L),
                new BookBean("Grube wióry", "Pacześ Rafał", 2_018L),
                new BookBean("Powrót", "Katarzyna Nosowska", 1_990L),
                new BookBean("Twoja wewnętrzna moc", "Agnieszka Maciąg", 2_010L)
        );
        books = new ArrayList<>(bookInit);
    }

    public BookBean findById(String id)
    {
        List<BookBean> lists = books.stream().filter(book -> Objects.equals(book.getId(), id)).collect(Collectors.toList());

        if (lists.isEmpty()) {
            return null;
        }

        return lists.get(0);
    }

    public void add(BookBean book)
    {
        this.books.add(book);
    }

    public void removeById(String id)
    {
        this.books = books.stream().filter(book -> !Objects.equals(book.getId(), id)).collect(Collectors.toList());
    }

    public List<BookBean> getAll()
    {
        return new ArrayList<>(this.books);
    }
}
