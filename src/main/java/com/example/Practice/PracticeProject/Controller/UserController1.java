package com.example.Practice.PracticeProject.Controller;

import com.example.Practice.PracticeProject.Model.UserModel;
import com.example.Practice.PracticeProject.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service")
public class UserController1 {
    //static List<UserModel> ll=new ArrayList<UserModel>();
    static UserService Us=new UserService();
    @PostMapping("org/{id}")
    static void addinguser(@PathVariable int id, @RequestParam String name,
                           @RequestParam String email, @RequestParam String phone){
        Us.addinguser(id,name,email,phone);
    }

    @GetMapping("org/display/{index}")
    static UserModel DisplaydatabyIndex(@PathVariable int index){
        return Us.DisplaydatabyIndex(index);
    }
    @GetMapping("org/display/all")
    static List displaydata(){
        return Us.displaydata();
    }
    @PatchMapping("org/updatename/{id}")
    static List updateName(@PathVariable int id,@RequestParam String name){
        return Us.updateName(id,name);
    }
    @PutMapping("org/updateall/{id}")
    static List updatedList(@PathVariable int id,@RequestParam String name,@RequestParam String email,@RequestParam String phone){
        return Us.updatedList(id,name,email,phone);
    }
    @DeleteMapping("org/update/{id]")
    static void deleteList(@PathVariable int id){
        Us.deleteList(id);
    }
}
