package utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result ok(Object obj){
        return new Result(200,"success",obj);
    }

    public static Result ok(Object obj , String msg){
        return new Result(200,msg,obj);
    }

    public static Result ok(String msg){
        return new Result(200,msg);
    }

    public static Result error(Object obj){
        return new Result(300,"false",obj);
    }

    public static Result error(Object obj , String msg){
        return new Result(300,msg,obj);
    }
    public static Result error(String msg){
        return new Result(300,msg);
    }

}
