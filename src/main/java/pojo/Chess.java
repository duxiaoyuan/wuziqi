package pojo;

import lombok.Data;
import pojo.collection.Pieces;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Chess {

    private Integer chess_id;
    private Date startTime;
    private Date endTimel;

    private Integer b_user_id;
    private Integer w_user_id;
    private ArrayList<Pieces> step;

}
