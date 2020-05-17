package com.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.core.DB;
import com.pojo.Users;
import com.servlet.core.ServletBase;
import com.utils.Md5Encrypt;
@WebServlet("/admin/saveEdit")
public class SaveEditServlet extends ServletBase {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");
		  this.checkLoged(req, resp);
		 try {
			Users user=new Users();
			 this.getBean(req, user);
			 
			 String newpwd=this.getString(req, "newpwd");
			 if(!"".equals(newpwd))
			 {
				 user.setUpwd(Md5Encrypt.md5(newpwd));
			 }
			 
			 
			 String sql="update users set uname=?,name=?,upwd=?,sex=? where id=?";
			 
			 DB.update(sql,user.getUname(),user.getName(),user.getUpwd(),user.getSex(),user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 resp.sendRedirect("show");

	}

}
