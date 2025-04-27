package com.example.extendeddemo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class FrontControllerServlet
 * act as a router to dispatch requests to the appropriate servlet internal to the app
 */
 /*@WebServlet( description =
		 * "a pattern designed to allow one ENTRY pt into Web App", urlPatterns = {
		 * "/FrontControllerServlet", "/FrontController" })
		 */
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(FrontControllerServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("Inside FrontControllerServlet.serive()");
		String requestType = request.getParameter("type");
		
		RequestDispatcher dispatcher = null;
		
		// requestType = value of name = "type" for each form
		if("createCategory".equals(requestType) || "updateCategory".equals(requestType)) {
			dispatcher = request.getRequestDispatcher("categories"); //this line will send the request to a "categories" servlet controller or another resources. this fxn return a requestdispatcher obj that acts as a wrapper for the resource located at a given path. Hence this is a front controller
		} else if ("login".equals(requestType)) {
			dispatcher = request.getRequestDispatcher("login");   //front controller connects the string to the right servlet by the servlet URL mapping (remember adding /<string> when creating a servlet). the dispatcherRequest can also intake an abs path/url.
		} else if ("home".equals(requestType)) {
			dispatcher = request.getRequestDispatcher("home");
		} else if ("categories".equals(requestType)) {
			dispatcher = request.getRequestDispatcher("categories");
		} else {
			dispatcher = request.getRequestDispatcher("error");
		}
		dispatcher.forward(request, response);
	}

}
