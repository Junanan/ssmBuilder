package com.june.controller;

import com.june.pojo.Books;
import com.june.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    BookService bookService;

    @RequestMapping("/allBooks")
    public String allBooks(Model model){
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("list",books);
        return "allBooks";
    }
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addBooks(Books books){
        System.out.println("book" + books);
        bookService.addBook(books);
        return "redirect:/book/allBooks"; //重定向
    }
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookByID(id);
        model.addAttribute("Qbook",books);
        return "updateBook";
    }
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBooks";
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBookByID(id);
        return "redirect:/book/allBooks";
    }
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new LinkedList<Books>();
        list.add(books);
        model.addAttribute("list",list);
        return "allBooks";
    }
}
