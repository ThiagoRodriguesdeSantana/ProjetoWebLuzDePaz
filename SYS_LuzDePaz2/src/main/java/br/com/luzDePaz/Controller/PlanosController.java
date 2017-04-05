package br.com.luzDePaz.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.thiago.dal.PlanosDAO;
import br.com.thiago.model.ClienteModel;
import br.com.thiago.model.PlanosModel;

/**
 * Servlet implementation class PlanosController
 */
@WebServlet("/PlanosController")
public class PlanosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static String Listar = "/cadastroPlanos.jsp";
	private PlanosDAO dao;
    public PlanosController() {
        super();
        dao = new PlanosDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Acao = "";
        String comando = request.getParameter("comando");
        
        if(comando.equalsIgnoreCase("listar")){
          	 Acao =Listar;
          	 request.setAttribute("planos", dao.listarPlanos());
         }
        if(comando.equalsIgnoreCase("atualizar")){
        	Acao = Listar;
        	int codigo = Integer.parseInt(request.getParameter("codigo"));
        	PlanosModel plano = dao.consultarPlanos(codigo);
        	request.setAttribute("plano", plano);
        	request.setAttribute("planos", dao.listarPlanos());
        }
        if(comando.equalsIgnoreCase("excluir")){
        	Acao = Listar;
        	int codigo = Integer.parseInt(request.getParameter("codigo"));
        	dao.excluirPlano(codigo);
        	request.setAttribute("planos", dao.listarPlanos());
        }
        
        RequestDispatcher view = request.getRequestDispatcher(Acao);
        view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlanosModel plano = new PlanosModel();
		
		plano.setDescricao(request.getParameter(PlanosModel.descricaoPlanos));
		plano.setNumeroDependentes(Integer.parseInt(request.getParameter(PlanosModel.numeroDependentesPlanos)));
		plano.setValor(Double.parseDouble(request.getParameter(PlanosModel.valorPlanos)));
		
		String codigo = request.getParameter(PlanosModel.codigoPlanos);
		
		if(codigo.isEmpty()){
			dao.inserirPlano(plano);
		}else{
			plano.setCodigo(Integer.parseInt(codigo));
			dao.alterarPlano(plano);
		}
		
		request.setAttribute("planos", dao.listarPlanos());
		RequestDispatcher view = request.getRequestDispatcher(Listar);
	    view.forward(request, response);
	}

}
