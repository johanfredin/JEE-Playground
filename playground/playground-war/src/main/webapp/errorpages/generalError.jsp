<%@ page isErrorPage="true"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/style/common.css" type="text/css" rel="stylesheet" />

</head>
<body class="error">
	<div class="floatLeft errorImageDiv">
		<img src="<%=request.getContextPath()%>/images/warning.png">
	</div>
	<div class="floatLeft errorParagraph">
		<h1>An error occurred</h1>
		<p>An error occurred, sorry for that.</p>
		<p>
			Error message from the server:<br> <b>${pageContext.exception }</b>
		</p>
	</div>
	<div class="clear"></div>
</body>
</html>