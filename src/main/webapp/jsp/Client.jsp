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
    <title>Данные о клиенте</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script>
        window.addEventListener("DOMContentLoaded", function() {
            [].forEach.call( document.querySelectorAll('.tel'), function(input) {
                var keyCode;
                function mask(event) {
                    event.keyCode && (keyCode = event.keyCode);
                    var pos = this.selectionStart;
                    if (pos < 3) event.preventDefault();
                    var matrix = "+7 (___) ___ ____",
                        i = 0,
                        def = matrix.replace(/\D/g, ""),
                        val = this.value.replace(/\D/g, ""),
                        new_value = matrix.replace(/[_\d]/g, function(a) {
                            return i < val.length ? val.charAt(i++) || def.charAt(i) : a
                        });
                    i = new_value.indexOf("_");
                    if (i != -1) {
                        i < 5 && (i = 3);
                        new_value = new_value.slice(0, i)
                    }
                    var reg = matrix.substr(0, this.value.length).replace(/_+/g,
                        function(a) {
                            return "\\d{1," + a.length + "}"
                        }).replace(/[+()]/g, "\\$&");
                    reg = new RegExp("^" + reg + "$");
                    if (!reg.test(this.value) || this.value.length < 5 || keyCode > 47 && keyCode < 58) this.value = new_value;
                    if (event.type == "blur" && this.value.length < 5)  this.value = ""
                }

                input.addEventListener("input", mask, false);
                input.addEventListener("focus", mask, false);
                input.addEventListener("blur", mask, false);
                input.addEventListener("keydown", mask, false)
            });

        });
    </script>

</head>

<body>
<main class="my-form" style="margin:100px 0">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">Данные о клиенте</div>
                    <b><span style="color: red; "> <%=MessageUtil.getErrorMessage(request)%></span></b>
                    <div class="card-body">
                        <form name="my-form" action="" method="post">
                            <div class="form-group row">
                                <label for="iin" class="col-md-4 col-form-label text-md-right">ИИН</label>
                                <div class="col-md-6">
                                    <input type="text" id="iin" class="form-control" name="iin" maxlength="12" minlength="12">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="lastname" class="col-md-4 col-form-label text-md-right">Фамилия</label>
                                <div class="col-md-6">
                                    <input type="text" id="lastname" class="form-control" name="lastname">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="firstname" class="col-md-4 col-form-label text-md-right">Имя</label>
                                <div class="col-md-6">
                                    <input type="text" id="firstname" class="form-control" name="firstname">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="fathername" class="col-md-4 col-form-label text-md-right">Отчество</label>
                                <div class="col-md-6">
                                    <input type="text" id="fathername" class="form-control" name="fathername">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="phone_number" class="col-md-4 col-form-label text-md-right">Мобильный телефон</label>
                                <div class="col-md-6">
                                    <input type="text" id="phone_number" class="form-control tel" name="phone">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="birthday" class="col-md-4 col-form-label text-md-right">Дата рождения</label>
                                <div class="col-md-6">
                                    <input type="date" id="birthday" class="form-control" name="birthday">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-md-4 col-form-label text-md-right">Пол</label>
                                <div class="col-md-6">
                                    <input type="radio" id="male" name="sex" value="male" checked>
                                    <label for="male">M</label>

                                    <input type="radio" id="female" name="sex" value="female">
                                    <label for="female">Ж</label>
                                </div>
                            </div>
                            <hr>
                            <div class="form-group row">
                                <label for="document_number" class="col-md-4 col-form-label text-md-right">Номер документа</label>
                                <div class="col-md-6">
                                    <input type="text" id="document_number" class="form-control" name="document_number">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="givenDepartment" class="col-md-4 col-form-label text-md-right">Кем выдан</label>
                                <div class="col-md-6">
                                    <input type="text" id="givenDepartment" class="form-control" name="given_department">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="given_date" class="col-md-4 col-form-label text-md-right">Дата выдачи</label>
                                <div class="col-md-6">
                                    <input type="date" id="given_date" class="form-control" name="given_date">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="outofdate" class="col-md-4 col-form-label text-md-right">Действителен до</label>
                                <div class="col-md-6">
                                    <input type="date" id="outofdate" class="form-control" name="outofdate">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="salary" class="col-md-4 col-form-label text-md-right">Заработная плата</label>
                                <div class="col-md-6">
                                    <input type="text" id="salary" class="form-control" name="salary">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="expenditure" class="col-md-4 col-form-label text-md-right">Коммунальные платежи, аренда</label>
                                <div class="col-md-6">
                                    <input type="text" id="expenditure" class="form-control" name="expenditure">
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
