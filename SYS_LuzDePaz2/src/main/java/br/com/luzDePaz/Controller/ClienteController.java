package br.com.luzDePaz.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.thiago.dal.ClienteDAO;
import br.com.thiago.model.ClienteModel;
import br.com.thiago.model.Endereco;
import br.com.thiago.model.TipoCliente;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String Inserir_Editar = "/CadastroCliente.jsp";
	private static String Listar_Consultar = "/ConsultarCliente.jsp";

	private ClienteDAO dao;
	
    
    public ClienteController() {
        super();
        this.dao = new ClienteDAO();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Acao = "";
        String comando = request.getParameter("comando");
        
        if(comando.equalsIgnoreCase("Inserir")){
        	 Acao = Inserir_Editar;
        }
        
        if(comando.equalsIgnoreCase("listar")){
       	 Acao = Inserir_Editar;
       	 request.setAttribute("clientes", dao.ListarCleientes());
        }
        
        if(comando.equalsIgnoreCase("atualizar")){
        	Acao = Inserir_Editar;
        	int codigo = Integer.parseInt(request.getParameter("codigo"));
        	ClienteModel cliente = dao.Consultar(codigo);
        	request.setAttribute("cliente", cliente);
        }
        if(comando.equalsIgnoreCase("excluir")){
        	Acao = Inserir_Editar;
        	int codigo = Integer.parseInt(request.getParameter("codigo"));
        	dao.ExcluirCliente(codigo);
        	request.setAttribute("clientes", dao.ListarCleientes());
        	
        }
		
        RequestDispatcher view = request.getRequestDispatcher(Acao);
        view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			ClienteModel cliente = new ClienteModel();
			Endereco endereco = new Endereco();

			cliente.setNome(request.getParameter(ClienteModel.NomeCliente));
			endereco.setBairro(request.getParameter(Endereco.bairroEndereco));
			endereco.setCep(request.getParameter(Endereco.CepEndereco));
			
			
			
			endereco.setCidade(request.getParameter(Endereco.cidadeEndereco));
			endereco.setComplemento(request.getParameter(Endereco.complementoEndereco));
			endereco.setRua(request.getParameter(Endereco.ruaEndereco));
			
			
			endereco.setEstado(request.getParameter(Endereco.estadoEndereco));
			
			cliente.setEndereco(endereco);
			cliente.setCpf(request.getParameter(ClienteModel.CpfCliente));
			cliente.setTelefone(request.getParameter(ClienteModel.telefoneCliente));
			cliente.setEmail(request.getParameter(ClienteModel.emailCliente));
			cliente.setTipoCliente(pegarTipoCliente(request.getParameter(ClienteModel.tipoClienteCliente)));
			
			System.out.println("data:"+ClienteModel.dataNascimentoCliente);
			SimpleDateFormat dataS = new SimpleDateFormat("dd-MM-yyyy");
			Date data = dataS.parse(request.getParameter(ClienteModel.dataNascimentoCliente));
			
			cliente.setDataNascimento(data);
			
			System.out.println("data:"+cliente.getDataNascimento().getTime());

			String id = request.getParameter(ClienteModel.CodigoCliente);
			if (id.isEmpty()) {
				System.out.println("Inserir");
				dao.Inserir(cliente);
				System.out.println("inseriu");
			} else {
				System.out.println("atualizar");
				cliente.setCodigo(Integer.parseInt(request.getParameter(ClienteModel.CodigoCliente)));
				dao.AlterarCliente(cliente);
				System.out.println("Atualizou");
			}
			
			
			RequestDispatcher view = request.getRequestDispatcher(Inserir_Editar);
			request.setAttribute("clientes", dao.ListarCleientes());
			view.forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private TipoCliente pegarTipoCliente(String parameter) {
		
		if(parameter.equals("Titular"))
			return TipoCliente.Titular;
		else
			return TipoCliente.Dependente;
		
	}

}
