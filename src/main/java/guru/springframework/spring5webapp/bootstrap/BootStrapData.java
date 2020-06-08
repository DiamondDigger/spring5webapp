package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author ron = new Author("Ron", "Jameson");
        Book BoP = new Book("Bible of Programming", "4352398");

        ron.getBooks().add(BoP);
        BoP.getAuthors().add(ron);

        authorRepository.save(ron);
        bookRepository.save(BoP);

        Author mack = new Author("Mack", "Pot");
        Book JVM = new Book("Java Virtual Machine", "12340458");

        ron.getBooks().add(JVM);
        BoP.getAuthors().add(mack);

        authorRepository.save(mack);
        bookRepository.save(JVM);

        Publisher russianPublisher = new Publisher("SouzDruk", "Red 21", "Moscow",
                "Virginia", "23415");
        publisherRepository.save(russianPublisher);

        System.out.println("BootStrap starting....");
        System.out.println("bookRepository from " + bookRepository.count() + " book(s)");
        System.out.println("publisherRepository from " + publisherRepository.count() + " publisher(s)");
    }
}
