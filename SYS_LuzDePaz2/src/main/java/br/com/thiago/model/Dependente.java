package br.com.thiago.model;

public class Dependente extends ClienteModel{
	
	private ClienteModel dadosTitular;
	
	public Dependente(){
		super();
		this.tipoCliente = TipoCliente.Dependente;
	}
	
	public ClienteModel getDadosTitular() {
		return dadosTitular;
	}
	
	
	public void setDadosTitular(ClienteModel dadosTitular) {
		this.dadosTitular = dadosTitular;
	}

	

}
