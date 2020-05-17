package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Users;
import com.servlet.core.ServletBase;
@WebServlet("/admin/edit_page")
public class EditPageServlet extends ServletBase {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        req.setCharacterEncoding("utf-8");
        
        this.checkLoged(req, resp);
        
        Users user=(Users)req.getAttribute("edituser");
        if(null!=user)
        {
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("	<head>");
        out.println("		<meta charset='UTF-8'>");
        out.println("		<title></title>");
        out.println("		<link rel='stylesheet' href='../css/bootstrap.min.css' />");
        out.println("	</head>");
        out.println("	<body>");
        out.println("		<div style='width: 400px; margin: 50px auto;'>");
        out.println("<h1>修改用户信息</h1>");
        out.println("			<form action='saveEdit' method='post' >");
        out.println("<input type='hidden' name='id' value='"+user.getId()+"'/>");
        out.println("			  <div class='form-group'>");
        out.println("			    <label >用户名：</label>");
        out.println("			    <input type='text' name='uname' value='"+user.getUname()+"' class='form-control'  placeholder='请输入用户名'>");
        out.println("			  </div>");
        out.println("			  <div class='form-group'>");
        out.println("			    <label>密码</label>");
        out.println("<input type='hidden' name='upwd' value='"+user.getUpwd()+"'/>");
        out.println("			    <input type='text' name='newpwd'  class='form-control' placeholder='Password'>");
        out.println("			  </div>");
        
        out.println("			  <div class='form-group'>");
        out.println("			    <label >姓名：</label>");
        out.println("			    <input type='text' name='name' value='"+user.getName()+"' class='form-control'  placeholder='姓名'>");
        out.println("			  </div>");
        out.println("			   <div class='form-group'>");
        out.println("			    <label >性别：</label>");
        out.println("			    <input type='radio' value='M' name='sex' "+(user.getSex().equals("M")?"checked='checked'":"")+"/>男");
        out.println("			      <input type='radio' value='F' name='sex' "+(user.getSex().equals("F")?"checked='checked'":"")+"/>女");
        out.println("			  </div>");
        out.println("			  ");
        out.println("			  <button type='submit' class='btn btn-success'>修改</button>");
        
        out.println("</form>");
        out.println("		</div>");
        out.println("	</body>");
        out.println("</html>");
        }else
        {
        	out.println("<h1>user值没有传过来</h1>");
        }
        
        out.close();

	}

}
