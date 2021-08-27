package com.example.Practice.PracticeProject.Service;

import com.example.Practice.PracticeProject.Model.UserModel;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<UserModel> ll=new ArrayList<UserModel>();
    static UserModel model=new UserModel();
    static public void addinguser(int id, String name,
                           String email,String phone){
        model.setId(id);
        model.setName(name);
        model.setEmail(email);
        model.setPhone_Number(phone);
        ll.add(model);
    }
    static public UserModel DisplaydatabyIndex(int index){
        return ll.get(index);
    }
    static public List displaydata(){
        return ll;
    }
    static public List updateName(int id,String name){
        model.setName(name);
        ll.set(id,model);
        return ll;
    }
    static public List updatedList(int id,String name,String email,String phone){

        model.setName(name);
        model.setEmail(email);
        model.setPhone_Number(phone);
        ll.set(id,model);
        return ll;
    }
    static public void deleteList(int id){
        ll.remove(id);
    }

}
