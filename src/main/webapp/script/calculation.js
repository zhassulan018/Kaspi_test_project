function func(){
    toDollar();
    everyMonth();
    left()
}

function toDollar() {
    var x = document.getElementById("money_dollar");
    var y = document.getElementById("money");
    x.value = (y.value / 425.16).toFixed(2);
}

function everyMonth(){
    var money = document.getElementById("money");
    var per = document.getElementById("percentage");
    var month = document.getElementById("term");

    var x = per.value/1200;
    var y = x * Math.pow(x+1,month.value)/(Math.pow(x+1,month.value) - 1);

    var payment = document.getElementById("month_payment");

    payment.value = (y * money.value).toFixed(2);
}

function left() {
    var payment = document.getElementById("month_payment");
    var total_payment = document.getElementById("total_payment");
    var month = document.getElementById("term");
    var money = document.getElementById("money");

    total_payment.value = (payment.value * month.value).toFixed(2);

    var overpayment = document.getElementById("overpayment");
    overpayment.value = (total_payment.value - money.value).toFixed(2);
}