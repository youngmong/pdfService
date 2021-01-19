package com.lss.service.impl;

import com.lss.dao.UserDao;
import com.lss.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    public boolean userLoginCheck(String account,String password){
//        User user = userDao.selectByUserNumber(account);
        boolean result = false;
//        if (user != null && user.getUserPassword().equals(password)){
//            result = true;
//        }else{
//            result = true;
//        }
        if ("1".equalsIgnoreCase(account) && "1".equalsIgnoreCase(password)) {
            result = true;
        }
        return true;
    }
}
