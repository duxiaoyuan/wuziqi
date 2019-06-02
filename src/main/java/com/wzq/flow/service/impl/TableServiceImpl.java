package com.wzq.flow.service.impl;

import com.wzq.flow.dao.TableRepository;
import com.wzq.flow.pojo.Table;
import com.wzq.flow.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    TableRepository dao;

    @Override
    public Table findById(Integer tableId) {
        return dao.findOne(tableId);
    }
}
