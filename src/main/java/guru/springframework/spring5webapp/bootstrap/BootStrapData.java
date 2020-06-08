package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author ron = new Author("Ron","Jameson");
        Book BoP = new Book("Bible of Programming","4352398");
        
        ron.getBooks().add(BoP);
        BoP.getAuthors().add(ron);
        
        authorRepository.save(ron);
        bookRepository.save(BoP);
        
        Author mack = new Author("Mack","Pot");
        Book JVM = new Book("Java Virtual Machine","12340458");
        
        ron.getBooks().add(JVM);
        BoP.getAuthors().add(mack);
        
        authorRepository.save(mack);
        bookRepository.save(JVM);

        System.out.println("BootStrap starting....");
        System.out.println("bookRepository.count() = " + bookRepository.count());
        
    }
}
