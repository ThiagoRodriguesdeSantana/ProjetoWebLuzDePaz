package br.com.luzDePaz.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrincipalController
 */
@WebServlet("/PrincipalController")
public class PrincipalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String Principal = "/principal.jsp";
	
 
    public PrincipalController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Acao = "";
        String comando = request.getParameter("comando");
        
        if(comando.equalsIgnoreCase("principal")){
        	 Acao = Principal;
        	
        }
        
        
        RequestDispatcher view = request.getRequestDispatcher(Acao);
        view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
