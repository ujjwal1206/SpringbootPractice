package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.Book;
import com.example.Practice.PracticeProject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public void addBook(int id,String name,String descrip,int count){
        Book book=new Book();
        book.setId(id);
        book.setName(name);
        book.setDescp(descrip);
        book.setCount(count);
        BookRepository.save(book);
    }
    public List display(){
        return BookRepository.find();
    }
    public List delete(int id){
        return BookRepository.remove(id);
    }
    public List updatename(int id,String name){
        return BookRepository.update(id,name);
    }
}
