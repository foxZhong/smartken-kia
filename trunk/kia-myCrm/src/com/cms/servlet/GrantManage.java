package com.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.cms.struts.ent.GrantHelper;
import com.cms.struts.ent.UserBean;

public class GrantManage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GrantManage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String[] grants=request.getParameterValues("grants");
		String url=request.getParameter("url");
		StringBuffer sb=new StringBuffer();
		if(grants!=null)
		{
			for(int i=0;i<grants.length;i++)
			sb.append(grants[i]+"/");
		}else
		sb.append("");
		
		GrantHelper gh=new GrantHelper();
		int id;
		 System.out.println("修改权限");
		if(request.getParameter("roleId")!=null)
		{
			id=Integer.parseInt(request.getParameter("roleId"));
		    int re=gh.updateRoleGrant(id, sb.toString());
		    System.out.println("修改角色权限"+id+":"+sb);
		    System.out.println(re==0?"失败":"成功");	    
		}
		if(request.getParameter("uId")!=null)
		{
			id=Integer.parseInt(request.getParameter("uId"));
		    int re=gh.updateUserGrant(id, sb.toString());
		    System.out.println("修改用户权限"+id+":"+sb);
		    System.out.println(re==0?"失败":"成功");
		}
		response.sendRedirect(url);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
