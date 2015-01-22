<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>
<div  id="main-menu">
	<div class="accordion-group">
		<div class="accordion-heading">
			<a class="accordion-toggle" data-parent="#main-menu"
				href="<c:url value="/gui/users"/>"> Users
			</a>
		</div>
	</div>
		<div class="accordion-group">
		<div class="accordion-heading">
			<a class="accordion-toggle" data-parent="#main-menu"
				href="<c:url value="/gui/subaccounts"/>"> Subaccounts
			</a>
		</div>
	</div>
		<div class="accordion-group">
		<div class="accordion-heading">
			<a class="accordion-toggle" data-parent="#main-menu"
				href="<c:url value="/gui/addresses"/>"> Addresses
			</a>
		</div>
	</div>
		<div class="accordion-group">
		<div class="accordion-heading">
			<a class="accordion-toggle" data-parent="#main-menu"
				href="<c:url value="/gui/offers"/>"> Offers
			</a>
		</div>
	</div>
		<div class="accordion-group">
		<div class="accordion-heading">
			<a class="accordion-toggle" data-parent="#main-menu"
				href="<c:url value="/gui/transactions"/>"> Transactions
			</a>
		</div>
	</div>

</div>
