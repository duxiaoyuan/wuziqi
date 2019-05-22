package service.impl;

import mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Game;
import service.GameService;

public class GameServiceImpl implements GameService {

    @Autowired
    GameMapper gameMapper;

    @Override
    public Integer gameStart(Game game) {
        return gameMapper.gameStart(game);
    }

    @Override
    public Integer gameEnd(Game game) {
        return gameMapper.gameEnd(game);
    }
}
