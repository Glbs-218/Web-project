package com.calcServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Сервлет авторизации для администратора 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String password = request.getParameter("InputPassword"); // Переменная хранит полученный пароль

		File file = new File("/Users/ironswan666/Desktop/passwordForAdmin.txt"); // Абсолютный путь к файлу
          // Объект FileReader для объекта File
        FileReader fr = new FileReader(file);
          // Объект BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
          // Считаем сначала первую строку
        String line = reader.readLine();
        reader.close();
        
        boolean check = (password.equals(line)); // Переменная, в которой лежит значение сравнения полученного пароля и пароля в документе
          
		if(check == true) {
					response.sendRedirect("adminpayment.html"); // Если значение true, то возрващает на страницу администратора 
		} else {
			response.sendRedirect("autorization.html"); // Если нет, то возвращает ту же страницу 
		}
		
		doGet(request, response);
	}

}
