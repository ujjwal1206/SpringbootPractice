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
    UserBookMapping userBookMapping=new UserBookMapping();
    public String add(int id, int Userid, int Bookid,boolean isreturn,Date issue_date,Date return_date){
        int a=0;
        if(isavailable(Userid,Bookid)){
            userBookMapping.setId(id);
            userBookMapping.setUser_id(Userid);
            userBookMapping.setBook_id(Bookid);
            userBookMapping.setIssuedate(issue_date);
            if(return_date!=null)
                userBookMapping.setReturndate(new Date());
            if(return_date==null)
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
        int ba=0;
        int count = 0;
    for(User u: UserRepository.userList){
        if(u.getId()==Userid){
            ua=1;
            break;
        }
    }
    for(Book b: BookRepository.bookList){
        if(b.getId()==Bookid) {
            if (b.getCount()> 0) {
                ba = 1;
                count=b.getCount();
                break;
            }
        }
    }
    if(ua==1&&ba==1){
        count--;
        return true;
    }
    return false;
    }
    public List display(){
        return UserBookRepository.findall();
    }
    public List delete(int id){
        return UserBookRepository.delete(id);
    }
    public List updateDate(int id,Date date){
        return UserBookRepository.updateDate(id,date);
    }
}