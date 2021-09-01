package com.example.Practice.PracticeProject.Repository;

import com.example.Practice.PracticeProject.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static List<User> userList=new ArrayList<User>();
    public static void set(User u){
        userList.add(u);
    }
    public static User findbyid(int id){
        return userList.get(id);
    }
    public static List findall(){
        return userList;
    }
    public static List updatename(){
        return userList;
    }
    public static List update(int id,User user){

        userList.set(id,user);
        return userList;
    }
    public static List remove(int id){
        userList.remove(id);
        return userList;
    }
}
