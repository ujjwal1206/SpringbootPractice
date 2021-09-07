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

    @GetMapping("/book/display/{id}")
    public Book displayByid(@PathVariable int id){
        return bookService.displayByid(id);
    }

    @DeleteMapping("/book/delete/{id}")
    public String delete(@PathVariable int id){
        return bookService.delete(id);
    }

    @PutMapping("/book/update/name/{id}")
    public List updateName(@PathVariable int id,@RequestParam String name){
        return bookService.updatename(id,name);
    }

    @PutMapping("/book/update/count/{id}")
    public List updateCount(@PathVariable int id,@RequestParam int count){
        return bookService.updateCount(id,count);
    }
}
