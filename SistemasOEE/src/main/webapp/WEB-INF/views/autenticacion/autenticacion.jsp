<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<html>
<head>
		<title>SistemasOEE TEST</title>
		<link rel="stylesheet" href="/resources/css/animate.css">
		<link rel="stylesheet" href="/resources/css/bootstrap.css">
		<link rel="stylesheet" href="/resources/css/icomoon.css">
	
		<link rel="stylesheet" href="/resources/css/owl.carousel.min.css">
		<link rel="stylesheet" href="/resources/css/owl.theme.default.min.css">
	
		<link rel="stylesheet" href="/sistemasoee/resources/css/style.css">
		<script src="/sistemasoee/resources/js/modernizr-2.6.2.min.js"></script>
	</head>
	<body class="boxed">
	
	<div id="wrap">

	<div id="fh5co-page">
		<header id="fh5co-header" role="banner">
			<div class="container">
				<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
				<div id="fh5co-logo"><a href="/sistemasoee/"><img src="/images/logo.jpg" alt="SistemasOEE Test"></a></div>
				<nav id="fh5co-main-nav" role="navigation">
					<ul>
						<li><a href="${pageContext.request.contextPath}/usuario/alta">Alta de Usuario</a></li>
						<li><a href="${pageContext.request.contextPath}/usuario/autenticacion">Autenticacion de Usuario</a></li>						
					</ul>
				</nav>
			</div>
		</header>
		<div id="fh5co-intro" class="fh5co-section">
			<div class="container">
				<div class="row row-bottom-padded-md">
					<div class="col-md-8 col-md-offset-2 text-center ts-intro">
						<div align="center">
							<div align="center">
								<h1>Autenticacion de Usuario</h1>
								<table>
									<s:form commandName="usuarioData" action="${pageContext.request.contextPath }/usuario/autenticacion" method="post">				
										<tr>
											<td>Email:</td>
											<td><s:input path="email"/></td>					
										</tr>
										<tr>
											<td>Contraseña:</td>
											<td><s:input path="contrasena"/></td>					
										</tr>
										<tr>
											<td></td>
											<td><input type="submit" value="Autenticar"/></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
									</s:form>
								</table>
								<div></div>
								<div>
									<p style="color:red;">${failed }</p>
								</div>
							</div>
						</div>
					</div>
				</div>			
			</div>
		</div>
	</div>
	</div>
	
	<script src="/sistemasoee/resources/js/jquery.min.js"></script>
	<script src="/sistemasoee/resources/js/jquery.easing.1.3.js"></script>
	<script src="/sistemasoee/resources/js/bootstrap.min.js"></script>
	<script src="/sistemasoee/resources/js/main.js"></script>
	
</body>
</html>