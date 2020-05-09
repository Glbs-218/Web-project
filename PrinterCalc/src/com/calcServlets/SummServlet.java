package com.calcServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SummServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 * Сервлет для расчета работника 
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String blackwhite = request.getParameter("blackwhite"); // Значение черно-белой печати
		String colorPrint = request.getParameter("colorPrint"); // Значение цветной печати
		String valuePrint = request.getParameter("printer"); // Выбор принтера 
		
		// Перевод в Double
		double blackwhiteInt = Integer.parseInt(blackwhite.trim()); 
		double colorPrintInt = Integer.parseInt(colorPrint.trim());
		double s = 0;
		
		// Блок выбора принтера
		switch (valuePrint) {
        case ("HP LaserJet Pro M104a"): 
        	blackwhiteInt = Math.round((blackwhiteInt * 0.048) * 100.0) / 100.0;
        	colorPrintInt = 0;
        	break;
        case ("Xerox Phaser 3020BI"): 
        	blackwhiteInt = Math.round((blackwhiteInt * 0.05) * 100.0) / 100.0;
        	colorPrintInt = 0;
        	break;
        case ("Canon i-SENSYS LBP7010C"):
        	colorPrintInt = Math.round(((colorPrintInt * 0.3)/4) * 100.0) / 100.0;
        	blackwhiteInt = 0;
        	break;
		}
		
		// Условие, при котором не выводятся лишние значения
		if(blackwhiteInt == 0) {
			s = colorPrintInt;
		} else {
			s = blackwhiteInt;
		}
		
		
		// Блок html-страницы
		response.setContentType("text/html");
		  PrintWriter writer = response.getWriter();
		  writer.println("<!DOCTYPE html>");
		  writer.println("<html lang=\"en\">");
		  writer.println("<meta charset=\"UTF-8\">");
		  writer.println("<title>Extend</title>");
		  writer.println("<link rel=\"stylesheet\" href=\"style.css\">");
		  writer.println("</head>");
		  writer.println("<body>");
		  writer.println("<form action=\"Summ\">");
		  writer.println("<div class=\"input_expend\">");
		  writer.println("<div class=\"input_paper\">");
		  writer.println("<strong>Paper: </strong>");
		  writer.println(s);
		  writer.println("<strong> pack</strong> <br>");
		  writer.println("</div>");
		  writer.println("<div class=\"input_toner\">");
		  writer.println("<strong>Toner: </strong>");
		  writer.println(blackwhiteInt);
		  writer.println("<strong> pack</strong> <br>");
		  writer.println("</div>");
		  writer.println("<div class=\"input_red\">");
		  writer.println("<strong>Red: </strong>");
		  writer.println(colorPrintInt);
		  writer.println("<strong> ml.</strong> <br>");
		  writer.println("</div>");
		  writer.println("<div class=\"input_blue\">");
		  writer.println("<strong>Blue: </strong>");
		  writer.println(colorPrintInt);
		  writer.println("<strong> ml.</strong> <br>");
		  writer.println("</div>");
		  writer.println("<div class=\"input_black_color\">");
		  writer.println("<strong>Black: </strong>");
		  writer.println(colorPrintInt);
		  writer.println("<strong> ml.</strong> <br>");
		  writer.println("</div>");
		  writer.println("<div class=\"input_yellow\">");
		  writer.println("<strong>Yellow: </strong>");
		  writer.println(colorPrintInt);
		  writer.println("<strong> ml.</strong>");
		  writer.println("</div>");
		  writer.println("</div>");
		  writer.println("</form>");
		  writer.println("</body>");
		  writer.println("</html>");
		  writer.println();
		  writer.println();
		  writer.println();
		  writer.println();
		  writer.println();
		  writer.println();		  

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
