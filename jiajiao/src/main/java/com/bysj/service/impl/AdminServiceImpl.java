package com.bysj.service.impl;

import com.bysj.dao.AdminMapper;
import com.bysj.pojo.Admin;
import com.bysj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 123
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> queryAllAdmin() {
        return adminMapper.queryAllAdmin();
    }

    @Override
    public Admin queryAdminById(int id) {
        return adminMapper.queryAdminById(id);
    }

    @Override
    public Admin queryAdminByUsername(String admin) {
        return adminMapper.queryAdminByUsername(admin);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public int deleteAdmin(int id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public Admin login(String username,String password) {
        Admin admin = adminMapper.queryAdminByUsername(username);
        if (admin == null){
            return null;
        }
        if (!admin.getPassword().equals(password)) {
            return null;
        }
        return admin;
    }
}
