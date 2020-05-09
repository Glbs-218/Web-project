package com.calcServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WorkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Сервлет авторизации, общий
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("InputUsername"); // Значение логина
		String password = request.getParameter("InputPassword"); // Значение пароля


		 File file = new File("/Users/ironswan666/Desktop/password.txt");
         // Объект FileReader для объекта File
         FileReader fr = new FileReader(file);
         // Объект BufferedReader с существующего FileReader для построчного считывания
         BufferedReader reader = new BufferedReader(fr);
         // считаем сначала первую строку
         String line = reader.readLine();
         reader.close();
         
    	 File file2 = new File("/Users/ironswan666/Desktop/login.txt");
         // Объект FileReader для объекта File
         FileReader fr2 = new FileReader(file2);
         // Объект BufferedReader с существующего FileReader для построчного считывания
         BufferedReader reader2 = new BufferedReader(fr2);
         // считаем сначала первую строку
         String line2 = reader2.readLine();
         reader2.close();
         

        boolean check = (password.equals(line)); //  Переменная, в которой лежит значение сравнения полученного пароля и пароля в документе
        boolean check2 = (username.equals(line2)); //  Переменная, в которой лежит значение сравнения полученного логина и логина в документе
         
		if(check == true && check2 == true) { // Если все верно
					response.sendRedirect("UserAuth.html"); // Перевод на страницу выбора пользователя
		} else { // Если не верно
			response.sendRedirect("UserSelect.html"); // Возврат на ту же страницу
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		doGet(request, response);
	}

}
