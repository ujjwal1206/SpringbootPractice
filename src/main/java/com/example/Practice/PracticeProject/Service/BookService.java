package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    List<Book> bookList=new ArrayList<Book>();
    Book book=new Book();
    public void addBook(int id,String name,String descrip,int count){
        book.setId(id);
        book.setName(name);
        book.setDescp(descrip);
        book.setCount(count);
        bookList.add(book);
    }
    public List display(){
        return bookList;
    }
    public List delete(int id){
        bookList.remove(id);
        return bookList;
    }
    public List updatename(int id,String name){
        for(Book b:bookList){
            if(b.getId()==id){
                b.setName(name);
            }
        }
        return bookList;
    }
}
