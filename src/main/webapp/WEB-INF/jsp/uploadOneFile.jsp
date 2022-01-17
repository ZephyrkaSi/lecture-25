<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Upload One File</title>
</head>

<body>
<b>Upload One File:</b>
<br/>
<form:form action="/uploadOneFile" method="post" modelAttribute="uploadForm" enctype="multipart/form-data">
    <form:label path="fileData">File to upload: </form:label> <form:input type="file" path="fileData"/>
    <input type="submit" value="submit"/>
</form:form>

</body>
</html>