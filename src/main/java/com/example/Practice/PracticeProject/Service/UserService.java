package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.User;
import com.example.Practice.PracticeProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    //List<User> userList=new ArrayList<User>();
    public String addinguser(int id, String name,String email){
        User user=new User();
            if(isemailavailable(email)){
                return "OOPS!! WE CANNOT ADD DUPLICATES";
            }
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            UserRepository.set(user);
            return "ADDED SUCCESSFULLY";
    }
    public boolean isemailavailable(String email){
        for(User u: UserRepository.userList){
            if(u.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    public User DisplaydatabyIndex(int index){
        return UserRepository.findbyid(index);
    }
    public List displaydata(){
        return UserRepository.findall();
    }
    public List updateName(int id,String name){
        for(User u1:UserRepository.userList){
            if(u1.getId()==id){
                u1.setName(name);
                break;
            }

        }
        return UserRepository.updatename();
    }
    public List updatedList(int id,String name,String email){
        User user=new User();
        user.setName(name);
        user.setEmail(email);

        return UserRepository.update(id,user);
    }
    public void deleteList(int id){
        UserRepository.remove(id);
    }

}
