
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/Components/bootstrapImports.html" />


<div class="container" >
    <h1 class="mb-4 text-center">Patients List</h1>

    <ul class="list-group">
        <c:forEach var="patient" items="${patients}">
            <li class="list-group-item">
                <strong>${patient.firstname}</strong>
                <strong>${patient.lastname}</strong>
                <p>Date of birth : ${patient.dateOfBirth} </p>
                <p>Birthdate : ${patient.dateOfBirth}</p>
                <p>Image : ${patient.image}</p>
                <button type="submit" class="btn btn-primary w-100">Supprimer</button>
                <button type="submit" class="btn btn-primary w-100">Modifier</button>


            </li>

        </c:forEach>

        <c:if test="${patients.size() == 0}">
            <p  class="mb-4 text-center">No patients found</p>
        </c:if>
    </ul>
</div>

