package br.com.thiago.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.thiago.model.AgendamentoModel;
import br.com.thiago.util.Conexao;

public class AgendamentosDAO {

	private Connection conexao;
	
	public AgendamentosDAO(){
		conexao = Conexao.PegarConexao();
	}
	
	public void inserirAgendamento(AgendamentoModel agendamento){
		try {
			PreparedStatement ps = conexao
					.prepareStatement("INSERT INTO public.tb_agendamentos("
						        	+ "\"dataHora\", local, \"nomeConsultor\")"
									+ "VALUES (?, ?, ?);");
			ps.setDate(1, new java.sql.Date(agendamento.getDataHora().getTime()));
			ps.setString(2, agendamento.getLocal());
			ps.setString(3, agendamento.getNomeCondultor());
		
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public void laterarAgendamento(AgendamentoModel agendamento){
		
		try {
			PreparedStatement ps = conexao
					.prepareStatement("UPDATE public.tb_agendamentos"
							+ "SET \"dataHora\"=?, local=?, \"nomeConsultor\"=?"
									+ "WHERE codigo=? ;");
			
			ps.setDate(1, new java.sql.Date(agendamento.getDataHora().getTime()));
			ps.setString(2, agendamento.getLocal());
			ps.setString(3, agendamento.getNomeCondultor());
			ps.setInt(4, agendamento.getCodigo());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluirAgendamento(int id){
		try {
			PreparedStatement preparedStatement = conexao
					.prepareStatement("DELETE FROM public.tb_agendamentos "
							         + "WHERE codigo=?");
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public AgendamentoModel consultarAgendamento(int id){
		
		AgendamentoModel agendamento = new AgendamentoModel();
		try {
			
			PreparedStatement	ps = conexao.prepareStatement("SELECT * FROM public.tb_agendamentos where codigo =" + id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				agendamento.setCodigo(rs.getInt(AgendamentoModel.codigoAgendamento));
				agendamento.setDataHora(rs.getDate(AgendamentoModel.dataHoraAgendamento));
				agendamento.setLocal(rs.getString(AgendamentoModel.localAgendamento));
				agendamento.setNomeCondultor(rs.getString(AgendamentoModel.nomeConsultor));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return agendamento;
	}
	public List<AgendamentoModel> listarAgendamento(){
		
		List<AgendamentoModel> list = new ArrayList<AgendamentoModel>();
		try {
			Statement statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery("select * from tb_agendamentos");
			while(rs.next()){
				AgendamentoModel agendamento = new AgendamentoModel();
				agendamento.setCodigo(rs.getInt(AgendamentoModel.codigoAgendamento));
				agendamento.setDataHora(rs.getDate(AgendamentoModel.dataHoraAgendamento));
				agendamento.setLocal(rs.getString(AgendamentoModel.localAgendamento));
				agendamento.setNomeCondultor(rs.getString(AgendamentoModel.nomeConsultor));
				
				list.add(agendamento);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
}
