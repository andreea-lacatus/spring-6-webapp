package com.springboot.spring6webapp.bootstrap;

import com.springboot.spring6webapp.domain.Author;
import com.springboot.spring6webapp.domain.Book;
import com.springboot.spring6webapp.repositories.AuthorRepository;
import com.springboot.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Eric");
        author.setLastName("Evens");

        Book book = new Book();
        book.setTitle("Domain driven design");

        Author savedAuthor = authorRepository.save(author);
        Book savedBook = bookRepository.save(book);

        savedAuthor.getBooks().add(savedBook);

        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
