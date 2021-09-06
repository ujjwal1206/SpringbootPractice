package com.example.Practice.PracticeProject.Controller;

import com.example.Practice.PracticeProject.Model.Book;
import com.example.Practice.PracticeProject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/book/add")
    public void add(@RequestBody Book b){
        bookService.addBook(b);
    }
    @GetMapping("/book/display/all")
    public List display(){
        return bookService.display();
    }
    @DeleteMapping("/book/delete/{id}")
    public List delete(@PathVariable int id){
        return bookService.delete(id);
    }
    @PatchMapping("/book/update/{id}")
    public List updateByName(@PathVariable int id,@RequestParam String name){
        return bookService.updatename(id,name);
    }
}
