package com.example.Practice.PracticeProject.Controller;

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
    @PostMapping("/add/{id}")
    public String add(@PathVariable int id, @RequestParam int UserId, @RequestParam int BookId){
    return userBookService.add(id,UserId,BookId,false,new Date(),null);
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
    public List updatestatus(@PathVariable int id,@RequestParam Date return_date){
        return userBookService.updateDate(id,return_date);
    }
}
