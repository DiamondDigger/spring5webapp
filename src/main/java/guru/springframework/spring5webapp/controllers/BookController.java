package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private BookRepository bookrepository;

    public BookController(BookRepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    @GetMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookrepository.findAll());

        return "books";
    }






}
