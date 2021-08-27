package com.example.Practice.PracticeProject.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//crud operation on list
@RequestMapping("/users")
public class UserController {
    static List ll=new ArrayList();
    //String name;
    @PostMapping("/org")
    static void add_data(@RequestParam String name){
        ll.add(name);
        System.out.println("Added");
    }
    @PutMapping("/update/{id}")
    static List Update_List(@RequestParam String name,@PathVariable int id){
        ll.set(id,name);
        return ll;
    }
    @DeleteMapping("/remove")
    static void DeleteByname(@RequestParam String name){
        ll.remove(name);
    }
    @DeleteMapping("/remove/{id}")
    static void DeleteById(@PathVariable int id){
        ll.remove(id);
    }

    @GetMapping("/{id}")
    static String get_data(@PathVariable int id){
        return (ll.get(id)).toString();
    }
    @GetMapping("/all")
    static List viewfulllist(){
        return ll;
    }
}
