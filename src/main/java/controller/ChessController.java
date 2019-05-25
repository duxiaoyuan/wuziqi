package controller;

import com.jfinal.core.Controller;

/**
 * @program: wuziqi
 * @description: chessController
 * @author: dgy
 * @create: 2019-05-25 16:33
 **/
public class ChessController extends Controller {

	public void hello(){
		renderJson("hello");
	}

}
