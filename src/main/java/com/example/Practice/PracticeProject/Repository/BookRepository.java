package com.example.Practice.PracticeProject.Repository;


import com.example.Practice.PracticeProject.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    static List<Book> bookList=new ArrayList<>();
    static public void save(Book b){
        bookList.add(b);
    }
    static public List find(){
        return bookList;
    }
    static public List remove(int id){
        bookList.remove(id);
        return bookList;
    }
    static public List update(int id,String name){
        for(Book b:bookList){
            if(b.getId()==id){
                b.setName(name);
            }
        }
        return bookList;
    }

}
