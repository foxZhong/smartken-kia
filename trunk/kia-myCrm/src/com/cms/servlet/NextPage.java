package com.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.struts.ent.PageConctrl;

public class NextPage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NextPage() {
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

		response.setContentType("text/html");
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
		int step=Integer.parseInt(request.getParameter("step"));
		//int jumpPage=Integer.parseInt(request.getParameter("jumpPage"));
		int maxItems=Integer.parseInt(request.getParameter("maxItems"));
		int pages=Integer.parseInt(request.getParameter("pages"));
		String url=request.getParameter("url");
		System.out.println("step:"+step+"\nurl"+url);
		HttpSession se=request.getSession();
		PageConctrl pc=(PageConctrl)se.getAttribute("pc");
		if(step==0);
		else if(step==-2)
		{
			if(pc.getCurPage()>1)
				pc.setCurPage(pc.getCurPage()-1);
		}
		
		else if(step==-1)
		{
		   if(pc.getCurPage()<pages)
				pc.setCurPage(pc.getCurPage()+1);
		}
		else
		pc.setCurPage(step);
		
		pc.setMaxItems(maxItems);
		se.setAttribute("pc", pc);
		response.sendRedirect(url);
		//System.out.println("http://"+request.getLocalAddr()+":"+request.getLocalPort());
		
		
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
