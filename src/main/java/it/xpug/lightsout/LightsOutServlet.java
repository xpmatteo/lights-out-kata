package it.xpug.lightsout;

import it.xpug.toolkit.html.*;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class LightsOutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LightsOutGame lightsOutGame = new LightsOutGame();
		Object state = lightsOutGame.state();

		TemplateView view = new TemplateView("index.ftl");
		view.put("answer", state);

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.write(view.toHtml());
		writer.close();
	}
}
