package pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {

    private Integer id;
    private Integer left_user_id;
    private Integer right_user_id;
    private Integer winner_id;
    private List<String> message = new ArrayList<>();

}
