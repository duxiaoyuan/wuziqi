package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Game;
import pojo.Pieces;
import service.GameService;
import utils.Result;

@RestController("game")
public class GameController {

    @Autowired
    static GameService gameService;

    @RequestMapping("gameStart")
    public static Object gameStart(Game game){
        Integer code = gameService.gameStart(game);
        if (code>0){
            return Result.ok(game);
        }else {
            return Result.error("无法开始对局");
        }

    }

    @RequestMapping("moveInChess")
    public static Object moveInChess(Game game, Pieces pieces){
        game.getStep().add(pieces);
        return Result.ok(game);
    }

    @RequestMapping("takeBack")
    public static Object takeBack(Game game, Pieces pieces){
        game.getStep().add(pieces);
        return Result.ok(game);
    }

    @RequestMapping("gameEnd")
    public static Object gameEnd(Game game){
        Integer code = gameService.gameEnd(game);
        if (code>0){
            return Result.ok(game);
        }else {
            return Result.error("系统繁忙");
        }
    }

}
