package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.Book;
import com.example.Practice.PracticeProject.Model.User;
import com.example.Practice.PracticeProject.Model.UserBookMapping;
import com.example.Practice.PracticeProject.Repository.BookRepository;
import com.example.Practice.PracticeProject.Repository.UserBookRepository;
import com.example.Practice.PracticeProject.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserBookService {

    public String add(UserBookMapping usb1){
        UserBookMapping userBookMapping=new UserBookMapping();
        int a=0;
        if(isavailable(usb1.getUser_id(), usb1.getBook_id())){
            userBookMapping.setId(usb1.getId());
            userBookMapping.setUser_id(usb1.getUser_id());
            userBookMapping.setBook_id(usb1.getBook_id());
            userBookMapping.setIssuedate(usb1.getIssuedate());
            if(usb1.getReturndate()!=null)
                userBookMapping.setReturndate(new Date());
            if(usb1.getReturndate()==null)
                userBookMapping.setIsreturn(false);
            else
                userBookMapping.setIsreturn(true);
            UserBookRepository.set(userBookMapping);
            return "ADDED SUCCESFULLY";
        }
        return "ERROR IN ADDING DATA";

    }
    public boolean isavailable(int Userid,int Bookid){
        int ua=0;
    for(User u: UserRepository.userList){
        if(u.getId()==Userid){
            ua=1;
            break;
        }
    }
    if(ua==1) {
        for (Book b : BookRepository.bookList) {
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
        return UserBookRepository.findall();
    }
    public List delete(int id){
        return UserBookRepository.delete(id);
    }
    public List updateReturn(int id,boolean isreturn){
        return UserBookRepository.updateReturn(id,isreturn);
    }
}
