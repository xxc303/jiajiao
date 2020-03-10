package com.bdu.jiajiao.controller;

import com.bdu.jiajiao.pojo.Admin;
import com.bdu.jiajiao.pojo.Student;
import com.bdu.jiajiao.pojo.Teacher;
import com.bdu.jiajiao.service.AdminService;
import com.bdu.jiajiao.service.StudentService;
import com.bdu.jiajiao.service.TeacherService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @author 123
 * @create 2019/11/23
 * @since 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    /**
     * 学员删除
     */
    @DeleteMapping("deleteStu/{id}")
    public String deleteStu(Model model, @PathVariable("id")int id){
        studentService.delete(id);
        model.addAttribute("type", "admin");
        return "/admin/teacherInfo";
    }

    /**
     * 教师删除
     */
    @DeleteMapping("/deleteTea/{id}")
    public String deleteTea(Model model,@PathVariable("id")int id){
        teacherService.delete(id);
        model.addAttribute("type", "admin");
        return "/admin/studentInfo";
    }

    /**
     * 家教信息
     */
    @RequestMapping("/teacherInfo")
    public String teacherInfo(Model model,
                              @RequestParam(defaultValue = "1") int pageNum,
                              @RequestParam(defaultValue = "1") int pageSize) {
        List<Teacher> teachers = teacherService.queryAllTeacher(pageNum, pageSize);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("type", "admin");
        return "/admin/teacherInfo";
    }

    /**
     * 学生信息
     */
    @RequestMapping("/studentInfo")
    public String studentInfo(Model model,
                              @RequestParam(defaultValue = "1") int pageNum,
                              @RequestParam(defaultValue = "1") int pageSize) {
        List<Student> students = studentService.queryAllStudent(pageNum, pageSize);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("type", "admin");
        return "/admin/studentInfo";
    }

    /**
     * 登录
     */
    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session, Model model) {
        model.addAttribute("title", "管理员");
        model.addAttribute("type", "admin");
        return "login";
    }

    @RequestMapping("login")
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response,
                        HttpServletRequest request,
                        RedirectAttributes modelMap,
                        Model model) {
        Admin admin = adminService.login(username, password);
        if (admin == null) {
            modelMap.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/admin/toLogin";
        } else {
            String token = UUID.randomUUID().toString();
            admin.setToken(token);
            adminService.updateAdmin(admin);
            Cookie cookie = new Cookie("token-admin", token);
            response.addCookie(cookie);
            request.getSession().setAttribute("admin", admin);
            modelMap.addFlashAttribute("type", "admin");
            return "redirect:/admin/dashBoard";
        }
    }

    @GetMapping("/dashBoard")
    public String dashBoard(HttpServletRequest request, Model model) {
        Object admin = request.getSession().getAttribute("admin");
        if (admin != null) {
            model.addAttribute("type", "admin");
            model.addAttribute("admin", admin);
        }
        return "/dashboard";
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("admin");
        Cookie cookie = new Cookie("token-admin", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
