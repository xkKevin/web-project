package com.example.demo.service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.TeacherMapper;

import com.example.demo.po.*;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tyr on 2018/5/16.
 */
@Service
public class TestService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    public boolean insert(Teacher teacher){
        if (teacherMapper.insertSelective(teacher)==0){
            return false;
        }else {
            return true;
        }
    }

    public boolean insert(Student student){
        if (studentMapper.insertSelective(student)==0){
            return false;
        }else {
            return true;
        }
    }

    public boolean login(Account account,int id){
        if (id==0){
            StudentExample student = new StudentExample();
            StudentExample.Criteria criteria = student.createCriteria();
            criteria.andStuidEqualTo(account.getName());
            criteria.andPswEqualTo(account.getPassword());
            List<Student> students = studentMapper.selectByExample(student);
            System.out.println(students);
            if (students.size()==0){
                return false;
            }
            return true;
        }else {
            TeacherExample teacherExample = new TeacherExample();
            TeacherExample.Criteria criteria = teacherExample.createCriteria();
            System.out.println(account.getName());
            criteria.andTeaidEqualTo(account.getName());
            criteria.andPswEqualTo(account.getPassword());
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
            System.out.println(teachers);
            if (teachers.size()==0){
                return false;
            }
            return true;
        }
    }


}
