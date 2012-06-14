<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Apache Shiro Spring-Hibernate Sample Application</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/sample.css"/>"/>
</head>
<body>
    <div id="box">
        <div class="title">Apache Shiro Sample App - Signup</div>

        <div class="content">
            <s:form action="signup">

                <s:actionerror cssClass="errors"/>

                <div><div class="form-label">Username:</div><s:textfield name="user.username" id='username'/></div>
                <div><div class="form-label">Email:</div><s:textfield name="user.email"/></div>
                <div><div class="form-label">Password:</div><s:password name="user.password"/></div>
                <div><input type="button" onclick="document.location.href='<c:url value="/s/login.action"/>'" value="Cancel"/>&nbsp;<input type="submit" value="Signup"/></div>
            </s:form>
        </div>
    </div>

    <script type="text/javascript">
        document.getElementById('username').focus();
    </script>

</body>
</html>
