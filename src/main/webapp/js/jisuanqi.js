/* 定义一个Calculator类*/
function Calculator() {

    // 传参数传进去三个分别是数字一、数字二和操作符（oper），res是存储结果的参数
    this.jisuan = function (num1, num2, oper) {
        var res = 0;
        switch (oper) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
        }
        return res;
    }
}
//创建对象
var calculator = new Calculator();

/*定义全局变量*/
var val = 0; //放置输入的值
var xval = 0;//保存转换Number类型的值
var temp = 0; //保存第一次输入的值   
var oper = "";//保存输入的操作符

/*获取输入数字*/
function inputEvent(e) {

    val = e.value
    var xsval = document.getElementById("inp1");
    xsval.value += val; //连续输入数字(String类型)
    //转换Number类型
    xval = parseFloat(xsval.value);

}

/*获取第一行的数据*/
function inputPCB(e) {
    //window.alert(e.value);
    var xsval = document.getElementById("inp1");
    if (e.value == "Clear") {
        xsval.value = "";
    }
}

/*输入操作符*/
function inputOper(e) {

    oper = e.value;
    //window.alert(typeof oper);
    //oper=oper.substr(0);
    if (e.value == "+") {
        var xsval = document.getElementById("inp1");
        //保存上次计算结果，并对字符串进行转换Number类型
        temp = parseFloat(xsval.value);
        //第一次输入的值设置为空
        xsval.value = "";
    } else if (e.value == "-") {
        var xsval = document.getElementById("inp1");
        temp = parseFloat(xsval.value);
        xsval.value = "";
    } else if (e.value == "*") {
        var xsval = document.getElementById("inp1");
        temp = parseFloat(xsval.value);
        xsval.value = "";
    } else if (e.value == "/") {
        var xsval = document.getElementById("inp1");
        temp = parseFloat(xsval.value);
        xsval.value = "";
    }
}

/*计算结果*/
function inputEquel(e) {

    var xsval = document.getElementById("inp1");
    if (e.value == "=") {
        //window.alert(xval);
        //调用对象方法
        xsval.value = calculator.jisuan(temp, xval, oper);
    }
}