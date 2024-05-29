//package jp.co.aforce.tool;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("*.action")
//public class FrontController extends HttpServlet {
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		try {
//			String path = request.getServletPath().substring(1); //jspとServletの名前が同じだと使える
//			String name = path.replace("jp.co.aforce.loginAction.LoginAction", "action").replace('/', '.');
//			Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();
//			String url = action.execute(request, response);
//			request.getRequestDispatcher(url).forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace(out);
//		}
//	}
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doPost(request, response);
//	}
//}
