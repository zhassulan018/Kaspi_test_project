<%@ page import="entity.Application" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: zhassulan
  Date: 8/14/21
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div class="row" style="margin: 20px">
    <div class="col-6 col-md-6 col-lg-4">
        <form class="card card-sm" action="" method="post">
            <div class="card-body row no-gutters align-items-center">
                <div class="col">
                    <input class="form-control form-control-sm form-control-borderless" type="search" name="search_bar" placeholder="ИИН" maxlength="12" minlength="12">
                </div>
                <div class="col-auto">
                    <button class="btn btn-sm btn-primary" type="submit" style="margin-left: 10px" name="operation" value="search">Найти</button>
                </div>
            </div>
            <div class="card-body" style="margin: -30px 0; color: blue">
                <p>Номер ИИН?</p>
            </div>
        </form>

        <%
            List applications = (List) request.getAttribute("applications");
            if(applications.size() != 0){
                Iterator<Application> applicationItertor = applications.iterator();
                Application app = null;
        %>
        <div class="well">
            <table class="table">
                <thead>
                <tr>
                    <th>Дата обращения</th>
                    <th>Номер заявки</th>
                    <th>Сумма</th>
                    <th>Срок</th>
                    <th>Статус</th>
                </tr>
                </thead>
                <tbody>
        <%
                while(applicationItertor.hasNext()){
                    app = applicationItertor.next();
        %>
                <tr>
                    <td><%=app.getDate()%></td>
                    <td><%=app.getApplicationNumber()%></td>
                    <td><%=app.getTotalMoney()%></td>
                    <td><%=app.getTerm()%></td>
                    <td><%=app.getStatus()%></td>
                </tr>
        <%}%>
                </tbody>
            </table>
            <form action="/client">
                <input type="submit" class="btn btn-primary" value="Новая заявка" />
            </form>
        </div>
        <%} %>
    </div>
</div>

</body>
</html>
