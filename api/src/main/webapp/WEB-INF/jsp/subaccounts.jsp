<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<head>
<title>Subaccounts</title>
<script
	src="<c:url value="plugins/bootstrap-inputmask/bootstrap-inputmask.min.js"/>"></script>
<script src="<c:url value='/js/form2js.js'/>" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body>
	<!-- Start -->
	<fieldset>
		<legend> Subaccounts </legend>
		<div class="box">
			<!-- 		<h4>Subaccounts</h4> -->
			<!-- 			<hr> -->
			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th class="numeric">NRKS</th>
						<th class="numeric">User Id</th>
						<th class="numeric">Name</th>
						<th class="numeric">Surname</th>
						<th class="numeric">Login</th>
						<th class="numeric">Balance [$]</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach begin="0" end="${fn:length(subaccounts)}" step="1"
						varStatus="loopCounter" items="${subaccounts}" var="subaccount">
						<c:choose>
							<c:when test="${loopCounter.index mod 5 == 0}">
								<tr class="active">
							</c:when>
							<c:when test="${loopCounter.index mod 5 == 1}">
								<tr class="success">
							</c:when>
							<c:when test="${loopCounter.index mod 5 == 2}">
								<tr class="info">
							</c:when>
							<c:when test="${loopCounter.index mod 5 == 3}">
								<tr class="warning">
							</c:when>
							<c:when test="${loopCounter.index mod 5 == 4}">
								<tr class="danger">
							</c:when>
						</c:choose>
						<td class="numeric">${subaccount.nrsk}</td>
						<td class="numeric">${subaccount.id}</td>
						<td class="numeric">${subaccount.name}</td>
						<td class="numeric">${subaccount.surname}</td>
						<td class="numeric">${subaccount.login}</td>
						<td class="numeric">${subaccount.saldo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</fieldset>
	<!-- Stop -->
</body>