package br.com.thiago.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.thiago.model.ClienteModel;
import br.com.thiago.model.Endereco;
import br.com.thiago.model.TipoCliente;
import br.com.thiago.util.Conexao;

public class ClienteDAO {
	
	private Connection conexao;
	private PreparedStatement ps;
	public ClienteDAO() {
		
		conexao = Conexao.PegarConexao();
	}
	
	public boolean Inserir(ClienteModel cliente){
		
		try {
			String sql = "INSERT INTO public.tb_cliente("
					+ "nome, rua, complemento, bairro, cep, cidade, estado, cpf, telefone, "
					+ "email, \"tipoCliente\",\"dataNascimento\")"
				   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			ps = conexao.prepareStatement(sql);
			
			System.out.println("Entrou  no metodo");
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco().getRua());
			ps.setString(3, cliente.getEndereco().getComplemento());
			ps.setString(4, cliente.getEndereco().getBairro());
			ps.setString(5, cliente.getEndereco().getCep());
			ps.setString(6, cliente.getEndereco().getCidade());
			ps.setString(7, cliente.getEndereco().getEstado());
	        ps.setString(8, cliente.getCpf());
	        ps.setString(9, cliente.getTelefone());
	        ps.setString(10, cliente.getEmail());
	        
	        System.out.println("preencheu sem o tipo");
	        
	        ps.setString(11, pegarTipoClienteDescricao(cliente.getTipoCliente()));
	        
	        ps.setDate(12, new java.sql.Date(cliente.getDataNascimento().getTime()));
	        
	        System.out.println("preencheu com o tipo");
	       
	        System.out.println(ps.toString());
	        
	        ps.execute();
	        return true;
		} catch (Exception e) {
			 System.out.println("exception "+e);
			 return false;
		}
	}

	private String pegarTipoClienteDescricao(TipoCliente tipoCliente) {
		
		if(tipoCliente.equals(TipoCliente.Titular))
			return "Titular";
		else
			return "Dependente";
	}

	public ClienteModel Consultar(int Id) {
		
		ClienteModel cliente = new ClienteModel();
		Endereco endereco = new Endereco();
		
		try {
			ps = conexao.prepareStatement("SELECT * FROM public.tb_cliente where codigo =" + Id);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()){
				cliente.setCodigo(rs.getInt(ClienteModel.CodigoCliente));
				cliente.setNome(rs.getString(ClienteModel.NomeCliente));
				cliente.setCpf(rs.getString(ClienteModel.CpfCliente));
				cliente.setDataNascimento(rs.getDate(ClienteModel.dataNascimentoCliente));
				cliente.setTelefone(rs.getString(ClienteModel.telefoneCliente));
				cliente.setEmail(rs.getString(ClienteModel.emailCliente));
				endereco.setBairro(rs.getString(Endereco.bairroEndereco));
				endereco.setCep(rs.getString(Endereco.CepEndereco));
				endereco.setCidade(rs.getString(Endereco.cidadeEndereco));
				endereco.setComplemento(rs.getString(Endereco.complementoEndereco));
				endereco.setEstado(rs.getString(Endereco.estadoEndereco));
				endereco.setRua(rs.getString(Endereco.ruaEndereco));
				cliente.setEndereco(endereco);
				cliente.setTipoCliente(pegarTipoCliente(rs.getString(ClienteModel.tipoClienteCliente)));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 System.out.println("data entrada:" + cliente.getDataNascimento());
		return cliente;
	}
	private TipoCliente pegarTipoCliente(String tipo) {
		
		if(tipo.equals("Titular"))
			return TipoCliente.Titular;
		
		else
			return TipoCliente.Dependente;
	}

	public List<ClienteModel> ListarCleientes(){
		
		List<ClienteModel> list = new ArrayList<ClienteModel>();
		
		try {
			Statement statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery("select * from tb_cliente");
		    
			while(rs.next()){
				
				ClienteModel cliente = new ClienteModel();
				Endereco endereco = new Endereco();
				
				cliente.setCodigo(rs.getInt(ClienteModel.CodigoCliente));
				cliente.setNome(rs.getString(ClienteModel.NomeCliente));
				cliente.setCpf(rs.getString(ClienteModel.CpfCliente));
				cliente.setDataNascimento(rs.getDate(ClienteModel.dataNascimentoCliente));
				cliente.setTelefone(rs.getString(ClienteModel.telefoneCliente));
				cliente.setEmail(rs.getString(ClienteModel.emailCliente));
				endereco.setBairro(rs.getString(Endereco.bairroEndereco));
				endereco.setCep(rs.getString(Endereco.CepEndereco));
				endereco.setCidade(rs.getString(Endereco.cidadeEndereco));
				endereco.setComplemento(rs.getString(Endereco.complementoEndereco));
				endereco.setEstado(rs.getString(Endereco.estadoEndereco));
				endereco.setRua(rs.getString(Endereco.ruaEndereco));
				cliente.setEndereco(endereco);
				
				list.add(cliente);
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	public void ExcluirCliente(int id){
		try {
			PreparedStatement preparedStatement = conexao
					.prepareStatement("delete from tb_cliente where codigo=?");
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void AlterarCliente(ClienteModel cliente){
		
		try {
			PreparedStatement ps = conexao
					.prepareStatement("UPDATE public.tb_cliente"
							+ " SET nome=?, rua=?, complemento=?,"
							+ " bairro=?, cep=?, cidade=?, estado=?,"
							+ " cpf=?, telefone=?, email=?,"
							+ " \"tipoCliente\"=?, \"dataNascimento\"=?"
							+ " Where codigo=? ");
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco().getRua());
			ps.setString(3, cliente.getEndereco().getComplemento());
			ps.setString(4, cliente.getEndereco().getBairro());
			ps.setString(5, cliente.getEndereco().getCep());
			ps.setString(6, cliente.getEndereco().getCidade());
			ps.setString(7, cliente.getEndereco().getEstado());
	        ps.setString(8, cliente.getCpf());
	        ps.setString(9, cliente.getTelefone());
	        ps.setString(10, cliente.getEmail());
	        ps.setString(11, cliente.getTipoCliente().name());
	        ps.setDate(12, new java.sql.Date(cliente.getDataNascimento().getTime()));
	        ps.setInt(13, cliente.getCodigo());
			
			
	        System.out.println(ps.toString());
	        
	        ps.executeUpdate();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
