package bookStoreWithSecurity.bookStoreSecure.controller;

import bookStoreWithSecurity.bookStoreSecure.entity.Book;
import bookStoreWithSecurity.bookStoreSecure.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

    @GetMapping("/book_register")
    public  String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public String viewPage(Model model, @Param("keyword")String keyword){
        List<Book> list=bookService.listAll(keyword);
        model.addAttribute("book",list);
        return "bookList";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable(value = "id")int id ,Model model){
        Book b= bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }

    @RequestMapping("/deleteList/{id}")
    public String deleteList(@PathVariable(value = "id")int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }





}
