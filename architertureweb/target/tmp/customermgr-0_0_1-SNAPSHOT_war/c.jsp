<html>
	<body>
		<h2>hello world customermgr</h2>
		<%@page import="com.wwn.customermgr.App" %>
		<%
			System.out.println("customermgr test index");
			new com.wwn.customermgr.App().testCustomermgr();
		%>
	</body>
</html>