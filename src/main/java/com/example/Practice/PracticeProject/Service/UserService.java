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
    public String addinguser(User u){
        User user=new User();
            if(isemailavailable(u.getEmail()))
            {
                return "OOPS!! WE CANNOT ADD DUPLICATES";
            }
            user.setId(u.getId());
            user.setName(u.getName());
            user.setEmail(u.getEmail());
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
    public List updatedList(User u){
        User user=new User();
        user.setName(u.getName());
        user.setEmail(u.getEmail());

        return UserRepository.update(u.getId(),user);
    }
    public void deleteList(int id){
        UserRepository.remove(id);
    }

}
