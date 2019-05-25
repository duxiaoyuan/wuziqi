package flow.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Chess{

    private Integer chess_id;
    private Date startTime;
    private Date endTime;

    private Integer b_user_id;
    private Integer w_user_id;
    private String step;

}
