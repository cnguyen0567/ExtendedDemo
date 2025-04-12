package com.example.extendeddemo.admin.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.extendeddemo.admin.model.Categories;
import com.example.extendeddemo.adminandenduser.service.CategoryServiceImpl;
import com.example.extendeddemo.adminandenduser.service.ICategoryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoriesServlet
 */
@WebServlet(description = "Servelt dedicated to processing categories from front end to database", urlPatterns = {
		"/CategoriesServlet", "/categories" })
public class CategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// cant use until springboot private static final Logger logger = LogManager.getLogger(CategoriesServlet.class);

	private ICategoryService categoryService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriesServlet() {
		super();
		// TODO Auto-generated constructor stub
		categoryService = new CategoryServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside CategoriesServlet.doPost() with " + request.getParameter("type") + " type");
		String type = request.getParameter("type");

		if ("createCategory".equals(type)) {
			System.out.println("Starting Create");
			// create a category record in db. create a utility method to do the setters and getters
			Categories categoriesObj = loadObject(request);
			// send to DB
			categoryService.saveCategory(categoriesObj);
			
		} else if ("updateCategory".equals(type)) {
			System.out.println("Starting Update");
			// update an existing category in db
			Categories categoriesUpdateObj = loadObject(request);
			try {
				//the appropriate to UPDATE the category obj created above
				categoryService.updateCategory(categoriesUpdateObj);
				System.out.println(categoriesUpdateObj);
				
				//setting an additional attribute for the end user
				request.setAttribute("successMessage", "Category obj updated sucessfully!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/categories-admin.jsp");
				dispatcher.forward(request,response);
			}catch(Exception e) {
				System.out.println("Update failure!: ");
				e.printStackTrace();
			}
		}

		// doGet(request, response);
		// categoryService.get
	}

	private Categories loadObject(HttpServletRequest request) {
		// create a placeholder Category object
		System.out.println("load obj: " + request.getMethod());
		Categories categories = new Categories();
		// update the category object with appropriate field values
		// drawn from the HttpServletRequest

		// Call the setters methods of the Categories class and set CategoryId in case its available.
		if (request.getParameter("categoryId") != null) {
			String categoryId = request.getParameter("categoryId");  //getParameter returns a string, need to convert
			categories.setCategoryId(Integer.parseInt(categoryId));

		}

		categories.setCategoryName(request.getParameter("categoryName"));
		categories.setCategoryDescription(request.getParameter("categoryDesc"));
		categories.setCategoryImageUrl(request.getParameter("categoryImgUrl"));
		// transformations of object fields to fit the setter method contract
		Integer activeId = Integer.parseInt(request.getParameter("activeId"));
		categories.setActive(activeId);
		// transformations of object fields to fit the setter method contract
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		String dateString = request.getParameter("addedOn"); // 2024-07-28
		LocalDate addedOn = LocalDate.parse(dateString, formatter);
		categories.setAddedOn(addedOn);
		return categories;
	}

}
