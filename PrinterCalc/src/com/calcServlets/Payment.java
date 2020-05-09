package com.calcServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * Сервлет для расчета администратора 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String paper = request.getParameter("paper"); // Значение бумаги
		String toner = request.getParameter("toner"); // Значение тонера
		String red = request.getParameter("red"); // Значение красной краски
		String blue = request.getParameter("blue"); // Значение синей краски
		String black = request.getParameter("black"); // Значение черной краски
		String yellow = request.getParameter("yellow"); // Значение желтой краски 
		
		// Переменные, переводящие String в Double
		double o = Integer.parseInt(paper.trim());
		double l = Integer.parseInt(toner.trim());
		double y = Integer.parseInt(red.trim());
		double x = Integer.parseInt(blue.trim());
		double u = Integer.parseInt(black.trim());
		double p = Integer.parseInt(yellow.trim());
		
		double Summ; // Итоговая сумма
		
		double S = (((l/140)*200)+(o*180)+(390*(y+x+u+p)/70))/10-100; // Расчетная формула 
		Summ = Math.round((S) * 100.0) / 100.0; // Округление до сотых 
		
		// Блок html-страницы
		response.setContentType("text/html");
		  PrintWriter writer = response.getWriter();
		  writer.println("<!DOCTYPE html>");
		  writer.println("<html lang=\"en\">");
		  writer.println("<head>");
		  writer.println("<meta charset=\"UTF-8\">");
		  writer.println("<title>Расчет</title>");
		  writer.println("<link rel=\"stylesheet\" href=\"style.css\">");
		  writer.println("</head>");
		  writer.println("<body>");
		  writer.println("<form name=\"AdminSumm\">");
		  writer.println("<div class=\"input_cost\">");
		  writer.println("<strong>Summ of cost: </strong>");
		  writer.println(Summ);
		  writer.println("<strong> rubles</strong>");
		  writer.println("</div>");
		  writer.println("</form>");
		  writer.println("</body>");
		  writer.println("</html>");
		  writer.println();
		  writer.println();
		  writer.println();

		
	}
	
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
