package br.com.weblivraria.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.weblivraria.dao.DAOUsuario;
import br.com.weblivraria.dominio.Usuario;

public class TestDAOUsuario {

//	Vamos Realizar em todos os metodos que estão na classe DAOUsuario.
//	Vamos Começar Testando o Cadastro do usuario
//	@Test
//	public void testCadastroUsuario() {
////		Realizar a instancia da classe Usuario e aplicar dados ficticios para cadastrar.
////		esta tecnica é chamada de dados mockados
//		Usuario us = new Usuario();
//		us.setNomeusuario ("Pedro");
//		us.setSenha("123");
//		us.setEmail("Pedro@gmail.com.br");
//		us.setTelefone("11-1564-5678");
//		us.setNomecompleto("Pedro");
//		us.setCpf("133.466.784.01");
//		
////		Instancia da classe DAOUsuario
//		DAOUsuario daous = new DAOUsuario();
//		assertEquals("Cadastro Realizado",daous.cadastrar(us));
//	}
//}

//}
//	@Test
//	public void testListar() {
//		DAOUsuario daous = new DAOUsuario();
//		List<Usuario> resultado = new ArrayList<Usuario>();
//		assertEquals(resultado, daous.listar());
//	O Teste deve ser do tipo List com array List
//	}
//}
	
//@Test
//public void testPesquisar () {
//		DAOUsuario daous = new DAOUsuario();
//		Usuario us = new Usuario();
//		Usuario usuario_id = new Usuario();
//		usuario_id.setIdusuario(1);
//		assertEquals("pedro", daous.pesquisar(usuario_id).getNomeusuario());
//	}
//}

//  DEU ERRO
//	@Test
//	public void testAtualizar() {
//		Usuario us_test = new Usuario();
//		us_test.setIdusuario(1);
//		us_test.setNomeusuario("Pedro.pedreira");
//		us_test.setEmail("pedro@uol.com.br");
//		us_test.setTelefone("23752842");
//		us_test.setNomecompleto("Pedro Pedreira Nascimento");
//		
//		DAOUsuario daous = new DAOUsuario();
//		
//		assertEquals("Atualização Realizada", daous.atualizar(us_test));
//	}
//}
	
//	@Test
//	public void testLogin() {
//		Usuario us = new Usuario();
//		us.setNomeusuario("Pedro Pedreira");
//		us.setSenha("123");
//		
//		DAOUsuario daous = new DAOUsuario();
//		assertTrue(daous.login(us));
//	}
//}

	
// DEU ERRO
//	@Test
//	public void testAlterarSenha() {
//		Usuario us = new Usuario();
//		us.setSenha("abc123");
//		us.setIdusuario(1);
//		DAOUsuario daous = new DAOUsuario();
//		assertEquals("Atualização Realizada", daous.alterarSenha(us));
//		
//	}
}
	