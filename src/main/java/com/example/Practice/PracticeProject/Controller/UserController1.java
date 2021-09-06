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
    @PostMapping("/user/add")
    String addinguser(@RequestBody User u){
        return userService.addinguser(u);
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
    List updatedList(@RequestBody User u){
        return userService.updatedList(u);
    }
    @DeleteMapping("/user/update/{id]")
    void deleteList(@PathVariable int id){
        userService.deleteList(id);
    }
}
