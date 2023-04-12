package com.springboot.spring6webapp.services;

import com.springboot.spring6webapp.domain.Book;

public interface BookService {
    public Iterable<Book> findAll();
}
