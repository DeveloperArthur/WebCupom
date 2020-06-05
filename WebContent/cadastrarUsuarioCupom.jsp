<%@page import="br.com.cuponsdesconto.entidades.Usuario"%>
<%@page import="br.com.cuponsdesconto.dao.UsuarioDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Cadastrar Usuario Cupom</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/animate.css">
  <link href="css/prettyPhoto.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet" />
  <!-- =======================================================
    Theme Name: Company
    Theme URL: https://bootstrapmade.com/company-free-html-bootstrap-template/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>
<%@include file="header.jsp" %>
  <section id="main-slider" class="no-margin">
    <div class="carousel slide">
      <div class="carousel-inner">
        <div class="item active" style="background-image: url(images/slider/bg1.jpg)">
          <div class="container">
            <div class="row slide-margin">
              <div class="col-sm-6">
                <div class="carousel-content">
                  
                  <p class="animation animated-item-2">Efetue seu cadastro do usuario e seus cupons</p>
                  <form action="UsuarioCupomController">
                  	<p>CPF do usuário <input type="text" name="cpfUsuario"></p>
                  	<p>Código do cupom <input type="number" name="codigoCupom"/></p>
                  	<input type="hidden" name="acao" value="cadastrar"/>
                  	<input class="btn-slide animation animated-item-3" type="submit" value="Cadastrar"/>
                  </form>
                </div>
              </div>

              <div class="col-sm-6 hidden-xs animation animated-item-4">
                <div class="slider-img">
                  <img src="images/slider/img3.png" class="img-responsive">
                </div>
              </div>

            </div>
          </div>
        </div>
        <!--/.item-->
      </div>
      <!--/.carousel-inner-->
    </div>
    <!--/.carousel-->
  </section>
  <!--/#main-slider-->
  
<%@include file="footer.jsp" %>
</body>

</html>

<%!
	/*public String buscaUsuarios(){
		List<Usuario> usuarios = (List<Usuario>)(List<?>) new UsuarioDao().buscarTodos();
		String html = "<select name=\"idUsuario\">";
		for(Usuario usu : usuarios){
			html += "<option value=\""+usu.getId()+"\">"+usu.getNome()+"</option>";
		}
		html += "</select>";
		return html;
	}*/
%>

    