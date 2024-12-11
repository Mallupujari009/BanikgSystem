package com.dest.bankingapplication.models;

import java.io.IOException;

import com.dest.bankingapplication.mains.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custid = request.getParameter("custid");
		String pwd = request.getParameter("pwd");
		session =request.getSession(true);
		try {
			Model m = new Model();
			m.setCustid(custid);
			m.setPwd(pwd);

			boolean b = m.login();
			if(b==true) {
				session.setAttribute("accno",m.getAccno());
				response.sendRedirect("/BankingApplication/Home.html");
			}
			else {
				response.sendRedirect("/BankingApplication/Error.html");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
