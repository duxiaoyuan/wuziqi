package flow.controller;

import annotation.CrossOrigin;
import com.jfinal.core.Controller;
import flow.pojo.collection.Pieces;
import utils.Result;

/**
 * @program: wuziqi
 * @description: chessController
 * @author: dgy
 * @create: 2019-05-25 16:33
 **/
@CrossOrigin
public class ChessController extends Controller {

	public void hello(){
		render("board.html");
	}

	public void moveInChess(){
		getResponse().addHeader("Access-Control-Allow-Origin", "*");
		String chess = get("chess");
		Pieces pieces = getBean(Pieces.class);
		System.out.println("chess=>"+chess);
//		System.out.println(pieces);
		renderJson(Result.ok("ok"));
	}

}
