package com.dest.bankingapplication.models;

import java.io.IOException;

import com.dest.bankingapplication.mains.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID =1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String custid = request.getParameter("custid");
		
		String saccno = request.getParameter("accno");//Collects the data in form of string
		int accno = Integer.parseInt(saccno);//Converts String data to int data
		
		String pwd = request.getParameter("pwd");
		
		String sbal = request.getParameter("bal");//Collects the data in form of string
		int bal = Integer.parseInt(sbal);//Converts String data to int data
		
		String email = request.getParameter("email");
		
		try {
			Model m = new Model();
			m.setName(name);
			m.setAccno(accno);
			m.setBal(bal);
			m.setCustid(custid);
			m.setEmail(email);
			m.setPwd(pwd);
			
			boolean b = m.register();
			if (b==true) {
				response.sendRedirect("/BankingApplication/SuccessReg.html");
				
				
			}else {
				response.sendRedirect("/BankingApplication/FailureReg.html");
				
			}
			
		}
		catch (Exception e) {		
	    e.printStackTrace();		
	    }
	}
}