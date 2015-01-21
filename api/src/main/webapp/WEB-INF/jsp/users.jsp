<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<head>
<title>Users</title>
<script
	src="<c:url value="plugins/bootstrap-inputmask/bootstrap-inputmask.min.js"/>"></script>
<script src="<c:url value='/js/form2js.js'/>" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body>
	<!-- Start -->
	<div class="box">
		<h4>Users</h4>
		<hr>
		<table class="table table-bordered table-striped table-condensed">
			<thead>
				<tr>
					<th class="numeric">Id</th>
					<th class="numeric">Name</th>
					<th class="numeric">Surname</th>
					<th class="numeric">Login</th>
					<th class="numeric">Password</th>
					<th class="numeric">City</th>
					<th class="numeric">Street</th>
					<th class="numeric">District</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach begin="0" end="${fn:length(users)}" step="1"
					varStatus="loopCounter" items="${users}" var="user">
				<tr>
					<td class="numeric">${user.id}</td>
					<td class="numeric">${user.name}</td>
					<td class="numeric">${user.surname}</td>
					<td class="numeric">${user.login}</td>
					<td class="numeric">${user.password}</td>
					<td class="numeric">${user.place}</td>
					<td class="numeric">${user.street}</td>
					<td class="numeric">${user.district}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Stop -->
</body>