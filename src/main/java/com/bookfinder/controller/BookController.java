package com.bookfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookfinder.model.Book;
import com.bookfinder.repository.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String index(Model model) {
        // Remove the search functionality for now
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("book", new Book());
        return "index";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    // Remove the searchBooks method if you don't need it
    /*
    @GetMapping("/search")
    public String searchBooks(@RequestParam String keyword, Model model) {
        List<Book> books = bookRepository.searchBooks(keyword);
        model.addAttribute("books", books);
        model.addAttribute("book", new Book());
        return "index";
    }
    */
}