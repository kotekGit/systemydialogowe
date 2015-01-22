<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<head>
<title>Addresses</title>
<script
	src="<c:url value="plugins/bootstrap-inputmask/bootstrap.min.js"/>"></script>
<script src="<c:url value='/js/form2js.js'/>" type="text/javascript"></script>
<body>
	<!-- 	<h3>Search addreses</h3> -->

	<!-- 	<div class="row-fluid"> -->
	<!-- Search in system for criteria -->
	<fieldset>
		<c:url value="/gui/addresses" var="search" />
		<form:form modelAttribute="addressSearch" cssClass="form-horizontal"
			method="POST" action="${search}" role="form">
			<legend> Search transactions</legend>
			<div id="search-feedback" class="text-error"></div>

			<div class="form-group">
				<div class="span5">
					<label class="control-label"> User Id </label>
				</div>
				<div class="span7">
					<form:input cssClass="input-medium" path="id" />
					<form:errors path="id" cssClass="text-error" />
				</div>
			</div>
			<div class="row-fluid span12"></div>

			<div class="form-group">
				<div class="span5">
					<label class="control-label"> Category </label>
				</div>
				<div class="span7">
					<form:input cssClass="input-medium" path="category" />
					<form:errors path="category" cssClass="text-error" />
				</div>
			</div>
			<div class="row-fluid span12"></div>

			<div class="form-group">
				<div class="span5">
					<label class="control-label"> Type </label>
				</div>
				<div class="span7">
					<form:input cssClass="input-medium" path="type" />
					<form:errors path="type" cssClass="text-error" />
				</div>
			</div>
			<div class="row-fluid span12"></div>

			<div class="form-group">
				<div class="span5">
					<label class="control-label">Interval</label>
				</div>
				<div class="span7">
					<form:select path="interval" items="${interval}" class="form-control"></form:select>
					<form:errors path="interval" cssClass="error" />
				</div>
			</div>
			<div class="row-fluid span12"></div>

			<%-- 					<div class="row-fluid">
						<form:button class="btn btn-group pull-right" tittle="Search"></form:button>
					</div> --%>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10 pull-right">
					<button type="submit" class="btn btn-primary">Search
						transactions</button>
				</div>
			</div>
		</form:form>
	</fieldset>
	<jsp:include page="/WEB-INF/jsp/transactionsList.jsp"></jsp:include>
	<!-- 	</div> -->
</body>