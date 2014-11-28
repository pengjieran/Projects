package com.bean.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.entity.UserInfo;
import com.bean.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//response.sendRedirect("http://localhost:8080/WebExample/register");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		UserService userService = new UserService();
		try {
			
			List<UserInfo> list = userService.getByName(userName);
			if (list.isEmpty()) {
				
				request.setAttribute("login", "error");
				request.getRequestDispatcher("view/login.jsp").forward(request, response);
			} else {
				
				UserInfo userInfo = list.get(0);
				if (password.equals(userInfo.getPassword())) {
					
					request.setAttribute("login", "success");
				} else {
					
					request.setAttribute("login", "error");
					request.getRequestDispatcher("view/login.jsp").forward(request, response);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}