package br.com.cuponsdesconto.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.cuponsdesconto.dao.UsuarioCupomDao;
import br.com.cuponsdesconto.dao.UsuarioDao;
import br.com.cuponsdesconto.entidades.Cupom;
import br.com.cuponsdesconto.entidades.Usuario;

@WebServlet("/Api")
public class Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Api() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		String retorno = "";
		try(PrintWriter out = response.getWriter()){
			if(acao.equals("logar")) {
				String email = request.getParameter("email");
				String senha = request.getParameter("senha");
				Usuario usuario = new UsuarioDao().efetuarLogin(email, senha);
				retorno = new Gson().toJson(usuario);
			}else if(acao.equals("listarUsuarios")) {
				int idDoUsuario = Integer.parseInt(request.getParameter("id"));
				List<Cupom> cupons = new UsuarioCupomDao().buscarCuponsPorUsuario(idDoUsuario);
				retorno = new Gson().toJson(cupons);
			}
			
			out.print(retorno);
			out.flush();
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}

}
