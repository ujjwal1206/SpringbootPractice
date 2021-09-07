package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.Book;
import com.example.Practice.PracticeProject.Repository.BookRepository;
import com.example.Practice.PracticeProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book b){
        Book book=new Book();
        book.setId(b.getId());
        book.setName(b.getName());
        book.setDescp(b.getDescp());
        book.setCount(b.getCount());
        bookRepository.save(book);
    }

    public List display(){
        return bookRepository.findAll();
    }

    public Book displayByid(int id){
        return bookRepository.findById(id).orElse(null);
    }

    public String delete(int id){
        bookRepository.deleteById(id);
        return "DELETED SUCCESSFULLY";
    }

    public List updatename(int id,String name){
        for(Book b:bookRepository.findAll()){
            if(b.getId()==id){
                b.setName(name);
                b.setId(id);
                b.setDescp(b.getDescp());
                b.setCount(b.getCount());
                bookRepository.save(b);
                break;
            }
        }
        return bookRepository.findAll();
    }
    public List updateCount(int id,int count){
        for(Book b:bookRepository.findAll()){
            if(b.getId()==id){
                b.setName(b.getName());
                b.setId(id);
                b.setDescp(b.getDescp());
                b.setCount(count);
                bookRepository.save(b);
                break;
            }
        }
        return bookRepository.findAll();
    }
}
