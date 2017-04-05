package br.com.luzDePaz.Controller;

import java.awt.event.FocusAdapter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.thiago.dal.AgendamentosDAO;
import br.com.thiago.model.AgendamentoModel;
import br.com.thiago.model.ClienteModel;

/**
 * Servlet implementation class AgendamentoController
 */
@WebServlet("/AgendamentoController")
public class AgendamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String Listar = "/agendamento.jsp";

	private AgendamentosDAO dao;

	public AgendamentoController() {
		super();
		dao = new AgendamentosDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Acao = "";
		String comando = request.getParameter("comando");

		if (comando.equalsIgnoreCase("listar")) {
			Acao = Listar;
			request.setAttribute("agendas", dao.listarAgendamento());
		}
		
		if(comando.equalsIgnoreCase("atualizar")){
        	Acao = Listar;
        	int codigo = Integer.parseInt(request.getParameter("codigo"));
        	AgendamentoModel agenda = dao.consultarAgendamento(codigo);
        	
        	
        	
        	request.setAttribute("agenda", agenda);
        }
		if(comando.equalsIgnoreCase("excluir")){
        	Acao = Listar;
        	int codigo = Integer.parseInt(request.getParameter("codigo"));
        	dao.excluirAgendamento(codigo);;
        	request.setAttribute("agendas", dao.listarAgendamento());
        	
        }
		

		RequestDispatcher view = request.getRequestDispatcher(Acao);
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try {
			AgendamentoModel agendamento = new AgendamentoModel();
			
			SimpleDateFormat dataS = new SimpleDateFormat("yyyy-MM-dd");
			Date data = dataS.parse(request.getParameter(AgendamentoModel.dataHoraAgendamento));
			System.out.println(data);
			agendamento.setDataHora(data);
			
			agendamento.setLocal(request.getParameter(AgendamentoModel.localAgendamento));
			agendamento.setNomeConsultor(request.getParameter(AgendamentoModel.nomeConsultorAgendamento));
			
			String codigo = request.getParameter(AgendamentoModel.codigoAgendamento);
			
			if(codigo.isEmpty()){
				dao.inserirAgendamento(agendamento);
				
			}
			else{
				agendamento.setCodigo(Integer.parseInt(codigo));
				dao.alterarAgendamento(agendamento);
			}
			
			RequestDispatcher view = request.getRequestDispatcher(Listar);
			request.setAttribute("agendas", dao.listarAgendamento());
			view.forward(request, response);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

}
