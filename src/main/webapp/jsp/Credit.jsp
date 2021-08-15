<%@ page import="utility.MessageUtil" %><%--
  Created by IntelliJ IDEA.
  User: zhassulan
  Date: 8/14/21
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Данные о кредите</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="../script/calculation.js"></script>
</head>

<body>
<main class="my-form" style="margin:100px 0">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Данные о кредите</div>
                    <b><span style="color: red; "> <%=MessageUtil.getErrorMessage(request)%></span></b>
                    <div class="card-body">
                        <form name="my-form" action="" method="post">
                            <div class="form-group row">
                                <label for="money" class="col-md-4 col-form-label text-md-right">Сумма</label>
                                <div class="col-md-6">
                                    <input type="text" id="money" class="form-control" name="money" onchange="func()">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="term" class="col-md-4 col-form-label text-md-right">Срок: </label>
                                <div class="col-md-6">
                                <select id="term" name="term" class="form-control" onchange="func()">
                                    <option value=""></option>
                                    <option value="3">3</option>
                                    <option value="6">6</option>
                                    <option value="9">9</option>
                                    <option value="12">12</option>
                                    <option value="24">24</option>
                                </select>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="percentage" class="col-md-4 col-form-label text-md-right">Ставка: </label>
                                <div class="col-md-6">
                                <select id="percentage" name="percentage" class="form-control" onchange="func()">
                                    <option value=""></option>
                                    <option value="9">9%</option>
                                    <option value="10">10%</option>
                                    <option value="11">11%</option>
                                </select>
                                </div>
                            </div>

                            <hr>

                            <div class="form-group row">
                                <label for="month_payment" class="col-md-4 col-form-label text-md-right">Еж. платеж</label>
                                <div class="col-md-6">
                                    <input type="text" id="month_payment" class="form-control" name="month_payment" readonly>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="money_dollar" class="col-md-4 col-form-label text-md-right">Сумма в $</label>
                                <div class="col-md-6">
                                    <input type="text" id="money_dollar" class="form-control tel" name="money_dollar" readonly>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="total_payment" class="col-md-4 col-form-label text-md-right">Общая сумма выплат</label>
                                <div class="col-md-6">
                                    <input type="text" id="total_payment" class="form-control" name="total_payment" readonly>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="overpayment" class="col-md-4 col-form-label text-md-right">Переплата</label>
                                <div class="col-md-6">
                                    <input type="text" id="overpayment" class="form-control" name="Overpayment" readonly>
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    Подтвердить
                                </button>
                                <a href="/search" class="btn btn-primary">
                                    Новый поиск
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</html>
