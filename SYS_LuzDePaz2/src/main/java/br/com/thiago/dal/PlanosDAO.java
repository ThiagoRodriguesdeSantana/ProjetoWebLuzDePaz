package br.com.thiago.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.thiago.model.PlanosModel;
import br.com.thiago.util.Conexao;

public class PlanosDAO {
	
	private Connection conexao;
	
	public PlanosDAO(){
		
		conexao = Conexao.PegarConexao();
	}
	
	public void inserirPlano(PlanosModel plano) {
		try {
			PreparedStatement ps = conexao
					.prepareStatement("INSERT INTO public.tb_planos("
							+ " descricao, valor, \"numeroDependentes\")"
									+ "VALUES (?, ?, ?);");
			ps.setString(1, plano.getDescricao());
			ps.setDouble(2, plano.getValor());
			ps.setInt(3, plano.getNumeroDependentes());
			
			ps.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public void alterarPlano(PlanosModel plano) {
		try {
			PreparedStatement ps = conexao
					.prepareStatement("UPDATE public.tb_planos"
							+ "  SET descricao=?, valor=?, \"numeroDependentes\""
									+ " WHERE codigo=?;");
			ps.setString(1, plano.getDescricao());
			ps.setDouble(2, plano.getValor());
			ps.setInt(3, plano.getNumeroDependentes());
			ps.setInt(4, plano.getCodigo());
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void excluirPlano(int id) {
		try {
			PreparedStatement preparedStatement = conexao
					.prepareStatement("DELETE FROM public.tb_planos WHERE codigo =?");
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public PlanosModel consultarPlanos(int id){
		PlanosModel plano = new PlanosModel();
		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * "
					                                        + "FROM public.tb_planos "
					                                               + "where codigo =" + id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				plano.setCodigo(rs.getInt(PlanosModel.codigoPlanos));
				plano.setDescricao(rs.getString(PlanosModel.descricaoPlanos));
				plano.setNumeroDependentes(rs.getInt(PlanosModel.numeroDependentesPlanos));
				plano.setValor(rs.getDouble(PlanosModel.valorPlanos));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return plano;
		
	}
    public List<PlanosModel> listarPlanos(){
    	List<PlanosModel> list = new ArrayList<PlanosModel>();
    	try {
    		Statement statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery("select * from tb_planos");
			
			while(rs.next()){
				PlanosModel plano = new PlanosModel();
				
				plano.setCodigo(rs.getInt(PlanosModel.codigoPlanos));
				plano.setDescricao(rs.getString(PlanosModel.descricaoPlanos));
				plano.setNumeroDependentes(rs.getInt(PlanosModel.numeroDependentesPlanos));
				plano.setValor(rs.getDouble(PlanosModel.valorPlanos));
				
				list.add(plano);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return list;
    	
	}

}
