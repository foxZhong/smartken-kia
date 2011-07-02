<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="text/javascript" src="../JS/slide_effect.js"></script>
<script type="text/javascript" src="../JS/jquery.js"></script>
<title>无标题文档</title>
</head>

<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>

<script type="text/javascript">
   function showDiv(div)
   {
    
     var d=document.getElementById(div);
     if(d.style.display=="none" )
     {
       $('#'+div).slideDown("slow");
       //d.style.display="block";
     }
     else
     {$('#'+div).slideUp("slow");
     //d.style.display="none";
     }
   }
</script>
<body onload="timer()">
   <div id="navigation">
    
	
	<ul>
	<c:forEach var="model" items="${mods}">
	     
	     <li><a href="javascript:showDiv('Div${model.mid }')">${model.mdesc }</a></li>
	     <div class="model" id="Div${model.mid }" width="118" style="display:${model.display };">
	           <sql:query var="functions" dataSource="${con}">
	            SELECT f_name,f_url
                 FROM users,sys_function
                   where f_mid=? and u_grant regexp f_grant and u_id=?;
	           <sql:param value='${model.mid}'></sql:param>
	           <sql:param value='${user.uid}'></sql:param>
	           </sql:query>
	            <center><ul>  
	               <c:forEach var="funRow" items="${functions.rows}">
	                  <li><a href="../changefunction?mod=${model.mname}&fun=${funRow.f_url}">${funRow.f_name }</a></il>
	               </c:forEach>
	            </ul></center>
	      
	     </div>
	   
	</c:forEach></ul>	
   </div>
   <br>		
  <div id="search">  
			
		</div>
   <script type="text/javascript">
      function timer()
      {
        var today=new Date();
        var year=today.getYear();
        var month=today.getMonth()+1;
        var date=today.getDate();
        var day="";
        switch (today.getDay())
        {
         case 0: day="星期日";break;
         case 1: day="星期一";break;
         case 2: day="星期二";break;
         case 3: day="星期三";break;
         case 4: day="星期四";break;
         case 5: day="星期五";break;
         case 6: day="星期六";break;
        }
        var hour=today.getHours();
        var minute=today.getMinutes();
        var second=today.getSeconds();
        document.getElementById("search").innerHTML="&nbsp;&nbsp;"+
        year+"年"+month+"月"+date+"日&nbsp"+day+"<p>当前时间&nbsp;"+
        hour+":"+minute+":"+second;
        setTimeout(timer,1000);
      }
      
   </script>	

</body>
</html>
