package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.db.core.DB;
import com.pojo.Users;
import com.servlet.core.ServletBase;
@WebServlet("/admin/show")
public class ShowServlet extends ServletBase {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        req.setCharacterEncoding("utf-8");
        this.checkLoged(req, resp);
        
        HttpSession hs=req.getSession();
        Users user=(Users)hs.getAttribute("loged");
        
        if(null==user) {
        	resp.sendRedirect("../index.html");
        	return ;
        }
		
        int pageSize=10;//第页几条
        int pageNo=1;   //第几页
        if(this.getInt(req, "pageNo")>1)pageNo=this.getInt(req, "pageNo");
        
        
        //-----------------------------------
        try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("		<meta charset='UTF-8'>");
			out.println("		<title>用户管理</title>");
			out.println("		<link rel='stylesheet' href='../css/bootstrap.min.css' />");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<div class='container' style='margin-top: 50px;'>");
			out.println("");
			out.println("<div class='panel panel-info'>");
			out.println("  <div class='panel-heading'>");
			out.println("    <h3 class='panel-title'>用户管理   <span class='pull-right'>你好，"+user.getName()+"&nbsp;&nbsp;<a href='../logout' class='btn btn-xs btn-danger'>退出</a></span></h3>");
			out.println("  </div>");
			out.println("  <div class='panel-body'>");
			out.println("   <!--");
			out.println("   	作者：org.eclipse.osgi.internal.baseadaptor.StateManager@c4db4b");
			out.println("   	时间：2019-02-25");
			out.println("   	描述：表格开始");
			out.println("   -->");
			out.println("   <table class='table table-hover table-striped table-responsive'>");
			out.println("   	  <tr><th>ID</th><th>用户名</th><th>姓名</th><th>性别</th><th>管理</th></tr>");
			
    
				String sql="select * from users order by id desc limit ?,?";
				List<Users> all=DB.query(sql, new BeanListHandler<Users>(Users.class),(pageNo-1)*pageSize,pageSize);
				
				Object obj=DB.query("select count(id) from users", new ArrayHandler())[0];
				long total=0;//总条数
				if(obj instanceof Long)
				{
					total=(Long)obj;
					System.out.println("long..........");
				}else if(obj instanceof BigInteger)
				{
					total=((BigInteger)obj).longValue();
					System.out.println("BigInteger..........");
				}
				
				long totalPage=(total+pageSize-1)/pageSize;
				
				if(null!=all&&all.size()>0)
				{
					int index=1;
				   for(Users u:all)
				   {
					   out.println("<tr><td>"+(index++)+"</td><td>"+u.getUname()+"</td><td>"+u.getName()+"</td><td>"+(u.getSex().equals("M")?"男":"女")+"</td><td>"
						+ "<a href='edit?id="+u.getId()+"' class='btn btn-xs btn-info'>修改</a>&nbsp;"
						+ "<a href='del?id="+u.getId()+"' class='btn btn-xs btn-danger'>删除</a></td></tr>");
				   }
				}
    
			
			out.println("");
			out.println("   </table>");
			out.println("   <nav>");
			out.println("  <ul class='pagination'>");
			out.println("    <li>");
			
			if(pageNo-1<1)
			    out.println("      <a href='show?pageNo=1' aria-label='Previous'>");
			else
				 out.println("      <a href='show?pageNo="+(pageNo-1)+"' aria-label='Previous'>");
			
			out.println("        <span aria-hidden='true'>&laquo;</span>");
			out.println("      </a>");
			out.println("    </li>");
			
			int indexCounter=3;//显示5个页码
			
			int start=(pageNo-indexCounter/2)<=1?1:(pageNo-indexCounter/2);
			long end=(pageNo+indexCounter/2)>=totalPage?totalPage:(pageNo+indexCounter/2);
			for(long index=start;index<=end;index++)
			out.println("    <li><a href='show?pageNo="+index+"'>"+index+"</a></li>");
		
			out.println("    <li>");
			
			if(pageNo+1>totalPage)
				 out.println("      <a href='show?pageNo="+totalPage+"' aria-label='Next'>");
			else
				 out.println("      <a href='show?pageNo="+(pageNo+1)+"' aria-label='Next'>");
			
			out.println("        <span aria-hidden='true'>&raquo;</span>");
			out.println("      </a>");
			out.println("    </li>");
			out.println("  </ul>");
			out.println("</nav>");
			
			out.println("<span>"+pageNo+"/"+totalPage+"页,总共"+total+"条</span>");
			out.println("   <!--");
			out.println("   	作者：org.eclipse.osgi.internal.baseadaptor.StateManager@c4db4b");
			out.println("   	时间：2019-02-25");
			out.println("   	描述：表格结束");
			out.println("   -->");
			out.println("  </div>");
			out.println("</div>");
			out.println("		</div>");
			out.println("	</body>");
			out.println("</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        out.close();

	}

}
