package br.com.thiago.model;

import java.util.Date;
import java.util.List;

import javafx.beans.property.ReadOnlyBooleanProperty;

public class ClienteModel {

	private int codigo;
	private String nome;
	private Endereco endereco;
	private String CPF;
	private String telefone;
	private String email;
	protected TipoCliente tipoCliente;
	private Date dataNascimento;
	
	
	
	public static String CodigoCliente = "codigo";
	public static String NomeCliente = "nome";
	public static String CpfCliente = "cpf";
	public static String telefoneCliente = "telefone";
	public static String emailCliente = "email";
	public static String dataNascimentoCliente = "dataNascimento";
	public static String tipoClienteCliente = "tipoCliente";
	public static String nomeTabela = "tb_cliente";
	
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNacimento() {
		return dataNascimento;
	}
	public void setDataNacimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	
	
	
	
	
	
}
