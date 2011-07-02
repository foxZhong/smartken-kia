package com.cms.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.struts.ent.ModelBean;
import com.cms.struts.ent.PageConctrl;

public class ChangeFunction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ChangeFunction() {
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
		HttpSession se=request.getSession();
		String mod=request.getParameter("mod");
		String fun=request.getParameter("fun");
		ModelBean mb;
		List newmods=new ArrayList();
		List mods=(List) se.getAttribute("mods");
		Iterator it=mods.iterator();
		while(it.hasNext())
		{
			mb=(ModelBean)it.next();
			
			
			if(mb.getMname().equals(mod))
				{
				mb.setDisplay("block");
				//System.out.println(mb.getMname()+":"+mod);
				}
			else
				mb.setDisplay("none");
			newmods.add(mb);
		}
		se.setAttribute("mods", newmods);
		se.setAttribute("pc", new PageConctrl());
		response.sendRedirect(mod+"/"+fun);
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
