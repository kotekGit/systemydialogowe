<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<head>
<title>Addresses</title>
<script
	src="<c:url value="plugins/bootstrap-inputmask/bootstrap.min.js"/>"></script>
<script src="<c:url value='/js/form2js.js'/>" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/css/bootstrap-responsive.min.css"/>">
</head>
<body>
	<h3>Search addreses</h3>

	<div class="row-fluid">
		<!-- Search in system for crteria -->
		<fieldset>
			<c:url value="/gui/addresses" var="search" />
			<form:form modelAttribute="addressSearch" cssClass="form-horizontal"
				method="POST" action="${search}" role="form">
				<legend> Search </legend>
				<div id="search-feedback" class="text-error"></div>

				<div class="row-fluid">
					<div class="span6 row-fluid">
						<div class="span5">
							<label class="control-label"> City </label>
						</div>
						<div class="span7">
							<form:input cssClass="input-medium" path="city" />
							<form:errors path="city" cssClass="text-error" />
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="span6 row-fluid">
						<div class="span5">
							<label class="control-label"> District </label>
						</div>
						<div class="span7">
							<form:input cssClass="input-medium" path="district" />
							<form:errors path="district" cssClass="text-error" />
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="span6 row-fluid">
						<div class="span5">
							<label class="control-label">Type</label>
						</div>
						<div class="span7">
							<form:select path="type" items="${types}" class="form-control"></form:select>
							<form:errors path="type" cssClass="error" />
						</div>
					</div>
				</div>

					<div class="row-fluid">
						<form:button class="btn btn-group pull-right" tittle="Search"></form:button>
					</div>
			</form:form>

			<jsp:include page="/WEB-INF/jsp/addressesList.jsp"></jsp:include>
		</fieldset>
	</div>
</body>