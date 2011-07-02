package com.cms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.struts.ent.GrantHelper;
import com.cms.struts.ent.LoginHelper;
import com.cms.struts.ent.UserBean;

public class Login extends HttpServlet {

	
	/**
	 * Constructor of the object.
	 */
	public Login() {
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
		String name=request.getParameter("txtName");
		String pass=request.getParameter("pwPass");
		HttpSession se=request.getSession();
		LoginHelper lh=new LoginHelper();
		GrantHelper gh=new GrantHelper();
		UserBean ub=lh.checkLogin(name, pass);
		
		if(ub!=null)
		{
		System.out.println(ub.getUrealname());
		se.setAttribute("user",ub);
		List mods=gh.getModsByUserId(ub.getUid());
		System.out.println(mods.size());
		se.setAttribute("mods",mods);
		response.sendRedirect("tohomepage");
		//request.getRequestDispatcher("").forward(arg0, arg1);
		}else
		{
	    response.sendRedirect("main/errorGrant.jsp");	
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
