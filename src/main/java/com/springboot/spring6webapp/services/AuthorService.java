package com.springboot.spring6webapp.services;

import com.springboot.spring6webapp.domain.Author;

public interface AuthorService {
    public Iterable<Author> findAll();
}
