package annotation;

import java.lang.annotation.*;

/**
 * @program: wuziqi
 * @description: CrossOrigin
 * @author: dgy
 * @create: 2019-05-25 22:55
 **/
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CrossOrigin {
}
