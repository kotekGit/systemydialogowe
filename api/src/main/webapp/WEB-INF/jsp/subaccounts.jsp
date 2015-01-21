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
	<div class="box">
		<h4>Subaccounts</h4>
		<hr>
		<table class="table table-bordered table-striped table-condensed">
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
					<td class="numeric">${subaccount.nrsk}</td>
					<td class="numeric">${subaccount.id}</td>
					<td class="numeric">${subaccount.name}</td>
					<td class="numeric">${subaccount.surname}</td>
					<td class="numeric">${subaccount.login}</td>
					<td class="numeric">${subaccount.saldo}</td>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Stop -->
</body>