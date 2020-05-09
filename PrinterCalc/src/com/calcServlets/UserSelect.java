package com.calcServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/*
	 * Сервлет выбора пользователя 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String select = request.getParameter("Select"); // Значение кнопки 
		String worker = "worker"; // Перемнная для проверки 
		boolean select_value = (select.equals(worker)); // Проверка нажатия кнопки 

		
		
		if(select_value == true) { // Если нажата кнопка "Работник"
			response.sendRedirect("worker.html");
		} else { // Если нажата кнопка "Администратор"
			response.sendRedirect("autorization.html");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
