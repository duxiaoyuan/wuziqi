package com.wzq.flow.controller;

import com.wzq.flow.pojo.Chess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wzq.flow.service.ChessService;
import com.wzq.utils.Result;

/**
 * @program: wuziqi
 * @description: chessController
 * @author: dgy
 * @create: 2019-05-25 16:33
 **/

@RestController()
@RequestMapping("/chess")
public class ChessController {

	@Autowired
	ChessService chessService;

	@RequestMapping("/hello")
	public Object hello(){
		return Result.ok("启动成功");
	}

	@RequestMapping("moveInChess")
	public Object moveInChess(Chess chess){
		System.out.println("chess=>"+chess);
//		System.out.println(pieces);
		return Result.ok(chess);
	}

}
