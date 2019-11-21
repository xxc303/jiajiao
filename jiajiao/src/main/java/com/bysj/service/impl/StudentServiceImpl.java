package com.bysj.service.impl;

import com.bysj.dao.StudentMapper;
import com.bysj.pojo.Student;
import com.bysj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 123
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAllStudent() {
        return studentMapper.queryAllStudent();
    }

    @Override
    public Student queryStudentById(int id) {
        return studentMapper.queryStudentById(id);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int deleteStudent(int id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public Student queryStudentByUsername(String username) {
        return studentMapper.queryStudentByUsername(username);
    }

    @Override
    public Student login(String username, String password) {
        Student student = studentMapper.queryStudentByUsername(username);
        if (student == null){
            return null;
        }
        if (!student.getPassword().equals(password)) {
            return null;
        }
        return student;
    }

    @Override
    public boolean changeStatus(int id, int status) {
        Student student = queryStudentById(id);
        student.setStatus(status);
        studentMapper.updateStudent(student);
        return true;
    }
}
