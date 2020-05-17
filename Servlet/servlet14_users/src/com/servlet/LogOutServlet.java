package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.core.ServletBase;
@WebServlet("/logout")
public class LogOutServlet extends ServletBase {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		   HttpSession hs=req.getSession();
		   hs.invalidate();
		   resp.sendRedirect("index.html");

	}

}
