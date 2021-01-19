package com.lss.service;


import com.lss.pojo.entity.Condiment;

import java.util.List;

public interface CdmService {
    List<Condiment> selectAllCdm();
    boolean addCdm(Condiment condiment);
}
