package com.dest.bankingapplication.models;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ChangePwdFilter")
public class ChangePwdFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String npwd = request.getParameter("npwd");
		String cpwd = request.getParameter("cpwd");
		if(npwd.equals(cpwd)) {
		chain.doFilter(request, response);
	}
		else {
			((HttpServletResponse) response).sendRedirect("/ChangePwdFail.html");
		}
	}
}
