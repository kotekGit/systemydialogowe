
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
					<c:when test="${ not empty transactions}">
						<tr>
							<th class="numeric">Id</th>
							<th class="numeric">Date</th>
							<th class="numeric">Category</th>
							<th class="numeric">Type</th>
							<th class="numeric">Content</th>
						</tr>
					</c:when>
					<c:otherwise>
			Not found result
			</c:otherwise>
				</c:choose>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ not empty transactions}">
						<c:forEach begin="0" end="${fn:length(transactions)}" step="1"
							varStatus="loopCounter" items="${transactions}" var="transaction">
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
							<td class="numeric">${transaction.id}</td>
							<td class="numeric">${transaction.date}</td>
							<td class="numeric">${transaction.category}</td>
							<td class="numeric">${transaction.type}</td>
							<td class="numeric">${transaction.content}</td>
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