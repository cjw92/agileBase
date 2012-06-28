<%
String requestURL = request.getRequestURL().toString();
boolean live = false;
if (requestURL.contains("appserver.")) {
  live = true;
}
%>
<html>
<head>
	<title>agileBase</title>
	<link rel="icon" href="/agileBase/website/gtpb.ico" type="image/x-icon"> <!-- favicon --> 
	<script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-59206-20']);
	  _gaq.push(['_trackPageview']);
	
	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>
</head>
<body>
	Please wait a moment...
	<% if(live) { %>
		<form method="POST" action="https://appserver.gtportalbase.com/agileBase/j_security_check" name="loginform" id="loginform">
	<% } else { %>
		<form method="POST" action="http://backup.agilebase.co.uk:8080/agileBase/j_security_check" name="loginform" id="loginform">
	<% } %>
	username is <%= request.getParameter("name") %><br />
	<input type="text" name="j_username" id="j_username" /><br>
	password<br />
	<input type="password" name="j_password" id="j_password" /><br><br>
	<input type="submit" value="login">
	</form>
</body>
</html>