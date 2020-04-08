//点击验证码，60秒倒计时
var min ;
var time;
var falg = true ;
var newName;
$('.tableText').click(function() {
    if(falg){
        min = 60;
        clearInterval(time);
        time = setInterval(fn,1000);
        falg = false ;
        newName = $('#newName').val();
        //alert(newName);
        //alert(newName);
        var xmlhttp;
        if (window.XMLHttpRequest){
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else{
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function(){
            if (xmlhttp.readyState==4 && xmlhttp.status==200){
                alert(xmlhttp.responseText);
            }
        }
        var email;
        email = document.getElementById("newEmail").value ;
        xmlhttp.open("GET","check"+(email!=''?"?newEmail="+email+"&type=1":""),true);
        xmlhttp.send(null);

    }else{
        alert('正在发送！请稍后重试！');
    }
});

function fn(){
    min = --min;
    if(min>0){
        $('.tableText').html('（'+min +'秒）重发');
    }else{
        $('.tableText').html('发送验证码');
        falg = true ;
    }
}

function checkpwd() {
    var pwd;
    var rpwd;
    pwd = $("#newPwd").val();
    rpwd = $("#RnewPwd").val();
    if (pwd != rpwd) {
        document.getElementById("RnewPwd").placeholder = "两次密码不一致！";
        document.getElementById("RnewPwd").value = "";
        document.getElementById("RnewPwd").focus();

    }

}

$('#sendCode2').click(function() {
    if(falg){
        min = 60;
        clearInterval(time);
        time = setInterval(fn2,1000);
        falg = false ;
        //newName = $('#newName').val();
        //alert(newName);
        //alert(newName);
        var xmlhttp;
        if (window.XMLHttpRequest){
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else{
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function(){
            if (xmlhttp.readyState==4 && xmlhttp.status==200){
                alert(xmlhttp.responseText);
            }
        }
        var email;
        email = document.getElementById("email2").value ;
        xmlhttp.open("GET","check"+(email!=''?"?newEmail="+email+"&type=2":""),true);
        xmlhttp.send(null);

    }else{
        alert('正在发送！请稍后重试！');
    }
});


function fn2(){
    min = --min;
    if(min>0){
        $('#sendCode2').html('（'+min +'秒）重发');
    }else{
        $('#sendCode2').html('发送验证码');
        falg = true ;
    }
}