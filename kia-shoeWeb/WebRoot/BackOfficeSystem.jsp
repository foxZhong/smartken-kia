<%@ page language="java" import="java.util.*,shoes.entity.*,shoes.dao.*,shoes.dao.impl.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��̨�������</title>
<% 
	OrdersDao oDao = new OrdersDaoImpl();
	int count = oDao.findOStateCount();
	
%>
<SCRIPT language=JavaScript>  
<!--  
 
/**//*  
*    ��Ϣ����  
*/  
function CLASS_MSN_MESSAGE(id,width,height,caption,title,message,target,action){  
    this.id     = id;  
    this.title  = title;  
    this.caption= caption;  
    this.message= message;  
    this.target = target;  
    this.action = action;  
    this.width    = width?width:200;  
    this.height = height?height:120;  
    this.timeout= 150;  
    this.speed    = 20; 
    this.step    = 1; 
    this.right    = screen.width -1;  
    this.bottom = screen.height; 
    this.left    = this.right - this.width; 
    this.top    = this.bottom - this.height; 
    this.timer    = 0; 
    this.pause    = false;
    this.close    = false;
    this.autoHide    = true;
}  
  
/**//*  
*    ������Ϣ����  
*/  
CLASS_MSN_MESSAGE.prototype.hide = function(){  
    if(this.onunload()){  

        var offset  = this.height>this.bottom-this.top?this.height:this.bottom-this.top; 
        var me  = this;  

        if(this.timer>0){   
            window.clearInterval(me.timer);  
        }  

        var fun = function(){  
            if(me.pause==false||me.close){
                var x  = me.left; 
                var y  = 0; 
                var width = me.width; 
                var height = 0; 
                if(me.offset>0){ 
                    height = me.offset; 
                } 
     
                y  = me.bottom - height; 
     
                if(y>=me.bottom){ 
                    window.clearInterval(me.timer);  
                    me.Pop.hide();  
                } else { 
                    me.offset = me.offset - me.step;  
                } 
                me.Pop.show(x,y,width,height);    
            }             
        }  

        this.timer = window.setInterval(fun,this.speed)      
    }  
}  
  
/**//*  
*    ��Ϣж���¼���������д  
*/  
CLASS_MSN_MESSAGE.prototype.onunload = function() {  
    return true;  
}  
/**//*  
*    ��Ϣ�����¼���Ҫʵ���Լ������ӣ�����д��  
*  
*/  
CLASS_MSN_MESSAGE.prototype.oncommand = function(){  
    //this.close = true;
    this.hide();  
	window.open("");
   
} 
/**//*  
*    ��Ϣ��ʾ����  
*/  
CLASS_MSN_MESSAGE.prototype.show = function(){  

    var oPopup = window.createPopup(); //IE5.5+  
    
    this.Pop = oPopup;  
  
    var w = this.width;  
    var h = this.height;  
  
    var str = "<DIV style='BORDER-RIGHT: #455690 1px solid; BORDER-TOP: #a6b4cf 1px solid; Z-INDEX: 99999; LEFT: 0px; BORDER-LEFT: #a6b4cf 1px solid; WIDTH: " + w + "px; BORDER-BOTTOM: #455690 1px solid; POSITION: absolute; TOP: 0px; HEIGHT: " + h + "px; BACKGROUND-COLOR: #c9d3f3'>"  
        str += "<TABLE style='BORDER-TOP: #ffffff 1px solid; BORDER-LEFT: #ffffff 1px solid' cellSpacing=0 cellPadding=0 width='100%' bgColor=#cfdef4 border=0>"  
        str += "<TR>"  
        str += "<TD style='FONT-SIZE: 12px;COLOR: #0f2c8c' width=30 height=24></TD>"  
        str += "<TD style='PADDING-LEFT: 4px; FONT-WEIGHT: normal; FONT-SIZE: 12px; COLOR: #1f336b; PADDING-TOP: 4px' vAlign=center width='100%'>" + this.caption + "</TD>"  
        str += "<TD style='PADDING-RIGHT: 2px; PADDING-TOP: 2px' vAlign=center align=right width=19>"  
        str += "<SPAN title=�ر� style='FONT-WEIGHT: bold; FONT-SIZE: 12px; CURSOR: hand; COLOR: red; MARGIN-RIGHT: 4px' id='btSysClose' >��</SPAN></TD>"  
        str += "</TR>"  
        str += "<TR>"  
        str += "<TD style='PADDING-RIGHT: 1px;PADDING-BOTTOM: 1px' colSpan=3 height=" + (h-28) + ">"  
        str += "<DIV style='BORDER-RIGHT: #b9c9ef 1px solid; PADDING-RIGHT: 8px; BORDER-TOP: #728eb8 1px solid; PADDING-LEFT: 8px; FONT-SIZE: 12px; PADDING-BOTTOM: 8px; BORDER-LEFT: #728eb8 1px solid; WIDTH: 100%; COLOR: #1f336b; PADDING-TOP: 8px; BORDER-BOTTOM: #b9c9ef 1px solid; HEIGHT: 100%'>" + this.title + "<BR><BR>"  
        str += "<DIV style='WORD-BREAK: break-all' align=left><A href='javascript:void(0)' hidefocus=false id='btCommand'><FONT color=#ff0000>" + this.message + "</FONT></A> - <A href='http://www.makewing.com' hidefocus=false id='ommand'><FONT color=#ff0000>T03��������</FONT></A></DIV>"  
        str += "</DIV>"  
        str += "</TD>"  
        str += "</TR>"  
        str += "</TABLE>"  
        str += "</DIV>"  
  
    oPopup.document.body.innerHTML = str; 
    
  
    this.offset  = 0; 
    var me  = this;  

    oPopup.document.body.onmouseover = function(){me.pause=true;}
    oPopup.document.body.onmouseout = function(){me.pause=false;}

    var fun = function(){  
        var x  = me.left; 
        var y  = 0; 
        var width    = me.width; 
        var height    = me.height; 

            if(me.offset>me.height){ 
                height = me.height; 
            } else { 
                height = me.offset; 
            } 

        y  = me.bottom - me.offset; 
        if(y<=me.top){ 
            me.timeout--; 
            if(me.timeout==0){ 
                window.clearInterval(me.timer);  
                if(me.autoHide){
                    me.hide(); 
                }
            } 
        } else { 
            me.offset = me.offset + me.step; 
        } 
        me.Pop.show(x,y,width,height);    

    }  
  
    this.timer = window.setInterval(fun,this.speed)      
  
     
  
    var btClose = oPopup.document.getElementById("btSysClose");  
  
    btClose.onclick = function(){  
        me.close = true;
        me.hide();  
    }  
  
    var btCommand = oPopup.document.getElementById("btCommand");  
    btCommand.onclick = function(){  
        me.oncommand();  
    }    
	 var ommand = oPopup.document.getElementById("ommand");  
      ommand.onclick = function(){  
       //this.close = true;
    me.hide();  
	window.open(ommand.href);
    }   
}  
/**//* 
** �����ٶȷ��� 
**/ 
CLASS_MSN_MESSAGE.prototype.speed = function(s){ 
    var t = 20; 
    try { 
        t = praseInt(s); 
    } catch(e){} 
    this.speed = t; 
} 
/**//* 
** ���ò������� 
**/ 
CLASS_MSN_MESSAGE.prototype.step = function(s){ 
    var t = 1; 
    try { 
        t = praseInt(s); 
    } catch(e){} 
    this.step = t; 
} 
  
CLASS_MSN_MESSAGE.prototype.rect = function(left,right,top,bottom){ 
    try { 
        this.left        = left    !=null?left:this.right-this.width; 
        this.right        = right    !=null?right:this.left +this.width; 
        this.bottom        = bottom!=null?(bottom>screen.height?screen.height:bottom):screen.height; 
        this.top        = top    !=null?top:this.bottom - this.height; 
    } catch(e){} 
} 
var MSG1 = new CLASS_MSN_MESSAGE("aa",200,120,"������ʾ��","��û�д���Ķ�����","<%=count%>��");  
    MSG1.rect(null,null,null,screen.height-50); 
    MSG1.speed    = 10; 
    MSG1.step    = 5; 
    //alert(MSG1.top); 
    MSG1.show();  

//ͬʱ��������˸��ֻ���ò�����ˣ������㲻���� 
//var MSG2 = new CLASS_MSN_MESSAGE("aa",200,120,"����Ϣ��ʾ��","����2����Ϣ","�õİ�");  
//   MSG2.rect(100,null,null,screen.height); 
//    MSG2.show();  
//-->  
</SCRIPT>
<script language="javascript" type="text/javascript">
function onClick(op){
	for(var i=1;i<=4;i++){
		if(op==i){
			if(document.getElementById("d"+i).style.display=="none"){
				document.getElementById("d"+i).style.display="block";
			}else{
				document.getElementById("d"+i).style.display="none";
			}			
		}else{
			document.getElementById("d"+i).style.display="none";
		}
	}			
}
</script>	
<link rel="stylesheet" type="text/css" href="css/BackOfficeSystem.css"/>
<link rel="stylesheet" type="text/css" href="css/page.css"/>
</head>

<body>
	<div style="float: left; width:16%; height:550px; background-color: #EFEFEF; border:solid #698CC3 1px">
		<br />
		<table align="center" width="100%" border="0" cellpadding="3" cellspacing="0" class="font">
			<tr align="center">
				<td>ϵͳ��̨�������</td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('1');" class="font">�û�����</a><div id="d1" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddAdmin.jsp">			
									<span class="left"></span>
										��ӹ���Ա
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeUser.jsp">
									<span class="left"></span>
										�û�����
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('2');" class="font">��Ʒ����</a><div id="d2" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddWare.jsp">			
									<span class="left"></span>
										�����Ʒ
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeSuperviseWare.jsp">
									<span class="left"></span>
										������Ʒ
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('3');" class="font">���Ź���</a><div id="d3" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddNews.jsp">
									<span class="left"></span>
										�������
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeSuperviseNews.jsp">
									<span class="left"></span>
										��������
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('4');" class="font">��������</a><div id="d4" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeSystem.jsp">
									<span class="left"></span>
										�鿴����
									<span class="right"></span></a></td>
							</tr>							
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="manage/doLogout.jsp" class="font">[��ȫ�ǳ�]</a></td>
			</tr>
		</table>
	</div>
	<div style="float: left;width:82%; height:550px; border:solid #698CC3 1px; border-left-width:15px; background-color:#F1F7F9;">
		<div style="position:relative; top:30px; left:30px; width:750px; border:solid #698CC3 1px;">	
			<form action="BackOfficeSystem.jsp" method="post" name="Orderfrom">
				<table class="font" width="100%" height="100%" border="1" bordercolor="#D6E0EF" cellpadding="3" cellspacing="0">
					<tr>
						<td colspan="7" bgcolor="#698CC3" class="font1">��������</td>
					</tr>
					<tr>
						<th>�������</th>
						<th>�˿�����</th>
						<th>�绰</th>
						<th>��ַ</th>
						<th>����ʱ��</th>
						<th>״̬</th>
						<th>����</th>
					</tr>
					<%	int current=1;
						if(request.getParameter("current")!=null){
							current = Integer.parseInt(request.getParameter("current"));
						}										
						String number = request.getParameter("number");
						OrdersDaoImpl od = new OrdersDaoImpl();
						List list = new ArrayList();
						if(number!=null && number!=""){
							list = od.findOrders(number,current);
						}else{
							list = od.findOrders(current);
						}					
						String result = "";
						for(int i=0; i<list.size(); i++) {
							Orders orders = (Orders)(list.get(i));
							DeliveryInfoDao did = new DeliveryInfoDaoImpl();
							if(orders.getOState().equals("δ����")) {
								result = "����";
							}else {
								result = "&nbsp;";
							}
					%>
					<tr align="center">
						<td><a class="font2" href="BackOfficeOrderInfo.jsp?oid=<%=orders.getOId() %>"><%=orders.getNumber() %></a></td>
						<td><%=did.findDeliveryInfo(orders.getODId()).getDName() %></td>
						<td><%=did.findDeliveryInfo(orders.getODId()).getTel() %></td>
						<td><%=did.findDeliveryInfo(orders.getODId()).getAddress() %></td>
						<td><%=orders.getStartTime().substring(0,10) %></td>
						<td><%=orders.getOState() %></td>
						<td><a class="font2" href="manage/doOrders.jsp?OId=<%=orders.getOId() %>"><%=result %></a></td>
					</tr>
					<%} %>
				</table>				
				<br /><div align="right" class="font">�����붩���ţ�<input name="number" type="text" /><input type="submit" value="��ѯ" /></div>
			</form>
			<script type="text/javascript" >          
		       function getCurrent()
		       {
		          var current = document.getElementById("txt").value;
		          document.form1.current.value=current;
		          document.form1.submit();
		       }
		    
		    </script>
		    <form action="BackOfficeSystem.jsp" method="post" name="form1">
		    	<input type="hidden" name="current" value="<%=current %>"/>
		    </form>		                 
		    <% 	
		    	int sumNum = od.findOrders(number).size();
		    	int SumPage = sumNum/6 + (sumNum%6==0?0:1);
		    %>		    
			<table id="page" border="1" bordercolor="#989898" cellpadding="0" cellspacing="10" align="center">
				<tr>
					<td class="bg2">
					<% 
						if(current==1){
							out.print("��һҳ");
						}else{
							out.print("<a class='bg1' href='BackOfficeSystem.jsp?current=1'>��һҳ</a>");
						}
					%>
					</td>
			    	<%
			    		for(int i=1;i<=SumPage;i++){ 
				    		if(current==i){
				    			out.print("<td class='bg3'>&nbsp;"+i+"&nbsp;</td>");
				    		}else{
				    			out.print("<td>&nbsp;<a class='bg1' href='BackOfficeSystem.jsp?current="+i+"'>"+i+"</a>&nbsp;</td>");
				    		}
			    		}
			    	%>
					<td class="bg2">
					<% 
						if(current==SumPage){
							out.print("��ĩҳ(��"+SumPage+"ҳ)");
						}else{
							out.print("<a class='bg1' href='BackOfficeSystem.jsp?current="+SumPage+"'>��ĩҳ(��"+SumPage+"ҳ)</a>");
						}
					%>
					</td>
					<td class="bg5"><input class="bg6" type="text" size="1" id="txt" value="<%=current %>" /></td>
					<td class="bg3"><input class="bg4" type="button" value=" Go " onclick="getCurrent()" /></td>					
			    </tr>
		    </table>			
		</div>
	</div>
</body>
</html>
