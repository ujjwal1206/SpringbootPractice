package com.example.Practice.PracticeProject.Controller;

import com.example.Practice.PracticeProject.Model.UserBookMapping;
import com.example.Practice.PracticeProject.Service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user/book")
public class UserBookController {
    @Autowired
    UserBookService userBookService;
    @PostMapping("/add")
    public String add(@RequestBody UserBookMapping ubm){
    return userBookService.add(ubm);
    }
    @GetMapping("/display/all")
    public List display(){
        return userBookService.display();
    }
    @DeleteMapping("/delete/{id}")
    public List delete(@PathVariable int id){
        return userBookService.delete(id);
    }
    @PatchMapping("/updatestatus/{id}")
    public List updatestatus(@PathVariable int id,@RequestParam boolean isreturn){
        return userBookService.updateReturn(id,isreturn);
    }
}
