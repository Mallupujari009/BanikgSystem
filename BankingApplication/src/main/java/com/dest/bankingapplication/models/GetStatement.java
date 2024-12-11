package com.dest.bankingapplication.models;

import java.io.IOException;
import java.util.ArrayList;

import com.dest.bankingapplication.mains.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/GetStatement")
public class GetStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int)session.getAttribute("accno");
		try {
			Model m = new Model();
			m.setAccno(accno);
			ArrayList<Integer> al = m.getStatement();
			
			if( al.isEmpty()==true) {
				response.sendRedirect("/BankingApplication/StatementFail.html");
			}
			else {
				session.setAttribute("sal",m.sal);
				session.setAttribute("ral",m.ral);
				session.setAttribute("al",m.al);
				response.sendRedirect("/BankingApplication/StatementSuccess.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
