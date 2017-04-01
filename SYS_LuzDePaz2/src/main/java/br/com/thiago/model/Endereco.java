package br.com.thiago.model;

public class Endereco {

	private String rua;
	private String complemento;
	private String bairro;
	private String CEP;
	private String cidade;
	private String estado;
	
	public static String ruaEndereco = "rua";
	public static String complementoEndereco = "complemento";
	public static String bairroEndereco = "bairro";
	public static String CepEndereco = "cep";
	public static String cidadeEndereco = "cidade";
	public static String estadoEndereco = "estado";
	
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
