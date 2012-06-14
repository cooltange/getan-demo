<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Apache Shiro Spring-Hibernate Sample Application</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/sample.css"/>"/> 
</head>
<body>
    <div id="box">
        <div class="title">Apache Shiro Sample App - Login</div>

        <div class="content">
            <s:form action="login" namespace="/s">

                <s:actionerror cssClass="errors"/>

                <div><div class="form-label">Username:</div><s:textfield name="command.username" id='username'/></div>
                <div><div class="form-label">Password:</div><s:password name="command.password"/></div>
                <div><s:checkbox name="command.rememberMe"/> Remember Me</div>
                <div><s:submit value="Login"/></div>
            </s:form>

            <div>Don't have an account? <a href="<c:url value="/jsp/signup.jsp"/>">Sign up</a></div>
        </div>
    </div>

    <p>
        Users created through the signup form have the role "user".  You can also log in as admin/admin, which has the
        "admin" role.
    </p>

    <script type="text/javascript">
        document.getElementById('username').focus();
    </script>

</body>
</html>
