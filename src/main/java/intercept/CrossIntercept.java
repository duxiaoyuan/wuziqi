package intercept;

import annotation.CrossOrigin;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: wuziqi
 * @description: intercept
 * @author: dgy
 * @create: 2019-05-25 22:57
 **/
public class CrossIntercept implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		CrossOrigin cross = inv.getController().getClass().getAnnotation(CrossOrigin.class);
		if (cross != null) {
			handler(inv.getController().getResponse());
			inv.invoke();
			return;
		}
		cross = inv.getMethod().getAnnotation(CrossOrigin.class);
		if (cross != null) {
			handler(inv.getController().getResponse());
			inv.invoke();
			return;
		}
		inv.invoke();
	}

	private void handler(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
	}

}
