package com.springboot.spring6webapp.bootstrap;

import com.springboot.spring6webapp.domain.Author;
import com.springboot.spring6webapp.domain.Book;
import com.springboot.spring6webapp.domain.Publisher;
import com.springboot.spring6webapp.repositories.AuthorRepository;
import com.springboot.spring6webapp.repositories.BookRepository;
import com.springboot.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Eric");
        author.setLastName("Evens");

        Book book = new Book();
        book.setTitle("Domain driven design");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("HarperCollins");
        publisher.setCity("New York");

        Publisher savedPublisher = publisherRepository.save(publisher);
        Author savedAuthor = authorRepository.save(author);
        Book savedBook = bookRepository.save(book);

        savedAuthor.getBooks().add(savedBook);
        savedBook.getAuthors().add(savedAuthor);
        savedBook.setPublisher(savedPublisher);

        authorRepository.save(savedAuthor);
        bookRepository.save(savedBook);

        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
