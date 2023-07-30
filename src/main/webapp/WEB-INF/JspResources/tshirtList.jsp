<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Matching Tshirts</title>
    <style>
        fieldset {
            border-radius: 4px;
        }

        div {
            width: 400px;
            margin-left: calc(50% - 200px);
            margin-bottom: 30px;
        }

        form input {
            float: right;
            margin-right: 20px;
            border: 0.5px solid black;
        }

        table {
            width: 60%;
            margin: auto;
        }

        table, tr, td, th {
            border: 1px solid #000000;
            border-collapse: collapse;
            text-align: center;
        }

        p {
            font-size: small;
            float: right;
            color: red;
        }
    </style>
</head>
<body>
<a href="logout" style="float: left">
    <button>sign out</button>
</a>
<p>${loginedUser.userId} is currently logged in .</p>
<div id="tshirtSearch">
    <fieldset>
        <legend>Tshirt Search Details</legend>
        <form method="post" action="" id="registrationForm">
            <label>Colour <input value="${tshirtDetails.color}" disabled></label>
            <br><br>
            <label>Size <input value="${tshirtDetails.size}" disabled></label>
            <br><br>
            <label>Gender <input value="${tshirtDetails.gender}" disabled></label>
            <br><br>
            <label>Output Preference <input
                    value="${tshirtDetails.outputPreference==1?'Sort By Price':'Sort By Duration'}" disabled></label>
            <br>
        </form>
    </fieldset>
</div>

<table>
    
    <tr>
        <th>S.no.</th>
        <th>ID</th>
        <th>NAME</th>
        <th>COLOUR</th>
        <th>GENDER_RECOMMENDATION</th>
        <th>SIZE</th>
        <th>PRICE</th>
        <th>RATING</th>
        <th>AVAILABILITY</th>
        
    </tr>

    <c:forEach var="listValue" items="${list}" varStatus="status">
        <tr>
            <td> ${status.index +1} </td>
            <td> ${listValue.id} </td>
            <td> ${listValue.name} </td>
            <td> ${listValue.color} </td>
            <td> ${listValue.gender} </td>
            <td> ${listValue.size} </td>
            <td> ${listValue.price} </td>
            <td> ${listValue.rating} </td>
            <td> ${listValue.availability} </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>