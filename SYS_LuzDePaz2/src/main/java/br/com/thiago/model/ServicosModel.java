package br.com.thiago.model;

public class ServicosModel {

	private int codigo;
	private String descricao;
	private Double valor;
	private TipoServico tipoSevico;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public TipoServico getTipoSevico() {
		return tipoSevico;
	}
	public void setTipoSevico(TipoServico tipoSevico) {
		this.tipoSevico = tipoSevico;
	}
	
	
}
