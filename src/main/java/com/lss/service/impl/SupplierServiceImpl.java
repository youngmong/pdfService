package com.lss.service.impl;

import com.lss.dao.SupplierDao;
import com.lss.pojo.entity.Supplier;
import com.lss.service.SupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Resource
    SupplierDao supplierDao;


    @Override
    public List<Supplier> showAll() {
        return supplierDao.selectAll();
    }

    @Override
    public boolean SupplierAdd(Supplier supplier) {
        int i = supplierDao.insertSelective(supplier);
        if(i == 1){
            return true;
        }
        return false;
    }
}
