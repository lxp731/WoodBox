var user = document.getElementById("user");
var error = document.getElementsByClassName("error");
var pwd = document.getElementById("pwd");
var pwd2 = document.getElementById("pwd2");

// onchange：内容改变；onfoucs：获得焦点；onblur：失去焦点。
user.onchange = checkuser;/* 函数名，不是调用函数。 */
pwd.onchange = checkpwd;
pwd2.onchange = checkpwd2;

function checkuser() {
    if (user.value.length >= 3  && user.value.length < 16) {
        error[0].style.display = "none";
        return 1;
    }
    else {
        error[0].style.display = "block";
        return 0;
    }
}

function checkpwd() {
    if (pwd.value.length >= 3 && pwd.value.length < 16) {
        error[1].style.display = "none";
        return 1;
    }
    else {
        error[1].style.display = "block";
        return 0;
    }
}

function checkpwd2() {
    if (pwd.value == pwd2.value) {
        error[2].style.display = "none";
        return 1;
    }
    else {
        error[2].style.display = "block";
        return 0;
    }
}

function checkform() {
    var rs = checkuser() * checkpwd() * checkpwd2();

    if (rs === 0) {
        return false;
    }
    else {
        true;
    }
}