package config;


import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import flow.controller.ChessController;
import intercept.CrossIntercept;


/**
 * @program: wuziqi
 * @description: config
 * @author: dgy
 * @create: 2019-05-25 16:54
 **/
public class jConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants constants) {
		constants.setDevMode(true);
	}

	@Override
	public void configRoute(Routes routes) {
		routes.setBaseViewPath("/wuziqiPage");
		routes.add("/", ChessController.class);
	}

	@Override
	public void configEngine(Engine engine) {

	}

	@Override
	public void configPlugin(Plugins plugins) {
		DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost/wuziqi", "root", "root");
		plugins.add(dp);

		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		plugins.add(arp);
//		arp.addMapping("chess","chess_id", Chess.class);
	}

	@Override
	public void configInterceptor(Interceptors interceptors) {
		interceptors.add(new CrossIntercept());
	}

	@Override
	public void configHandler(Handlers handlers) {
		handlers.add()
	}
}

