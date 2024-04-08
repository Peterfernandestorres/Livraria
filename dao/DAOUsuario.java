package br.com.weblivraria.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.weblivraria.dominio.Usuario;

public class DAOUsuario extends Conexao implements CRUDUsuario<Usuario>{

	@Override
	public String cadastrar(Usuario dados) {
		String msg = "";
//		Vamos Tentar Cadastrar o Usuario e caso dê erro, este será capturado e tratado
		try {
//			Verificar a conexão com o banco de dados e ver se foi aberta ou não
//			Caso Tenha Sido aberta, Iremos Executar os comandos de SQL para Cadastrar o Usuario.
//			Senão, Iremos exibir uma Mensagem para o Usuario de que não foi possivel estabelecer 
//			Comunicação com o banco de dados.
			if(abrirConexao()) {
				String sql = "insert into usuario(nomeusuario,senha,email,telefone,nomecompleto,cpf) values (?,?,?,?,?,?)";
//				Preparar a consulta para ser Executada
				pst = con.prepareStatement(sql);
//				Passagem de dados aos parâmetros da consulta, ou seja, cada ponto de interrogação ira
//				receber um dado correspondente a um campo da tabela
				pst.setString(1,dados.getNomeusuario());
				pst.setString(2,dados.getSenha());
				pst.setString(3,dados.getEmail());
				pst.setString(4,dados.getTelefone());
				pst.setString(5,dados.getNomecompleto());
				pst.setString(6,dados.getCpf());
				
//				Executar a Consulta e Verificar se o Retorno da execução é maior que 0 (zero)
				if(pst.executeUpdate() >0) {
					msg = "Cadastro Realizado";
				}
				else {
					msg = "Não foi possível cadastrar";
				}
			}
			else {
				msg = "Não Foi Possivel Estabelescer a Conexão com o Banco de Dados";
			}
		}
		catch(SQLException se) {
			msg = "Erro no Cadastro. "+se.getMessage(); 
		}
		catch (Exception e) {
			msg = "Erro Inesperado. "+e.getMessage();
		}
		finally {
			fecharConexao();
			
		}
		return msg;
	}

	@Override
	public Usuario pesquisar(Usuario dados) {
		Usuario us = new Usuario ();
		try {
			if(abrirConexao()) {
				String sql = "Select * from usuario where idusuario=?";
//				Vamos Preparar a Consulta para ser executada
				pst = con.prepareStatement(sql);
				pst.setInt(1, dados.getIdusuario());
//				Vamos executar a Consulta e guardar o Resultado Dentro do Elemento Resultset(rs)
				rs = pst.executeQuery();
				
				
				if (rs.next()) {
					

					us.setIdusuario(rs.getInt(1));
					us.setNomeusuario(rs.getString(2));
					us.setSenha(rs.getString(3));
					us.setEmail(rs.getString(4));
					us.setTelefone(rs.getString(5));
					us.setNomecompleto(rs.getString(6));
					us.setCpf(rs.getString(7));
					
				
				}
			}
			else {
				throw new Exception("Não Foi Possivel Estabelescer a Conexão Com o Banco");
			}
		}
		catch (SQLException se) {
			new Exception ("Erro na Consulta. "+se.getMessage());
		}
		catch (Exception e) {
			new Exception ("Erro Inesperado. "+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		return us;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			if(abrirConexao()) {
				String sql = "Select * from usuario";
//				Vamos Preparar a Consulta para ser executada
				pst = con.prepareStatement(sql);
//				Vamos executar a Consulta e guardar o Resultado Dentro do Elemento Resultset(rs)
				rs = pst.executeQuery();
				
//				/*
//				O Comando Acima Faz Com Que O Resultado Da Consulta do Select Seja Atribuido
//				ao RS (Resultset). Ele Recebe Todos os Dados, Mas Não de Forma Organizada.
//		Para Criar a Lista Usuario
				
				while (rs.next()) {
					Usuario us = new Usuario();
					us.setIdusuario(rs.getInt(1));
					us.setNomeusuario(rs.getString(2));
					us.setSenha(rs.getString(3));
					us.setEmail(rs.getString(4));
					us.setTelefone(rs.getString(5));
					us.setNomecompleto(rs.getString(6));
					us.setCpf(rs.getString(7));
					
					lista.add(us);
				}
			}
			else {
				throw new Exception("Não Foi Possivel Estabelescer a Conexão Com o Banco");
			}
		}
		catch (SQLException se) {
			new Exception ("Erro na Consulta. "+se.getMessage());
		}
		catch (Exception e) {
			new Exception ("Erro Inesperado. "+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		return lista;
	}

	@Override
	public String atualizar(Usuario dados) {
		String msg = "";

		try {
		if(abrirConexao()) {
			String sql = "insert into usuario set (nomeusuario=?,email=?,telefone=?,nomecompleto=? where idusuario=?) values (?,?,?,?)";
//			Preparar a consulta para ser Executada
			pst = con.prepareStatement(sql);
//			Passagem de dados aos parâmetros da consulta, ou seja, cada ponto de interrogação ira
//			receber um dado correspondente a um campo da tabela
			pst.setString(1,dados.getNomeusuario());
			pst.setString(2,dados.getEmail());
			pst.setString(3,dados.getTelefone());
			pst.setString(4,dados.getNomecompleto());
			pst.setInt(5,dados.getIdusuario());
			
//			Executar a Consulta e Verificar se o Retorno da execução é maior que 0 (zero)
			if(pst.executeUpdate()>0) {
				msg = "Atualização Realizada";
			}
			else {
				msg = "Não foi possível Atualizar";
			}
		}
		else {
			msg = "Não Foi Possivel Estabelescer a Conexão com o Banco de Dados";
		}
	}
	catch(SQLException se) {
		msg = "Erro na Atualização . "+se.getMessage(); 
	}
	catch (Exception e) {
		msg = "Erro Inesperado. "+e.getMessage();
	}
	finally {
		fecharConexao();
		
	}
	return msg;
	
	}

	@Override
	public String apagar(Integer id) {
		String msg = "delete from usuario where id usuario";

		try {
		if(abrirConexao()) {
			String sql = "insert into usuario(nomeusuario,senha,email,telefone,nomecompleto,cpf) values (?,?,?,?,?,?)";
//			Preparar a consulta para ser Executada
			pst = con.prepareStatement(sql);
//			Passagem de dados aos parâmetros da consulta, ou seja, cada ponto de interrogação ira
//			receber um dado correspondente a um campo da tabela
			pst.setInt(1,id);
			
			
//			Executar a Consulta e Verificar se o Retorno da execução é maior que 0 (zero)
			if(pst.executeUpdate() > 0) {
				msg = "Usuario Apagado";
			}
			else {
				msg = "Não foi possível Apagar";
			}
		}
		else {
			msg = "Não Foi Possivel Estabelescer a Conexão com o Banco de Dados";
		}
	}
	catch(SQLException se) {
		msg = "Erro ao Apagar. "+se.getMessage(); 
	}
	catch (Exception e) {
		msg = "Erro Inesperado. "+e.getMessage();
	}
	finally {
		fecharConexao();
		
	}
	return msg;
	}

	@Override
	public boolean login(Usuario dados) {
		boolean auth = true;

		try {
		if(abrirConexao()) {
			String sql = "Select nomeusuario,senha,email,cpf values from usuario where nomeusuario=? or email=? or cpf=? and senha=?";
//			Preparar a consulta para ser Executada
			pst = con.prepareStatement(sql);
//			Passagem de dados aos parâmetros da consulta, ou seja, cada ponto de interrogação ira
//			receber um dado correspondente a um campo da tabela
			pst.setString(1,dados.getNomeusuario());
			pst.setString(2,dados.getEmail());
			pst.setString(3,dados.getCpf());
			pst.setString(4,dados.getSenha());
			
			rs = pst.executeQuery ();
			
			if(!rs.next()) {
				auth = false;
			}
//			Executar a Consulta e Verificar se o Retorno da execução é maior que 0 (zero)
			else {
				new Exception ("Não foi possível Estabelecer Conexão com o Banco");
			}
		}
		else {
			new Exception ("Não Foi Possivel Estabelescer a Conexão com o Banco de Dados");
		}
	}
	catch(SQLException se) { 
		auth = false;
		new Exception  ("Erro na consulta . "+se.getMessage()); 
	}
	catch (Exception e) {
		auth = false;
		new Exception ("Erro Inesperado. "+e.getMessage());
	}
	finally {
		fecharConexao();
	}
	return auth;
	}

	@Override
	public String alterarSenha(Usuario dados) {
		String msg = "";

		try {
		if(abrirConexao()) {
			String sql = "update usuario set senha=? where idusuario=?";
//			preparar uma Consulta para ser executada
			pst = con.prepareStatement(sql);
//			Passagem de dados aos parâmetros da consulta, ou seja, cada ponto de interrogação ira
//			receber um dado correspondente a um campo da tabela
			pst.setString(1,dados.getSenha());
			pst.setInt(2,dados.getIdusuario());
			
//			Executar a Consulta e Verificar se o Retorno da execução é maior que 0 (zero)
			if(pst.executeUpdate()>0) {
				msg = "Atualização Realizada";
			}
			else {
				msg = "Não foi possível Atualizar";
			}
		}
		else {
			msg = "Não Foi Possivel Estabelescer a Conexão com o Banco de Dados";
		}
	}
	catch(SQLException se) {
		msg = "Erro na Atualização . "+se.getMessage(); 
	}
	catch (Exception e) {
		msg = "Erro Inesperado. "+e.getMessage();
	}
	finally {
		fecharConexao();
		
	}
	return msg;
	}

}
