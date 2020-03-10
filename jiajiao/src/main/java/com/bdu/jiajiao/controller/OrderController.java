//package com.bdu.jiajiao.controller;
//
//import com.bdu.jiajiao.dto.OrderDTO;
//import com.bdu.jiajiao.dto.ResultDTO;
//import com.bdu.jiajiao.mapper.OrderMapper;
//import com.bdu.jiajiao.pojo.Order;
//import com.bdu.jiajiao.pojo.Student;
//import com.bdu.jiajiao.pojo.Teacher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//
///**
// * @author 123
// * @create 2020/3/9
// * @since 1.0.0
// */
//@Controller
//public class OrderController {
//
//    @Autowired
//    private OrderMapper orderMapper;
//
//    @Autowired
//    private
//
//    @ResponseBody
//    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
//    public Object reserve(@RequestBody int id,
//                          HttpServletRequest request){
//
//        Student student = (Student) request.getSession().getAttribute("student");
//        Teacher teacher= (Teacher) request.getSession().getAttribute("teacher");
//        if (student == null && teacher == null){
//            return ResultDTO.errorOf(500,"请登录");
//        }
//        Order order = new Order();
//        order.setTeaName(orderDTO.getTeaName());
//        order.setTeaPhone(orderDTO.getTeaPhone());
//        order.setStuName(student.getUsername());
//        order.setStuPhone(student.getPhone());
//        order.setItem(student.getItem());
//        order.setAddress(student.getAddress());
//        order.setPrice(student.getPrice());
//        order.setCreateTime(new Date());
//        orderMapper.addOrder(order);
//        return ResultDTO.okOf();
//    }
//
//}
