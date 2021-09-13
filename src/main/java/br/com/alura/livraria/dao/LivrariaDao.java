package br.com.alura.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import br.com.alura.livraria.modelo.Autor;

public class LivrariaDao {
	
	private Connection conexao;
	
	public LivrariaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrar(Autor autor) {
		try {
			String sql = "insert into autores (nome, email, dataNascimento, miniCurriculo) values (?, ? ,?,?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,autor.getNome());
			ps.setString(2,autor.getEmail());
			ps.setDate(3, Date.valueOf(autor.getDataNascimento()));
			ps.setString(4, autor.getMiniCurriculo());
			
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error ao conectar o banco de dados");
		}
	}
	
	public List<Autor> listar(){
		try {
			String sql = "select * from autores";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Autor> list = new ArrayList<>();
			
			while(rs.next()) {
				Autor a = new Autor();
				a.setNome(rs.getString("nome"));
				a.setEmail(rs.getString("email"));
				a.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());	
				list.add(a);
			}
			
			return list;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
