package com.example.Practice.PracticeProject.Repository;

import com.example.Practice.PracticeProject.Model.UserBookMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBookRepository {
    public static List<UserBookMapping> userBookMappingList=new ArrayList<>();
    public static void set(UserBookMapping ubm){
        userBookMappingList.add(ubm);
    }
    public static List findall(){
        return userBookMappingList;
    }
    public static List delete(int id){
        userBookMappingList.remove(id);
        return userBookMappingList;
    }
    public static List updateDate(int id, Date date){
        for(UserBookMapping a:userBookMappingList){
            if(a.getBook_id()==id){
                a.setReturndate(date);
                a.setIsreturn(false);
            }
        }
        return userBookMappingList;
    }
}
