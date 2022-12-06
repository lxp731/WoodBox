package com.example.dl;

import java.io.IOException;
import bean.Userinfo;
import service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
//		String mail = request.getParameter("mail");
//		String telephone = request.getParameter("telephone");
//		String qq = request.getParameter("qq");
//		String wechat = request.getParameter("wechat");
//		String userpass2 = request.getParameter("userpass2");
//		String unaame = String.toCharArray(username);

		Userinfo user = new Userinfo();
		user.setUsername(username);
		user.setUserpass(userpass);
//		user.setMail(mail);
//		user.setQq(qq);
//		user.setWechat(wechat);
//		user.setTelephone(telephone);
		
		new UserService().reg(user);
		
		request.setAttribute("username", username);
		request.setAttribute("passpord",userpass);
//		request.setAttribute("telephone", telephone);
//		request.setAttribute("qq", qq);
//		request.setAttribute("wechat", wechat);
//		request.setAttribute("mail", mail);
		
		RequestDispatcher rd = request.getRequestDispatcher("RegSuccess.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
