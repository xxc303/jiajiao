package com.bysj.service.impl;

import com.bysj.dao.OrdersMapper;
import com.bysj.pojo.Orders;
import com.bysj.pojo.Teacher;
import com.bysj.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 123
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> queryAllOrders() {
        return ordersMapper.queryAllOrders();
    }

    @Override
    public Orders queryOrdersById(int id) {
        return ordersMapper.queryOrdersById(id);
    }

    @Override
    public List<Orders> queryOrdersByUserId(int userId) {
        return ordersMapper.queryOrdersByUserId(userId);
    }

    @Override
    public List<Orders> queryOrdersByTeacherId(int teacherId) {
        return ordersMapper.queryOrdersByTeacherId(teacherId);
    }

    @Override
    public int addOrders(Orders orders) {
        orders.setPubTime(new Date());
        return ordersMapper.addOrders(orders);
    }

    @Override
    public int updateOrders(Orders orders) {
        return ordersMapper.updateOrders(orders);
    }

    @Override
    public int deleteOrders(int id) {
        return ordersMapper.deleteOrders(id);
    }

    @Override
    public int changeStatus(int id, int status) {
        Orders orders = ordersMapper.queryOrdersById(id);
        orders.setStatus(status);
        return ordersMapper.updateOrders(orders);
    }

    @Override
    public int viewOrders(int id) {
        Orders orders = ordersMapper.queryOrdersById(id);
        orders.setCheckNum(orders.getCheckNum() + 1);
        return ordersMapper.updateOrders(orders);
    }

    @Override
    public int postOrders(int id, int teacher_id) {
        Orders orders = ordersMapper.queryOrdersById(id);
        orders.setStatus(1);
        Teacher teacher = new Teacher();
        teacher.setId(teacher_id);
        orders.setTeacher(teacher);
        return updateOrders(orders);
    }
}
