package com.dest.bankingapplication.models;

import java.io.IOException;

import com.dest.bankingapplication.mains.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		String samt = request.getParameter("amt");
	    int amt = Integer.parseInt(samt);
	    
	    String sraccno = request.getParameter("raccno");
	    int raccno = Integer.parseInt(sraccno);
	
	try {
		Model m = new Model();
		m.setAccno(accno);
		m.setRaccno(raccno);
		m.setBal(amt);
		
		boolean b =m.transfer();
		if(b==true) {
			response.sendRedirect("/BankingApplication/TransferSuccess.html");
		}
		else {
			response.sendRedirect("/BankingApplication/TransferFail.html");
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
