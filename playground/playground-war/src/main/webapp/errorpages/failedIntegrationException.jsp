<%@ page isErrorPage="true"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/style/common.css" type="text/css" rel="stylesheet" />
</head>
<body class="error">
	<div class="floatLeft">
		<img src="<%=request.getContextPath()%>/images/integration.png">
	</div>
	<div class="floatLeft errorParagraph">
		<h1>Ooops, one of our systems is down</h1>
		<p>Running an enterprise system is complicated business. Many systems need to be up and running at the same time.
			But one or more of those systems is not working right now.</p>
		<p>
			Error message:<br> <b>${pageContext.exception }</b>
		</p>
	</div>
	<div class="clear"></div>
</body>
</html>