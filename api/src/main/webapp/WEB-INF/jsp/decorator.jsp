<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Aplikacja Głosowa Obsługi Banku </title>
    <script type="text/javascript">
    </script>
    <script type="text/javascript" src="<c:url value="/js/jquery-1.10.2.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap-datepicker.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/display-tag-ajax.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.countdown.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/json2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/form2js.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/js2form.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/css/jquery-ui.css"/>">
    <script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>


    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/datepicker.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/jquery-ui.css"/>">
</head>
<body>
<script type="text/javascript">
    var sessionTimeout = "${pageContext.request.session.maxInactiveInterval}";
    var contextPath = "${pageContext.request.contextPath}";
</script>

    <%--HEADERS--%>
    <div class="row-fluid ex-header-row">
        <div class="span10">
            <a href="<c:url value="/"/>">
    					<img src="<c:url value="/img/logo.gif"/>" alt="Logo">
            </a>
        </div>
        <div class="span2">
        </div>
    </div>
  <%--MENU--%>
    <div class="row-fluid">
        <div class="span3">
            <div class="ex-well-wrapper">
                <div class="well">
                    <div class="ex-well-inner">
                        <jsp:include page="/WEB-INF/jsp/commons/menu.jsp"/>
                    </div>
                </div>
            </div>
        </div>

        <%--PAGE Content--%>
        <div class="span8">
            <div class="ex-well-wrapper">
                <div class="well">
                    <div class="ex-well-inner">
                        <sitemesh:write property='body' />
                    </div>
                </div>
            </div>
        </div>
        <div class="span1"></div>
    </div>
</body>
</html>