package com.calcServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkerBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * Сервлет для кнопки "Вернуться" на странице работника
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
			String close = request.getParameter("closeButton"); // Значение кнопки "Вернуться"
			String redirectURL = "http://localhost:8080/PrinterCalc/UserAuth.html"; // Адрес возвращаемой страницы
			boolean close_button = (close.equals(close)); // Проверка нажатия кнопки
		
			if (close_button == true) { // Если нажата кнопка
				response.sendRedirect(redirectURL);
			} 
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
