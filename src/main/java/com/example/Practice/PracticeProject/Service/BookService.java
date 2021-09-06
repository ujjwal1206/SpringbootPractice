package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.Book;
import com.example.Practice.PracticeProject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public void addBook(Book b){
        Book book=new Book();
        book.setId(b.getId());
        book.setName(b.getName());
        book.setDescp(b.getDescp());
        book.setCount(b.getCount());
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
