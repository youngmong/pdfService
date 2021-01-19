package com.lss.service.impl;

import com.lss.dao.CondimentDao;
import com.lss.pojo.entity.Condiment;
import com.lss.service.CdmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CdmServiceImpl implements CdmService {

    @Resource
    CondimentDao condimentDao;

    @Override
    public List<Condiment> selectAllCdm() {
        return condimentDao.showAll();
    }

    @Override
    public boolean addCdm(Condiment condiment) {
        if(condimentDao.insertSelective(condiment) == 1){
            return true;
        }
        return false;
    }
}
