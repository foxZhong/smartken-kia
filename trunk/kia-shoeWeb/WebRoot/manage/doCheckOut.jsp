<%@ page language="java" import="java.util.*,shoes.dao.impl.*,shoes.dao.*,shoes.entity.*" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
      UserInfo user=(UserInfo)session.getAttribute("user"); 
      List items=(List)session.getAttribute("items");
      CommodityInfoDao cDao = new CommodityInfoDaoImpl();
      CommodityInfo cInfo = new CommodityInfo();
      int result = 0;
      for(int i=0;i<items.size();i++){
      	  OrderItem oItem = (OrderItem)items.get(i);
	      if(oItem.getItemCount()>=2){
	      	  for(int j=0;j<oItem.getItemCount();j++){    	  
	      	  	  result = cDao.update(oItem.getItemCid());
	      	  }
	      }else{
	      	  result = cDao.update(oItem.getItemCid());
	      }
      }
      int odid=Integer.parseInt(request.getParameter("odId"));
      OrdersDao odao=new OrdersDaoImpl();
      Orders o=new Orders();
      o.setODId(odid);
      odao.addOrders(o,"",items);
      System.out.println("Ìí¼Ó¶©µ¥³É¹¦");
      session.setAttribute("items",new ArrayList());
      response.sendRedirect("../myCar.jsp");
%>
</body>
</html>