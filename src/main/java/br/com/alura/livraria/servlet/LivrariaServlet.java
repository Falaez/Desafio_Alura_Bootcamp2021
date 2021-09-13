package br.com.alura.livraria.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.livraria.dao.LivrariaDao;
import br.com.alura.livraria.factory.ConnectionFactory;
import br.com.alura.livraria.modelo.Autor;

@WebServlet("/autores")
public class LivrariaServlet extends HttpServlet {
	
	private LivrariaDao dao;
	
	public LivrariaServlet () {
		this.dao = new LivrariaDao(new ConnectionFactory().getConnection());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("autores", dao.listar());
		
		req.getRequestDispatcher("WEB-INF/jsp/autores.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String email =  req.getParameter("email");
		LocalDate data = LocalDate.parse(req.getParameter("dataNascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String miniCurriculo = req.getParameter("miniCurriculo");
		
		Autor autor = new Autor(nome, email, data, miniCurriculo);
		
		dao.cadastrar(autor);
		
		resp.sendRedirect("autores");

	}

	
}
