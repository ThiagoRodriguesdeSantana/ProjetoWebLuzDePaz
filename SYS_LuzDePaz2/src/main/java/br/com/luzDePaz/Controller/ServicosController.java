package br.com.luzDePaz.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.thiago.dal.ServicosDAO;
import br.com.thiago.model.ClienteModel;
import br.com.thiago.model.ServicosModel;
import br.com.thiago.model.TipoServico;

/**
 * Servlet implementation class ServicosController
 */
@WebServlet("/ServicosController")
public class ServicosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String Listar = "/servicos.jsp";   
	
	private ServicosDAO dao;
   
    public ServicosController() {
        super();
        dao = new ServicosDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Acao = "";
        String comando = request.getParameter("comando");
        
        if(comando.equalsIgnoreCase("listar")){
          	 Acao = Listar;
          	 request.setAttribute("servicos", dao.listarServicos());
        }
        
        if(comando.equalsIgnoreCase("atualizar")){
        	Acao = Listar;
        	int codigo = Integer.parseInt(request.getParameter("codigo"));
        	ServicosModel servico = dao.consultarServicos(codigo);
        	request.setAttribute("servico", servico);
        }
        if(comando.equalsIgnoreCase("excluir")){
        	Acao = Listar;
        	int codigo = Integer.parseInt(request.getParameter("codigo"));
        	dao.excluirServicos(codigo);;
        	request.setAttribute("servicos", dao.listarServicos());
        	
        }
        
        RequestDispatcher view = request.getRequestDispatcher(Acao);
        view.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServicosModel servico = new ServicosModel();
			
			
			
			servico.setDescricao(request.getParameter("descricao"));
			servico.setTipoSevico(pegaTipoServico(request.getParameter("tipoSevico")));
			servico.setValor(Double.parseDouble(request.getParameter("valor")));
			
			
			System.out.println("descricao:" + servico.getDescricao() + "tipo:" + servico.getTipoSevico()+"valor: " + servico.getValor());
			
			String codigo = request.getParameter("codigo");
			
			
			if(codigo.isEmpty()){
				dao.inserirServicos(servico);
			}
			else{
				servico.setCodigo(Integer.parseInt(codigo));
				dao.atualizarServicos(servico);
			}
			
			RequestDispatcher view = request.getRequestDispatcher(Listar);
			request.setAttribute("servicos", dao.listarServicos());
			view.forward(request, response);
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private TipoServico pegaTipoServico(String parameter) {
		
		if(parameter.equals("Transporte")){
			return TipoServico.transporte;
		}
		else if(parameter.equals("Funeral")){
			return TipoServico.Funeral;
		}
		else if(parameter.equals("Decoracao")){
			return TipoServico.Decoracao;
		}
		else
			return TipoServico.Cerimonia;
		
	}

}
