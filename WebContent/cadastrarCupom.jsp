<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Cadastrar Cupom</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/animate.css">
  <link href="css/prettyPhoto.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet" />
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
                  
                  <p class="animation animated-item-2">Efetue seu cadastro de cupom</p>
                  <form action="CupomController">
                  	<p>Codigo do cupom: <input type="number" name="codigoCupom"/></p>
                  	<p>descricao: <input type="text" name="descricao"/></p>
                  	<p>numero de pontos: <input type="number" name="numeroDePontos"/></p>
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
    