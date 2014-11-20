package it.xpug.lightsout;

import it.xpug.toolkit.http.*;


public class Main {
	public static void main(String[] args) {
		ReusableJettyApp app = new ReusableJettyApp(LightsOutServlet.class);
		app.start(8080, "src/main/webapp");
	}
}
