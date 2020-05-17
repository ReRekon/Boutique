package com.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.core.DB;
import com.servlet.core.ServletBase;
@WebServlet("/admin/del")
public class DelServlet extends ServletBase {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

          this.checkLoged(req, resp);
		  try {
			int id=this.getInt(req, "id");
			  DB.update("delete from users where id=?",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  resp.sendRedirect("show");

	}

}
