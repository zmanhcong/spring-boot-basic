package com.example.demo.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students")
public class StudentController {
    @GetMapping("new")
    public String newForm(){
        return "students/new";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(){
        return "students/edit";
    }

    @RequestMapping("list")
    public String list(){
        return "students/list";
    }

    @RequestMapping ("search")
    public String search(){
        return "students/search";
    }
    
}
