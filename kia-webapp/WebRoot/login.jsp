<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <jsp:include page="/plugin/index.jsp?plugin=jquery,easyui"></jsp:include>
     <jsp:include page="/css/index.jsp"></jsp:include>
     <jsp:include page="/js/index.jsp"></jsp:include>

   
   <script type="text/javascript">
   
     $(document).ready(function(){
       
       $("#loginDiv").dialog({
              title:"系统登录",
              modal:true,
              width:400,
              height:300
       });
     
     });
    
   </script>

  </head>
  
  <body>
    <form action="sys/user/login.action" method="post">
    <div id="loginDiv" style="padding: 1%">
       <table class="editTable" style="width: 100%">
        <tr>
          <td class="tdLabel">登录帐号</td>
          <td><input name="loginId" type="text"/ class="tdInput easyui-validatebox" required="true"></td>
        </tr>
        <tr>
          <td class="tdLabel">登录密码</td>
          <td><input name="loginPwd" type="password" class="tdInput easyui-validatebox" required="true"></td>
        </tr>
        <tr>
          <td colspan="2">
                  <button type="submit">登录</button>
                  <button type="reset">清空</button>
           </td>
        </tr>
       </table>
    </form>
    </div>
  </body>
</html>
