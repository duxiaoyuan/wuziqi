package com.wzq.flow.service.impl;

import com.wzq.flow.dao.ChessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wzq.flow.service.ChessService;

@Service
public class ChessServiceImpl implements ChessService {

    @Autowired
    ChessRepository dao;

}
