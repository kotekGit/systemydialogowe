
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>

<script src="<c:url value='/js/form2js.js'/>" type="text/javascript"></script>
<!-- Start -->
<fieldset>
	<legend> Result </legend>
	<div class="box">
		<!-- 	<h4>Results</h4> -->
		<!-- 	<hr> -->
		<table class="table table-striped table-condensed">
			<thead>
				<c:choose>
					<c:when test="${ not empty addresses}">
						<tr>
							<th class="numeric">Id</th>
							<th class="numeric">City</th>
							<th class="numeric">District</th>
							<th class="numeric">Street</th>
							<th class="numeric">Post</th>
							<th class="numeric">Postal Code</th>
							<th class="numeric">Building No</th>
							<th class="numeric">Local No</th>
							<th class="numeric">Type</th>
						</tr>
					</c:when>
					<c:otherwise>
			Not found result
			</c:otherwise>
				</c:choose>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ not empty addresses}">
						<c:forEach begin="0" end="${fn:length(addresses)}" step="1"
							varStatus="loopCounter" items="${addresses}" var="address">
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
							<td class="numeric">${address.id}</td>
							<td class="numeric">${address.city}</td>
							<td class="numeric">${address.district}</td>
							<td class="numeric">${address.street}</td>
							<td class="numeric">${address.post}</td>
							<td class="numeric">${address.postalCode}</td>
							<td class="numeric">${address.buildingNo}</td>
							<td class="numeric">${address.localNo}</td>
							<td class="numeric">${address.type}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
	</div>
</fieldset>
<!-- Stop -->