<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="br.com.cuponsdesconto.entidades.Usuario" %>
  <%
  	/*Usuario usuarioParaSessao = null;
  	if(session.getAttribute("usuario") != null){
  		usuarioParaSessao = (Usuario)session.getAttribute("usuario");
  	}else{
  		session.invalidate();
  		response.sendRedirect("login.jsp");
  	}*/
  %>
  <header>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="navigation">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse.collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
            <div class="navbar-brand">
              <a href="index.jsp"><h1><span>Web</span>Cupom</h1></a>
            </div>
          </div>

          <div class="navbar-collapse collapse">
            <div class="menu">
              <ul class="nav nav-tabs" role="tablist">
              	<li role="presentation"><a href="documentacaoApi.html">API</a></li>
                <li role="presentation"><a href="cadastrarCupom.jsp">Cadastrar cupom</a></li>
                <li role="presentation"><a href="cadastrarUsuarioCupom.jsp">Cadastrar cupons p usuarios</a></li>
                <li role="presentation"><a href="UsuarioController?acao=listar">Listar usuarios</a></li>
                <li role="presentation"><a href="CupomController?acao=listar">Listar cupons</a></li>
                <li role="presentation"><a href="UsuarioController?acao=sair">sair</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </nav>
  </header>