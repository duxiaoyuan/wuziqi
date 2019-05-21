package controller;

import org.springframework.web.bind.annotation.RestController;
import utils.Result;

@RestController("game")
public class GameController {

    public static Object gameEnding(){

        return new Result();
    }

}
