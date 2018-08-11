package com.cg.onlinebookshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.cg.onlinebookshop.servicelayer.ServicelayerImpl;

@WebServlet("*.app")
public class Appcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServicelayerImpl servicelayer = new ServicelayerImpl();

		String name = request.getServletPath();
		System.out.println(name);

		switch (name) {
		case "/addnew.app":
			servicelayer.addBookIntoCarT(Integer.parseInt(request.getParameter("bookId")));
			int counter = servicelayer.getCounter();
			System.out.println(counter);
			double price = servicelayer.getPrice();
			System.out.println(price);
			response.sendRedirect("showCart.app");
			
			break;

		case "/removenew.app":
			servicelayer.removeBookFromCart(Integer.parseInt(request.getParameter("bookId")));
			counter = servicelayer.getCounter();
			System.out.println(counter);
			price = servicelayer.getPrice();
			System.out.println(price);
			HttpSession session = request.getSession();
			session.setAttribute("booksInCart", servicelayer.ViewCart());
			session.setAttribute("counter", servicelayer.getCounter());
			session.setAttribute("price", servicelayer.getPrice());
			response.sendRedirect("Cart.jsp");
			
			break;
	
			
		case "/showCart.app":

		    session = request.getSession();
			session.setAttribute("booksInCart", servicelayer.ViewCart());
			session.setAttribute("counter", servicelayer.getCounter());
			session.setAttribute("price", servicelayer.getPrice());
			response.sendRedirect("index.jsp");

			break;
			
			
		case "/showCarthyper.app":
		    response.sendRedirect("Cart.jsp");

			break;	

		case "/showBook.app":

			session = request.getSession();
			session.setAttribute("availableBooks", servicelayer.ViewBook());
			response.sendRedirect("home.jsp");

			break;

		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
