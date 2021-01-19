package com.lss.service;


import com.lss.pojo.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> showAll();

    boolean SupplierAdd(Supplier supplier);
}
