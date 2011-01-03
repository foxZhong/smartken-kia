<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <jsp:include page="plugin/index.jsp?plugin=easyui"></jsp:include>
  
  <script type="text/javascript">
     $(document).ready(function(){
    	 
    		$('#MenuTreeNode').tree({
				url: 'MenuTreeNodeServlet',
				animate:true,
				onClick:function(node){
					if(node.attributes.isleaf!='Y')
						return;
					if($("#mainTabs").tabs("exists",node.text)==false)
					{
                        
						$("#mainTabs").tabs('add',{
						                       title:node.text,
						                       closable:true
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
            交警系统
		</div>
		<div region="south"  split="false" style="height:100px;padding:10px;background:#efefef;">

		</div>
		<div region="west" iconCls="icon-reload" id="MenuTreeNode" split="false" style="width:220px;">
		</div>

		<div region="center"  style="overflow:hidden;">
			<div class="easyui-tabs" fit="true" id="mainTabs" border="false">	
			</div>
		</div>
</body>
</html>
