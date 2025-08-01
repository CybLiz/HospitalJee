<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/Components/bootstrapImports.html" />


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add a new patient</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            width: 50%;
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="mb-4 text-center">Add a new Patient</h1>

    <form action="${pageContext.request.contextPath}/patients" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="firstName" class="form-label">FirstName : </label>
            <input type="text" class="form-control" id="firstName" name="firstName" required>
        </div>

        <div class="mb-3">
            <label for="lastName" class="form-label">LastName :</label>
            <input type="text" class="form-control" id="lastName" name="lastName" required>
        </div>

        <div class="mb-3">
            <label for="dateOfBirth" class="form-label">Birth Date :</label>
            <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required>
        </div>

        <div class="mb-3">
            <label for="image" class="form-label">Upload you photo :</label>
            <input type="file" class="form-control" id="image" name="image" required>
        </div>

        <button type="submit" class="btn btn-primary w-100">Submit</button>
    </form>
</div>

</body>
</html>
