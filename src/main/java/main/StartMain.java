package main;

import com.jfinal.server.undertow.UndertowServer;
import config.jConfig;

public class StartMain {

	public static void main(String[] args) {
		UndertowServer.start(jConfig.class,8080,true);
	}
}
