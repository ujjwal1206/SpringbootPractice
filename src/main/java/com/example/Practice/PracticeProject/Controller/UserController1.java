package com.example.Practice.PracticeProject.Controller;

import com.example.Practice.PracticeProject.Model.User;
import com.example.Practice.PracticeProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController1 {
    //static List<UserModel> ll=new ArrayList<UserModel>();
    @Autowired
    private UserService userService;
    @PostMapping("/user/add/{id}")
    String addinguser(@PathVariable int id, @RequestParam String name,
                           @RequestParam String email){
        return userService.addinguser(id,name,email);
    }

    @GetMapping("/user/display/{index}")
    User DisplaydatabyIndex(@PathVariable int index){
        return userService.DisplaydatabyIndex(index);
    }
    @GetMapping("/user/display/all")
    List displaydata(){
        return userService.displaydata();
    }
    @PatchMapping("/user/updatename/{id}")
    List updateName(@PathVariable int id,@RequestParam String name){
        return userService.updateName(id,name);
    }
    @PutMapping("/user/updateall/{id}")
    List updatedList(@PathVariable int id,@RequestParam String name,@RequestParam String email){
        return userService.updatedList(id,name,email);
    }
    @DeleteMapping("/user/update/{id]")
    void deleteList(@PathVariable int id){
        userService.deleteList(id);
    }
}
