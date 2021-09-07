package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.User;
import com.example.Practice.PracticeProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String addinguser(User u){
            if(isemailavailable(u.getEmail()))
            {
                return "OOPS!! WE CANNOT ADD DUPLICATES";
            }
            userRepository.save(u);
            return "ADDED SUCCESSFULLY";
    }

    public boolean isemailavailable(String email){
        for(User u: userRepository.findAll()){
            if(u.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public User DisplaydatabyIndex(int index){
        return userRepository.findById(index).orElse(null);
    }

    public List displaydata(){
        return userRepository.findAll();
    }

    public List updateName(int id,String name){
        for(User u1: userRepository.findAll()){
            if(u1.getId()==id){
                u1.setName(name);
                u1.setEmail(u1.getEmail());
                u1.setId(u1.getId());
                userRepository.save(u1);
                break;
            }
        }
        return userRepository.findAll();
    }

    public String updatedList(User u){
        User user=new User();
        if(isemailavailable(u.getEmail())) {
            user.setId(u.getId());
            user.setName(u.getName());
            user.setEmail(u.getEmail());
            userRepository.save(user);
            return "List Updated";
        }
        return "List Not Updated Because Email Id is Already Present";
    }

    public void deleteList(int id){
        userRepository.deleteById(id);
    }

}
