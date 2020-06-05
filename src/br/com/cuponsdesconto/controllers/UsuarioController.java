package br.com.cuponsdesconto.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cuponsdesconto.dao.UsuarioDao;
import br.com.cuponsdesconto.entidades.Usuario;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDao dao = new UsuarioDao();
		String acao = request.getParameter("acao");
		switch(acao) {
			case "cadastrar":
				String nomeParaCadastrar = request.getParameter("nome");
				String cpfParaCadastrar = request.getParameter("cpf");
				String emailParaCadastrar = request.getParameter("email");
				String senhaParaCadastrar = request.getParameter("senha");
				
				Usuario usuarioParaCadastrar = new Usuario(nomeParaCadastrar, cpfParaCadastrar, emailParaCadastrar, senhaParaCadastrar);
				if(dao.adicionar(usuarioParaCadastrar))
					request.setAttribute("mensagem", "Cadastro realizado com sucesso");
			    else
			    	request.setAttribute("mensagem", "Erro no cadastro");
			    
			    request.getRequestDispatcher("confirmacaoCadastro.jsp").forward(request, response);
			    break;
			case "listar":
				List<Usuario> usuarios = (List<Usuario>)(List<?>) dao.buscarTodos();
		    	
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
				break;
			case "excluir":
				int idParaExcluir = Integer.parseInt(request.getParameter("id"));
				dao.deletar(idParaExcluir);
				response.sendRedirect("UsuarioController?acao=listar");
				break;
			case "preEditar":
				int idParaPreAtualizar = Integer.parseInt(request.getParameter("id"));
				Usuario usuarioParaPreAtualizar = (Usuario)dao.buscar(idParaPreAtualizar);
				request.setAttribute("usuario", usuarioParaPreAtualizar);
				request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);
				break;
			case "atualizar":
				int idParaAtualizar = Integer.parseInt(request.getParameter("id"));
				String nomeParaAtualizar = request.getParameter("nome");
				String cpfParaAtualizar = request.getParameter("cpf");
				String emailParaAtualizar = request.getParameter("email");
				String senhaParaAtualizar = request.getParameter("senha");
				
				Usuario usuarioParaAtualizar = new Usuario(idParaAtualizar, nomeParaAtualizar, cpfParaAtualizar, emailParaAtualizar, senhaParaAtualizar);
				if(dao.atualizar(usuarioParaAtualizar))
					request.setAttribute("mensagem", "Usuario atualizado com sucesso");
			    else
			    	request.setAttribute("mensagem", "Erro na atualização");
			    
			    request.getRequestDispatcher("confirmacaoCadastro.jsp").forward(request, response);
			    break;
			case "logar":
				String email = request.getParameter("email");
				String senha = request.getParameter("senha");
				
				HttpSession sessao = request.getSession();
				
				Usuario usuario = dao.efetuarLogin(email, senha);
				if(usuario != null) {
					sessao.setAttribute("usuario", usuario);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
					sessao.invalidate();
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				break;
			case "sair":
				HttpSession sessaoLogout = request.getSession();
				sessaoLogout.invalidate();
				response.sendRedirect("login.jsp");
				break;
		}
	}
}
