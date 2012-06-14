<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Apache Shiro Spring-Hibernate Sample Application</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/styles/sample.css"/>"/>
</head>
<body>
    <div id="box">
        <div class="title">Apache Shiro Sample App - Edit User</div>

        <div class="content">
           <s:form action="updateUser" namespace="/s">
				<s:hidden name="command.userId"/>
                <s:actionerror cssClass="errors"/>
                
                <div><div class="form-label">Username:</div><s:textfield name="command.username" id='username'/></div>
                <div><div class="form-label">Email:</div><s:textfield name="command.email"/></div>
                <div><div class="form-label">Password:</div><s:password name="command.password"/></div>
                <div><input type="button" onclick="document.location.href='<c:url value="/s/manageUsers.action"/>'" value="Cancel"/>&nbsp;<input type="submit" value="Save Changes"/></div>
            </s:form>

            <p>Only edit the password field if you want to change the user's password.  Otherwise leave password blank.</p>
            
        </div>

    </div>

    <script type="text/javascript">
        document.getElementById('username').focus();
    </script>

</body>
</html>
