package br.com.thiago.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.thiago.model.PlanosModel;
import br.com.thiago.model.ServicosModel;
import br.com.thiago.model.TipoServico;
import br.com.thiago.util.Conexao;

public class ServicosDAO {

	private Connection conexao;

	public ServicosDAO() {

		conexao = Conexao.PegarConexao();
	}

	public void inserirServicos(ServicosModel servico) {
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"INSERT INTO public.tb_servicos(" + "descricao, valor, \"tipoServiço\")" + " VALUES (?, ?, ?);");
			ps.setString(1, servico.getDescricao());
			ps.setDouble(2, servico.getValor());
			ps.setString(3, servico.getTipoSevico().name());

			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void atualizarServicos(ServicosModel servico) {
		try {
			PreparedStatement ps = conexao.prepareStatement(
					"UPDATE public.tb_servicos" + " SET descricao=?, valor=?, \"tipoServiço\"=?" + " WHERE  codigo=?;");
			ps.setString(1, servico.getDescricao());
			ps.setDouble(2, servico.getValor());
			ps.setString(3, servico.getTipoSevico().name());
			ps.setInt(4, servico.getCodigo());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void excluirServicos(int id) {
		try {
			PreparedStatement preparedStatement = conexao
					.prepareStatement("DELETE FROM public.tb_servicos WHERE codigo=?;");

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ServicosModel consultarServicos(int id) {
		ServicosModel servico = new ServicosModel();
		try {
			PreparedStatement ps = conexao
					.prepareStatement("SELECT * " + "FROM public.tb_servicos " + "where codigo =" + id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				servico.setCodigo(rs.getInt("codigo"));
				servico.setDescricao(rs.getString("descricao"));
				servico.setValor(rs.getDouble("valor"));
				servico.setTipoSevico(pageTipoServico(rs.getString("tipoServiço")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return servico;

	}

	public List<ServicosModel> listarServicos(int id) {
		List<ServicosModel> list = new ArrayList<ServicosModel>();
		
		try {
			Statement statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery("select * from tb_servicos");
			
			while(rs.next()){
				ServicosModel servico = new ServicosModel();
				servico.setCodigo(rs.getInt("codigo"));
				servico.setDescricao(rs.getString("descricao"));
				servico.setValor(rs.getDouble("valor"));
				servico.setTipoSevico(pageTipoServico(rs.getString("tipoServiço")));
				
				list.add(servico);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	private TipoServico pageTipoServico(String tServico) {

		if (tServico.equals("transporte"))
			return TipoServico.transporte;
		else if (tServico.equals("Funeral"))
			return TipoServico.Funeral;
		else if (tServico.equals("Flores"))
			return TipoServico.Flores;
		else
			return TipoServico.Cerimonia;

	}

}
