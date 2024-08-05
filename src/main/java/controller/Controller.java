package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/index", "/insert", "/select", "/update", "/delete" })

public class Controller extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String action = request.getServletPath();

		switch (action)
		{
		case "/index" -> contatos(request, response);
		case "/insert" -> novoContato(request, response);
		case "/select" -> selectContato(request, response);
		case "/update" -> updateContato(request, response);
		case "/delete" -> deleteContato(request, response);
		default -> response.sendRedirect("index.jsp");
		}

	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ArrayList<JavaBeans> listContatos = dao.getContatos();
		request.setAttribute("contatos", listContatos);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("agenda.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		dao.insertContato(contato);
		response.sendRedirect("index");
	}

	protected void selectContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String id = request.getParameter("id");
		contato.setId(id);
		dao.getSelected(contato);
		request.setAttribute("contato", contato);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("alterar_contato.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void updateContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		contato.setId(request.getParameter("id"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		dao.updateSelected(contato);
		response.sendRedirect("index");
	}

	protected void deleteContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String id = request.getParameter("id");
		contato.setId(id);
		dao.deleteSelected(contato);
		response.sendRedirect("index");
	}
}
