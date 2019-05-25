package flow.pojo;

import com.jfinal.plugin.activerecord.Model;

public class Table extends Model<Table> {

    public static final Table dao = new Table();

    private Integer id;
    private Integer left_user_id;
    private Integer right_user_id;
    private boolean l_start;
    private boolean r_start;

}
