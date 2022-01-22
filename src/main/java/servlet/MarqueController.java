package servlet;

import javax.servlet.http.HttpServlet;

import beans.Machine;
import beans.Marque;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MachineService;
import service.MarqueService;

@WebServlet(urlPatterns = {"/MarqueController"})
public class MarqueController extends HttpServlet{
	
	private MarqueService ms = new MarqueService();
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {

	        if (request.getParameter("op") != null) {
	            if (request.getParameter("op").equals("delete")) {
	                int id = Integer.parseInt(request.getParameter("id"));
	                ms.delete(ms.findById(id));
	                response.sendRedirect("marque.jsp");
	            } else if (request.getParameter("op").equals("update")) {
	                int idM = Integer.parseInt(request.getParameter("idM"));
	                Marque m = ms.findById(idM);
	                response.sendRedirect("marque.jsp?id=" + m.getIdM() + "&codeM=" + m.getCodeM()  + "&libelle=" + m.getLibelle());
	            }
	        } else if (request.getParameter("idM") != null) {
	            if (!request.getParameter("idM").equals("")) {
	                String codeM = request.getParameter("codeM");
	                String libelle = request.getParameter("libelle");
	                int idM = Integer.parseInt(request.getParameter("idM"));
	                Marque m = ms.findById(idM);
	                m.setCodeM(codeM); 
	                m.setLibelle(libelle);
	                
	                ms.update(m);
	                response.sendRedirect("marque.jsp");
	            }
	        }   int idM=Integer.parseInt(request.getParameter("idM"));
	            String codeM = request.getParameter("codeM");
	            String libelle = request.getParameter("libelle");
	            
	            
	            System.out.println("~##### "+codeM);
	            ms.create(new Marque(idM,codeM,libelle));
	            response.sendRedirect("marque.jsp");
	        
	    }
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }
	 
	 @Override
	    public String getServletInfo() {
	        return "Short description";
	    }

	 
}

