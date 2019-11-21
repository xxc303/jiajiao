package com.bysj.service.impl;

import com.bysj.dao.TeacherMapper;
import com.bysj.pojo.Teacher;
import com.bysj.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 123
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> queryAllTeacher() {
        return teacherMapper.queryAllTeacher();
    }

    @Override
    public Teacher queryTeacherById(int id) {
        return teacherMapper.queryTeacherById(id);
    }

    @Override
    public Teacher queryTeacherByUsername(String username) {
        return teacherMapper.queryTeacherByUsername(username);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacher(int id) {
        return teacherMapper.deleteTeacher(id);
    }

    @Override
    public List<Teacher> queryTeacherByStatus(int status) {
        return teacherMapper.queryTeacherByStatus(status);
    }

    @Override
    public Teacher login(String username, String password) {
        Teacher teacher = teacherMapper.queryTeacherByUsername(username);
        if (teacher == null){
            return null;
        }
        if (!teacher.getPassword().equals(password)) {
            return null;
        }
        return teacher;

    }

    @Override
    public boolean changeStatus(int id, int status) {
        Teacher teacher = queryTeacherById(id);
        teacher.setStatus(status);
        teacherMapper.updateTeacher(teacher);
        return true;
    }
}
