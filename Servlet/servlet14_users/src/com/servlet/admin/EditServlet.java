package com.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.db.core.DB;
import com.pojo.Users;
import com.servlet.core.ServletBase;
@WebServlet("/admin/edit")
public class EditServlet extends ServletBase {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  this.checkLoged(req, resp);
       try {
		    int id=this.getInt(req, "id");
		  
		   Users edituser=DB.query("select * from users where id=?", new BeanHandler<Users>(Users.class),id);
		   
		   req.setAttribute("edituser", edituser);
		   
		   req.getRequestDispatcher("edit_page").forward(req, resp);
		   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
