package org.example.web.controllers;


import org.apache.log4j.Logger;
import org.example.app.services.BookService;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "books")
public class BookShelfController {

    private Logger logger = Logger.getLogger(BookShelfController.class);
    private BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        logger.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") @Validated Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book_shelf";
        }
        bookService.saveBook(book);
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove")
    public String removeBook(@RequestParam(value = "bookIdToRemove") Integer bookIdToRemove, Model model) {
        if (bookService.removeBookById(bookIdToRemove)) {
            return "redirect:/books/shelf";
        } else {
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.getAllBooks());
            return "book_shelf";
        }
    }

    @PostMapping("/remove-by-author")
    public String removeBooksByAuthor(@RequestParam(value = "authorPattern") String authorPattern, Model model) {
        bookService.deleteBooksByAuthorRegex(authorPattern);
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove-by-title")
    public String removeBooksByTitle(@RequestParam(value = "titlePattern") String titlePattern, Model model) {
        bookService.deleteBooksByTitleRegex(titlePattern);
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove-by-size")
    public String removeBooksBySize(@RequestParam(value = "sizePattern") String sizePattern, Model model) {
        bookService.deleteBooksBySizeRegex(sizePattern);
        return "redirect:/books/shelf";
    }
}
