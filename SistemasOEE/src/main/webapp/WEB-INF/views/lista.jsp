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
						<li><a href ="${pageContext.request.contextPath}/usuario/salir"><b>Salir</b></a></li>						
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
								<h1>Lista de Usuarios</h1>
								<div>
									
									<div align="left">
										Bienvenido <b style="color:red;">${usuario.nombre}</b>
									</div>
								</div>
								<div>								
									<c:if  test="${!empty usuarioList}">
										<table>
											<tr>
												<th>Nombre</th>
												<th>Edad</th>
												<th>Email</th>
											</tr>
											<c:forEach items="${usuarioList}" var="usr">
												<tr>
													<td width="100px">${usr.nombre}</td>
													<td width="20px">${usr.edad}</td>
													<td width="250px">${usr.email}</td>
												</tr>
											</c:forEach>
										</table>
									</c:if>
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