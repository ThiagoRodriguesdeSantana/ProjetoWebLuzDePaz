package testCliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.thiago.dal.ClienteDAO;
import br.com.thiago.model.ClienteModel;
import br.com.thiago.model.Endereco;
import junit.framework.TestCase;

public class TestClienteDAO extends TestCase {
	
	ClienteModel cliente;
	Endereco endereco;
	ClienteDAO dao;
	
	@Before
	public void setUp() {
		try {
			
			this.cliente = new ClienteModel();
			this.endereco = new Endereco();
			this.dao = new ClienteDAO();
			
			cliente.setNome("Thiago Rodrigues de Santana");
			cliente.setCPF("02165072190");
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse("11/12/1989");
			cliente.setDataNacimento(data);
			cliente.setEmail("thiagorodriguescamara@gmail.com");
			cliente.setTelefone("62 9 86182267");
			endereco.setRua("cp33");
			endereco.setBairro("conj primavera");
			endereco.setCEP("74744480");
			cliente.setEndereco(endereco);
			
		} catch (Exception e) {
			
		}
		
		
	}
	@Test
	public void testCoansultarCliente(){
		
		ClienteModel obj = dao.Consultar(1);
		assertEquals(cliente, obj);
	
	}
	

	
}
