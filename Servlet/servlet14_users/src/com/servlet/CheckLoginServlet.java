package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.db.core.DB;
import com.pojo.Users;
import com.servlet.core.ServletBase;
import com.utils.Md5Encrypt;
@WebServlet("/checkLogin")
public class CheckLoginServlet extends ServletBase {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        req.setCharacterEncoding("utf-8");
	
      
      try {
    	  String uname=this.getString(req, "uname");
		  String upwd=this.getString(req, "upwd");
		  
		  Users user=DB.query("select * from users where uname=? and upwd=?", new BeanHandler<Users>(Users.class),uname,Md5Encrypt.md5(upwd));
		  if(null!=user&&user.getUname().equals(uname))
		  {
			  //成功
			  HttpSession hs=req.getSession();
			  hs.setAttribute("loged", user);
			  resp.sendRedirect("admin/show");
		  }else
		  {
			  //失败
			  out.println("<script>alert('用户名密码不正确');window.location='index.html';</script>");
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	}

}
