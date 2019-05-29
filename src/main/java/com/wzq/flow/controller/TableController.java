package com.wzq.flow.controller;

import com.wzq.flow.pojo.Table;
import com.wzq.flow.pojo.User;
import com.wzq.flow.service.TableService;
import com.wzq.flow.service.UserService;
import com.wzq.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: wuziqi
 * @description: table
 * @author: dgy
 * @create: 2019-05-25 21:43
 **/
@RestController()
@RequestMapping("/chess")
public class TableController {

    @Autowired
    TableService tableService;
    @Autowired
    UserService userService;

    public Object startGame(Integer tableId,Integer userId){
        Table table = tableService.findById(tableId);
        User user = userService.findById(userId);
        return Result.ok(table,"");
    }

}
