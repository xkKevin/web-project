package com.example.demo.controller;

import com.example.demo.po.Account;
import com.example.demo.po.Message;
import com.example.demo.po.Student;
import com.example.demo.po.Teacher;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tyr on 2018/5/16.
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("registerstu")
    @ResponseBody
    public Message insertStudent(@RequestParam String school, @RequestParam String stunum, @RequestParam String psw,
                                 @RequestParam String major,   @RequestParam String clazz,   @RequestParam String email){
        Student student = new Student();
        student.setSchool(school);
        student.setStuid(stunum);
        student.setPsw(psw);
        student.setEmail(email);
        student.setMajor(major);
        student.setClazz(clazz);
        Message message = new Message();
        if (testService.insert(student)){
            message.setCode(200);
            message.setMessage("注册成功");
        }else {
            message.setCode(103);
            message.setMessage("注册失败");
        }
        return message;
    }

    @PostMapping("registertea")
    @ResponseBody
    public Message insertTeacher(@RequestParam String school,@RequestParam String account,@RequestParam String psw,
                                 @RequestParam String email){
        Teacher teacher = new Teacher();
        teacher.setSchool(school);
        teacher.setPsw(psw);
        teacher.setEmail(email);
        teacher.setTeaid(account);
        Message message = new Message();

        if (testService.insert(teacher)){
            message.setCode(200);
            message.setMessage("注册成功");
        }else {
            message.setCode(103);
            message.setMessage("注册失败");
        }
        return message;
    }

    @GetMapping("login")
    @ResponseBody
    public Message login(@RequestParam(value = "name",required = false) String name,@RequestParam(value = "psw",required = false) String psw,
                         @RequestParam(value = "id",required = false) int id){
        Account account = new Account();
        account.setName(name);
        account.setPassword(psw);
        Message message = new Message();
        message.setCode(200);
        if (testService.login(account,id)){
            message.setMessage("登陆成功");
        }else {
            message.setMessage("登陆失败");
        }


        return message;
    }
}
