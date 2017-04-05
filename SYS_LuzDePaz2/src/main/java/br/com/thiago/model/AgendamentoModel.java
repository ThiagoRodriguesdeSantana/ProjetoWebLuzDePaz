package br.com.thiago.model;

import java.util.Date;

public class AgendamentoModel {

    private int codigo;
    private Date dataHora;
    private String local;
    private String nomeConsultor;
    
    
	public static String codigoAgendamento = "codigo";
	public static String dataHoraAgendamento = "dataHora";
	public static String localAgendamento = "local";
	public static String nomeConsultorAgendamento = "nomeConsultor";
	

	
	public String getNomeConsultor() {
		return nomeConsultor;
	}
	public void setNomeConsultor(String nomeConsultor) {
		this.nomeConsultor = nomeConsultor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}

	public static String getCodigoAgendamento() {
		return codigoAgendamento;
	}
	public static void setCodigoAgendamento(String codigoAgendamento) {
		AgendamentoModel.codigoAgendamento = codigoAgendamento;
	}
	public static String getDataHoraAgendamento() {
		return dataHoraAgendamento;
	}
	public static void setDataHoraAgendamento(String dataHoraAgendamento) {
		AgendamentoModel.dataHoraAgendamento = dataHoraAgendamento;
	}
	public static String getLocalAgendamento() {
		return localAgendamento;
	}
	public static void setLocalAgendamento(String localAgendamento) {
		AgendamentoModel.localAgendamento = localAgendamento;
	}
	
	
}
