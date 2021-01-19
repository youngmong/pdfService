package com.lss.service.impl;

import com.lss.dao.DishDao;
import com.lss.pojo.entity.Dish;
import com.lss.service.DishService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Resource
    DishDao dishDao;

    @Override
    public List<Dish> showAllDishes() {
         List<Dish> dishList =  dishDao.selectAll();

         return dishList;
    }
}
