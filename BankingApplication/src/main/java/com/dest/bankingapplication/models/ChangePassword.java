package com.dest.bankingapplication.models;

import java.io.IOException;

import com.dest.bankingapplication.mains.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("npwd");
		HttpSession session = request.getSession();
		
		int accno = (int) session.getAttribute("accno");
		
		try {
			Model m =new Model();
			m.setAccno(accno);
			m.setPwd(pwd);
			
			boolean b =m.changePwd();
			if(b == true) {
				response.sendRedirect("/BankingApplication/ChangePwdSuccess.html");
			}else {
				response.sendRedirect("/BankingApplication/ChangePwdFail.html");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
















