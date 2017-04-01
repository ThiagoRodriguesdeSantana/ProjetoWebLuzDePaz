package br.com.thiago.model;

public class PlanosModel {

	private int codigo;
	private String descricao;
	private double valor;
	private int numeroDependentes;
	
	public static String codigoPlanos = "codigo";
	public static String descricaoPlanos ="descricao";
	public static String valorPlanos ="valor";
	public static String numeroDependentesPlanos = "numeroDependentes";
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getNumeroDependentes() {
		return numeroDependentes;
	}
	public void setNumeroDependentes(int numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}
	
	
	
	
}
