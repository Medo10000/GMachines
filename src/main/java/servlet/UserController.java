package servlet;

import javax.servlet.http.HttpServlet;

import beans.Machine;
import beans.Marque;
import beans.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MachineService;
import service.MarqueService;
import service.UserService;


@WebServlet(urlPatterns = "/login")
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public UserController() {
		super();
	}
	
	
	private void processRequest(
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {

		 String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        UserService userSevice = new UserService();
	         
	        try {
	            user userModel = userSevice.checkLogin(email, password);
	            String destPage = "login.jsp";
	             
	            if (userModel != null) {
	                HttpSession session = request.getSession();
	                session.setAttribute("user", userModel);
	                destPage = "index.jsp";
	            } else {
	                String message = "Invalid email/password";
	                request.setAttribute("message", message);
	            }
	             
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	             
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
	}

	

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		processRequest(request, response);
    }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		processRequest(request, response);
    }
	
	

	
}
