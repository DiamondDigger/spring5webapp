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


        Publisher russianPublisher = new Publisher("SouzDruk", "Red 21", "Moscow",
                "Virginia", "23415");
        publisherRepository.save(russianPublisher);

        Author ron = new Author("Ron", "Jameson");
        Book BoP = new Book("Bible of Programming", "4352398");

        ron.getBooks().add(BoP);
        BoP.getAuthors().add(ron);
        BoP.setPublisher(russianPublisher);
        russianPublisher.getBooks().add(BoP);

        authorRepository.save(ron);
        bookRepository.save(BoP);
        publisherRepository.save(russianPublisher);

        Author mack = new Author("Mack", "Pot");
        Book JVM = new Book("Java Virtual Machine", "12340458");

        mack.getBooks().add(JVM);
        JVM.getAuthors().add(mack);
        JVM.setPublisher(russianPublisher);
        russianPublisher.getBooks().add(JVM);

        authorRepository.save(mack);
        bookRepository.save(JVM);
        publisherRepository.save(russianPublisher);

        System.out.println("BootStrap is starting....");
        System.out.println("bookRepository from " + bookRepository.count() + " book(s)");
        System.out.println("publisherRepository from " + publisherRepository.count() + " publisher(s)");
        System.out.println("russianPublisher.getBooks = " + russianPublisher.getBooks().size());
        System.out.println("Details about publisher: " + russianPublisher.toString());
    }
}
