package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> userList=new ArrayList<User>();
    User user=new User();
    public String addinguser(int id, String name,String email){
        int flag=0;
        for(User u:userList){
            if(u.getEmail().equals(email)){
                flag=1;
            }
        }
        if(flag==0){
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            userList.add(user);
            return "ADDED SUCCESSFULLY";
        }
        else {
            return "OOPS!! WE CANNOT ADD DUPLICATES";
        }
    }
    public User DisplaydatabyIndex(int index){
        return userList.get(index);
    }
    public List displaydata(){
        return userList;
    }
    public List updateName(int id,String name){
        for(User u1:userList){
            if(u1.getId()==id){
                u1.setName(name);
            }

        }
        return userList;
    }
    public List updatedList(int id,String name,String email){

        user.setName(name);
        user.setEmail(email);
        userList.set(id,user);
        return userList;
    }
    public void deleteList(int id){
        userList.remove(id);
    }

}
