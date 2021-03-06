package com.tsw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tsw.Constant;
import com.tsw.dao.LineDAO;
import com.tsw.dao.impl.LineDAOImpl;
import com.tsw.entitys.Line;

public class GetAllLineInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");

		LineDAO lineDao = new LineDAOImpl();
		List<Line> lines = lineDao.getAllInfo();
			
		HttpSession session = request.getSession();
			
		session.setAttribute("lineList", lines);

		response.sendRedirect(Constant.WEB_URL_LINELIST);
			
		out.flush();
		out.close();
	}

	/**
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
