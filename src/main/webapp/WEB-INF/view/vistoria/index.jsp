<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vistorias</title>

<jsp:include page="../header.jsp"></jsp:include>

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

<jsp:include page="../main.jsp"></jsp:include>
	
<jsp:include page="../menu.jsp"></jsp:include>

<div class="content-wrapper">
	<section class="content-header">
		<h1>
			Vistorias
			<small>Cadastro de Vistorias</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="<c:url value='/' />" ><i class="fa fa-tachometer-alt"></i> Início</a></li>
			<li class="active">Vistorias</li>
		</ol>
	</section>
	<section class="content">
		<div class="box">
			<div class="box-header with-border">
				<div class="col-xs-10 col-sm-6 col-md-4 col-lg-4">
					<a href="<c:url value='/' />"><button type="button" class="btn btn-info btn-flat">Voltar</button></a>
				</div>
			</div>
			<div class="box-body table-responsive">
				<table id="tabela_principal" class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Nome</th>
							<th>Telefone</th>
							<th>Email</th>
							<th>Data do Agendamento</th>
							<th>Hora do Agendamento</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="v" items="${vistorias }">
							<c:if test="${!empty(v)}">
								<tr>
									<td>${v.id }</td>
									<td>${v.nome }</td>	
									<td>${v.telefone }</td>
									<td>${v.email }</td>
									<td>${v.dataAgendamento }</td>
									<td>${v.horaAgendamento }</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</div>

</div>

<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>