package br.com.cuponsdesconto.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cuponsdesconto.dao.CupomDao;
import br.com.cuponsdesconto.entidades.Cupom;

@WebServlet("/CupomController")
public class CupomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CupomController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CupomDao dao = new CupomDao();
		String acao = request.getParameter("acao");
		switch(acao) {
			case "cadastrar":
				int codigoCupomParaCadastrar = Integer.parseInt(request.getParameter("codigoCupom"));
			    String descricaoParaCadastrar = request.getParameter("descricao");
			    int numeroDePontosParaCadastrar = Integer.parseInt(request.getParameter("numeroDePontos"));
			    
			    Cupom cupomParaCadastrar = new Cupom(codigoCupomParaCadastrar, descricaoParaCadastrar, numeroDePontosParaCadastrar);
			    if(new CupomDao().adicionar(cupomParaCadastrar))
			    	request.setAttribute("mensagem", "Cadastro realizado com sucesso");
			    else
			    	request.setAttribute("mensagem", "Erro no cadastro");
			    
			    response.sendRedirect("CupomController?acao=listar");
			    break;
			case "listar":
				List<Cupom> cupons = (List<Cupom>)(List<?>) new CupomDao().buscarTodos();
		    	
				request.setAttribute("cupons", cupons);
				request.getRequestDispatcher("listarCupons.jsp").forward(request, response);
				break;
			case "excluir":
				int idParaExcluir = Integer.parseInt(request.getParameter("id"));
				dao.deletar(idParaExcluir);
				response.sendRedirect("CupomController?acao=listar");
				break;
			case "preEditar":
				int idParaPreAtualizar = Integer.parseInt(request.getParameter("id"));
				Cupom cupomParaPreAtualizar = (Cupom) dao.buscar(idParaPreAtualizar);
				request.setAttribute("cupom", cupomParaPreAtualizar);
				request.getRequestDispatcher("editarCupom.jsp").forward(request, response);
				break;
			case "atualizar":
				int idParaAtualizar = Integer.parseInt(request.getParameter("id"));
				int codigoCupomParaAtualizar = Integer.parseInt(request.getParameter("codigoCupom"));
			    String descricaoParaAtualizar = request.getParameter("descricao");
			    int numeroDePontosParaAtualizar = Integer.parseInt(request.getParameter("numeroDePontos"));
			    
			    Cupom cupomParaAtualizar = new Cupom(idParaAtualizar, codigoCupomParaAtualizar, descricaoParaAtualizar, numeroDePontosParaAtualizar);
			    if(dao.atualizar(cupomParaAtualizar))
			    	request.setAttribute("mensagem", "Cupom atualizado com sucesso");
			    else
			    	request.setAttribute("mensagem", "Erro na atualização");
			    
			    request.getRequestDispatcher("confirmacaoCadastro.jsp").forward(request, response);
			    break;
		}
	}
}
