<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Result</title>
</head>

<body>
<h3>Uploaded Files:</h3>

<c:forEach items="${processedFiles.uploadedFiles}" var="file">
    <p>${file}</p><br/>
</c:forEach>

<h3>Failed:</h3>

<c:forEach items="${processedFiles.failedFiles}" var="file">
    <p>${file}</p><br/>
</c:forEach>

</body>
</html>
