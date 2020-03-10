package com.bdu.jiajiao.service.impl;

import com.bdu.jiajiao.mapper.TeacherMapper;
import com.bdu.jiajiao.pojo.Teacher;
import com.bdu.jiajiao.service.TeacherService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 123
 * @create 2020/1/13
 * @since 1.0.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> queryAllTeacher(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> teacherList = teacherMapper.queryAllTeacher();
        return teacherList;
    }

    @Override
    public Teacher login(String username, String password) {
        Teacher login = teacherMapper.login(username, password);
        return login;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public Teacher findByToken(String token) {
        return teacherMapper.findByToken(token);
    }

    @Override
    public Teacher findById(int id) {
        return teacherMapper.queryTeacherById(id);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public List<Teacher> search(String param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> teacherList = teacherMapper.search(param);
        return teacherList;
    }

    @Override
    public int delete(int id) {
        return teacherMapper.delete(id);
    }
}
