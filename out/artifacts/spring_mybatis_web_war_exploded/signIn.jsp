<%--
  Created by IntelliJ IDEA.
  User: HanMengJie
  Date: 2020/3/14
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>sign In</title>
</head>

<script type="text/javascript">




</script>
<script type="text/javascript">
    //alert(<%=request.getParameter("message")==null?"":request.getParameter("message")%>)
</script>
<body>
    <form action="signin" method="post">
        用户名：<input type="text" name="newName" id="newName" value="" /><br />
        输入邮箱：<input type="email" name="newEmail" id="email" value="" /><br />
        输入验证码：<input type="text" value="" name="check" />
        输入密码：<input type="password" name="newPwd" id="pwd" value="" /><br />
        <a type="button" href="javascript:void(0)" id="send" >发送验证码</a><br>
        <input type="submit" value="确认注册" />

        <p id="myDiv" ></p>
        <p id="message" ><%=request.getParameter("message")==null?"":request.getParameter("message")%></p>
    </form>
    <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
    <script type="text/javascript">
    </script>

</body>
</html>
