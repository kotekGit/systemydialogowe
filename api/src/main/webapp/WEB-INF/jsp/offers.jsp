<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<head>
<title>Offers</title>
<script
	src="<c:url value="plugins/bootstrap-inputmask/bootstrap-inputmask.min.js"/>"></script>
<script src="<c:url value='/js/form2js.js'/>" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body>
	<!-- Start -->
	<div class="box">
		<h4>Offers</h4>
		<hr>
		<table class="table table-bordered table-striped table-condensed">
			<thead>
				<tr>
					<th class="numeric">Id</th>
					<th class="numeric">Content</th>
					<th class="numeric">Date From</th>
					<th class="numeric">Date To</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="0" end="${fn:length(offers)}" step="1"
					varStatus="loopCounter" items="${offers}" var="offer">
					<tr>
						<td class="numeric">${offer.id}</td>
						<td class="numeric">${offer.describe}</td>
						<td class="numeric">${offer.dateFrom}</td>
						<td class="numeric">${offer.dateTo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Stop -->
</body>