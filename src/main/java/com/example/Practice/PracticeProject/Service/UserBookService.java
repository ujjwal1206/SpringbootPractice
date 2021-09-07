package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.Book;
import com.example.Practice.PracticeProject.Model.User;
import com.example.Practice.PracticeProject.Model.UserBookMapping;
import com.example.Practice.PracticeProject.Repository.BookRepository;
import com.example.Practice.PracticeProject.Repository.UserBookRepository;
import com.example.Practice.PracticeProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserBookService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserBookRepository userBookRepository;

    public String add(UserBookMapping usb1){
        UserBookMapping userBookMapping=new UserBookMapping();
        if(isavailable(usb1.getUser_id(), usb1.getBook_id())){
            userBookMapping.setId(usb1.getId());
            userBookMapping.setUser_id(usb1.getUser_id());
            userBookMapping.setBook_id(usb1.getBook_id());
            userBookMapping.setIssuedate(new Date());
            if(usb1.getReturndate()!=null)
                userBookMapping.setReturndate(new Date());
            if(usb1.getReturndate()==null)
                userBookMapping.setIsreturn(false);
            else
                userBookMapping.setIsreturn(true);
            userBookRepository.save(userBookMapping);
            return "ADDED SUCCESSFULLY";
        }
        return "ERROR IN ADDING DATA";

    }
    public boolean isavailable(int Userid,int Bookid){
        int ua=0;
    for(User u: userRepository.findAll()){
        if(u.getId()==Userid){
            ua=1;
            break;
        }
    }
    if(ua==1) {
        for (Book b : bookRepository.findAll()) {
            if (b.getId() == Bookid) {
                if (b.getCount() > 0) {
                    b.setCount(b.getCount() - 1);
                    return true;
                }
            }
        }
    }
    return false;
    }
    public List display(){
        return userBookRepository.findAll();
    }

    public void deleteById(int id){
        userBookRepository.deleteById(id);
    }
    public List updateReturn(int id, boolean isreturn){
        for(UserBookMapping a:userBookRepository.findAll()){
            if(a.getId()==id){
                a.setReturndate(new Date());
                a.setIsreturn(isreturn);
                updateCount(a.getBook_id());
                break;
            }
        }
        return userBookRepository.findAll();
    }

    public void updateCount(int bookId){
        for(Book b:bookRepository.findAll()){
            if(b.getId()==bookId){
                b.setCount(b.getCount()+1);
                bookRepository.save(b);
            }
        }
    }
}
