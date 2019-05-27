<%--
  Created by IntelliJ IDEA.
  User: mindit
  Date: 5/25/2019
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quizzes Top</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/seeTop.css">
</head>
<body>

<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:70px">Top</h1>
    </div>
</div>

<div id="result" class="result">
    <pre>
        ${requestScope.top}
    </pre>
</div>


<!--
<select id="score", name="score">
    <c:forEach score="${requestScope.top}" var="score" >
        <option value = "${score.getScore()}"> ${score.getScore()} </option>
    </c:forEach>

</select>
-->
<!--
<tbody>
    <c:forEach items="${sessionScope.top}" var="sc">
        <tr>
            <td><c:out value="${sc.score}"/></td>
            <td><c:out value="${sc.quizName}"/></td>

        </tr>
    </c:forEach>

</tbody>
-->

</body>
</html>
