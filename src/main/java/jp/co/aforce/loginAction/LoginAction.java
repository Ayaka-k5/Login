package jp.co.aforce.loginAction;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.Customer;
import jp.co.aforce.dao.CustomerDAO;

@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			CustomerDAO dao = new CustomerDAO();
			Customer customer = dao.search(username, password);
			
			if (customer != null) {
				session.setAttribute("customer", customer);
				request.getRequestDispatcher("/jsp/login-in.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/login-out.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

			request.getRequestDispatcher("/jsp/login-error.jsp").forward(request, response);
		}
	}
}