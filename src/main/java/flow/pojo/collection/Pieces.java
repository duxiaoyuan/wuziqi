package flow.pojo.collection;

import com.jfinal.plugin.activerecord.Model;
import lombok.Data;

@Data
public class Pieces extends Model<Pieces> {

    public static final Pieces dao = new Pieces();

    private Integer x;
    private Integer y;
    private boolean isWhite;

}
