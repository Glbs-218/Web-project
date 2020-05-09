package com.calcServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminBack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Сервлет для кнопки "Вернуться"
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Сервлет для кнопки "вернуться"
		 */
		
		response.sendRedirect("UserAuth.html");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
