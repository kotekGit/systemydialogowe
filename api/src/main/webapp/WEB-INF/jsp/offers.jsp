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
	<fieldset>
		<legend> Offers </legend>
		<!-- Start -->
		<div class="box">
			<!-- 			<h4>Offers</h4> -->
<!-- 			<hr> -->
			<table class="table table-striped table-condensed">
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
							<td class="numeric">${offer.id}</td>
							<td class="numeric">${offer.describe}</td>
							<td class="numeric">${offer.dateFrom}</td>
							<td class="numeric">${offer.dateTo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</fieldset>
	<!-- Stop -->
</body>