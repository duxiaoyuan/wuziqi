package pojo;

import lombok.Data;

@Data
public class Pieces {

    private Integer id;
    private String color;
    private Integer x_axis;
    private Integer y_axis;
    private String message;
    private boolean able;

    private Integer user_id;

}
