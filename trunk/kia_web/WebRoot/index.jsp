<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <jsp:include page="/plugin/index.jsp?plugin=jquery,easyui"></jsp:include>
  <jsp:include page="/css/index.jsp"></jsp:include>
  <jsp:include page="/js/index.jsp"></jsp:include>
  <script type="text/javascript">
     $(document).ready(function(){
    	   $("#mainTabs").tabs('add',{
			   title:"信息中心",
			   closable:false,
			   content:"<iframe src='infocenter.jsp' scrolling='no' frameborder='0'></iframe>"
		    });
    	 
    		$('#MenuTreeNode').tree({
				url: 'sys/menu/list-Tree.action',
				animate:true,
				onClick:function(node){
					if(node.attributes.url.length<1)
						return;
					if($("#mainTabs").tabs("exists",node.text)==false)
					{
          
						$("#mainTabs").tabs('add',{
						                       title:node.text,
						                       closable:true,
						                       content:"<iframe src='"+node.attributes.url+"?"+node.attributes.parma+"' scrolling='no' frameborder='0'></iframe>"
							            });
					}else
				    {
						$("#mainTabs").tabs("select",node.text);
				    }
				}
			});
     });
     
     

  </script>
  
 </head>
<body class="easyui-layout">
	<div id="mymenu" style="width:150px;">
		<div>item1</div>
		<div>item2</div>
	</div>
		<div region="north"  split="false" style="height:100%;padding:10px;overflow: hidden;">
            <iframe src="layout/header.jsp" scrolling="no" frameborder="0"></iframe>
		</div>
		<!--  
		<div region="south"  split="false" style="height:100px;padding:10px;background:#efefef;">
            <iframe src="layout/footer.jsp" scrolling="no" frameborder="0"></iframe>
		</div>
		-->
		<div region="west" iconCls="icon-reload" id="MenuTreeNode" split="false" style="width:220px;padding: 5%">
		</div>

		<div region="center"  style="overflow:hidden;">
			<div class="easyui-tabs" fit="true" id="mainTabs" border="false">	
			</div>
		</div>
</body>
</html>
