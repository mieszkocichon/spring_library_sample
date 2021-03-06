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
        books = new ArrayList<>(Arrays.asList(
                new BookBean("Jaś i Małgosia", "Wilhelm Karl Grimm", 1_950L),
                new BookBean("Grube wióry", "Pacześ Rafał", 2_018L),
                new BookBean("Powrót", "Katarzyna Nosowska", 1_990L),
                new BookBean("Twoja wewnętrzna moc", "Agnieszka Maciąg", 2_010L)
        ));
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
        books.add(book);
    }

    public void removeById(String id)
    {
        books = deleteBookById(id);
    }

    public List<BookBean> getAll()
    {
        return books;
    }

    public List<BookBean> updateById(String id, BookBean bookBean) {
        List<BookBean> allBooksById = books.stream().filter(book -> Objects.equals(book.getId(), id)).collect(Collectors.toList());

        if (allBooksById.isEmpty()) {
            return null;
        }

        books = deleteBookById(id);
        bookBean.setId(id);
        books.add(bookBean);

        return books;
    }

    private List<BookBean> deleteBookById(String id) {
        return books.stream().filter(book -> !Objects.equals(book.getId(), id)).collect(Collectors.toList());
    }
}
