package br.com.weblivraria.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.weblivraria.dominio.Livro;

public class DAOLivro extends Conexao implements CRUDLivraria<Livro> {
	public String cadastrar (Livro dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql = "insert into(titulo,genero,sinopse,autor,preco,capa)values(?,?,?,?,?,?)";
//				Preparar a consulta para a Execução
				pst = con.prepareStatement(sql);
//				passagem dos parametros para a consulta
				pst.setString(1, dados.getTitulo());
				pst.setString(2, dados.getGenero());
				pst.setString(3, dados.getSinopse());
				pst.setString(4, dados.getAutor());
				pst.setDouble(5, dados.getPreco());
				pst.setString(6, dados.getCapa());
				
				if(pst.executeUpdate() > 0 ) {
					msg = "Cadastro Realizado";
				}
				else {
					msg = "Não Foi Possivel Cadastrar";
				}
			}
			else {
				msg = "Não Foi Possivel Estabelescer a Conexão Com o Banco";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao Tentar Cadastrar, Erro: "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro Inesperado, Erro: "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}

	@Override
	public List<Livro> listar() {
		List<Livro> lista = new ArrayList<Livro>();
		try {
			if (abrirConexao()) {
				String sql = "Select * from livro order by idlivro desc";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while (rs.next()) {
					Livro liv = new Livro();
					liv.setIdlivro(rs.getInt(1));
					liv.setTitulo(rs.getString(2));
					liv.setGenero(rs.getString(3));
					liv.setSinopse(rs.getString(4));
					liv.setAutor(rs.getString(5));
					liv.setPreco(rs.getDouble(6));
					liv.setCapa(rs.getString(7));
					
					lista.add(liv);
				}
			}
			else {
				new Exception ("Não Foi Possivel Estabalescer a Conexão Com o Banco");
			}
		}
		catch (SQLException se) {
			new Exception ("Erro Na Consulta, Erro: "+se.getMessage());
		}
		catch (Exception e ) {
			new Exception ("Erro Inesperado, Erro: "+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		return lista;
	}

	@Override
	public Livro pesquisar(Livro dados) {
		Livro liv = null;
		try {
			if (abrirConexao()) {
				String sql = "Select * from livros where idlivro = ? or titulo = ?";
				pst = con.prepareStatement(sql);
				pst.setInt(1,dados.getIdlivro());
				pst.setString(2, dados.getTitulo());
				rs = pst.executeQuery();
				if (rs.next()) {
					liv = new Livro();
					liv.setIdlivro(rs.getInt(0));
					liv.setTitulo(rs.getString(1));
					liv.setGenero(rs.getString(2));
					liv.setSinopse(rs.getString(3));
					liv.setAutor(rs.getString(4));
					liv.setPreco(rs.getDouble(5));
					liv.setCapa(rs.getString(6));
					
				}
			}
			else {
				new Exception ("Não Foi Possivel Estabalescer a Conexão Com o Banco");
			}
		}
		catch (SQLException se) {
			new Exception ("Erro Na Consulta, Erro: "+se.getMessage());
		}
		catch (Exception e ) {
			new Exception ("Erro Inesperado, Erro: "+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		return liv;
	}

	@Override
	public String atualizar(Livro dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql = "Update livro set titulo=?,genero=?,sinopse=?,preco=?,capa=? where idlivro=?";
//				Preparar a consulta para a Execução
				pst = con.prepareStatement(sql);
//				passagem dos parametros para a consulta
				pst.setString(1, dados.getTitulo());
				pst.setString(2, dados.getGenero());
				pst.setString(3, dados.getSinopse());
				pst.setDouble(4, dados.getPreco());
				pst.setString(5, dados.getCapa());
				pst.setInt(6, dados.getIdlivro());
				
				if(pst.executeUpdate() > 0 ) {
					msg = "Atualização Realizada";
				}
				else {
					msg = "Não Foi Possivel Atualizar";
				}
			}
			else {
				msg = "Não Foi Possivel Estabelescer a Conexão Com o Banco";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao Tentar Atualizar, Erro: "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro Inesperado, Erro: "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}

	@Override
	public String apagar(Integer id) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql = "delete from livro where idlivro=?";
//				Preparar a consulta para a Execução
				pst = con.prepareStatement(sql);
//				passagem dos parametros para a consulta
				pst.setInt(1, id);
				
				if(pst.executeUpdate() > 0 ) {
					msg = "Deletado com sucesso";
				}
				else {
					msg = "Não Foi Possivel Deletar";
				}
			}
			else {
				msg = "Não Foi Possivel Estabelescer a Conexão Com o Banco";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao Tentar Deletar, Erro: "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro Inesperado, Erro: "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}

}
