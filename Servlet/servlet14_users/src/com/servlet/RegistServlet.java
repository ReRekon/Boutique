package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.core.DB;
import com.pojo.Users;
import com.servlet.core.ServletBase;
import com.utils.Md5Encrypt;
@WebServlet("/register")
public class RegistServlet extends ServletBase {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
        
		resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        req.setCharacterEncoding("utf-8");
		
		
		try {
			if(this.getString(req, "upwd").equals(this.getString(req,"repwd")))
			{
				   Users u=new Users();
			       this.getBean(req,u);
			       /* u.setAge(req.getParameter("age"));
				   u.setName(this.getString(req, "name"));*/
			       u.setIp(req.getRemoteAddr());
			       u.setUpwd(Md5Encrypt.md5(u.getUpwd()));
			      
			       DB.update("insert into users(uname,upwd,name,sex,age,ip) values(?,?,?,?,?,?)", u.getUname(),u.getUpwd(),u.getName(),u.getSex(),u.getAge(),u.getIp());
			       out.println("<h1>注册成功!</h1><center><a href='index.html'>返回</a></center>");
			}else{
				 	out.println("<h1>两次密码不一致!</h1><center><a href='index.html'>返回</a></center>");
				
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		    }
	}

}
