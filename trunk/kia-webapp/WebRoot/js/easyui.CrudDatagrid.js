/**
 require jquery,easyui
 * import core.js
 * import setting.js
 * import extends.jquery.js
 * import extends.easyui.js
 * import prototype.String.js
 */


var CrudDatagrid=function(opts){
	this._urlAdd=opts["urlAdd"]||"";
	this._urlRemove=opts["urlRemove"]||"";
	this._urlUpdate=opts["urlUpdate"]||"";
	this._regexp=opts["regexp"]||"";
    this._id=opts["id"]||"Id";
    this._initRow=opts["initRow"]||function(){return {};};
    this._editors=opts["editors"];
    //alert("init");
};

CrudDatagrid.prototype.getToolbar=function(){
		    var newRow=new this._initRow();
	        var regexp=this._regexp;
	        var id=this._id;
	        var urlRemove=this._urlRemove;
	        var urlAdd=this._urlAdd;
	        var urlUpdate=this._urlUpdate;
	        var formOpts={};
    	    formOpts["editors"]=this._editors;
	    	var btnAdd={iconCls:"icon-add",text:"新建"
	        ,handler:function(){
	    		formOpts["data"]=newRow;
	    		formOpts["urlSave"]=urlAdd;
	    	    var div=$("<div></div>");
	    		div.kiaCrudForm(formOpts);
	            div.dialog({
	              title:"新建记录"
    		      ,modal:true
	              ,onClose:function(){$(this).dialog("destroy",true);}
	             ,onDestroy:function(){$(regexp).datagrid("reload");}

    	        });
	         }
            };
	        var btnUpdate={iconCls:"icon-edit",text:"修改"
	        ,handler:function(){
	        	var selectRow=$(regexp).datagrid("getSelected");
	        	if(!selectRow){$.messager.alert("","没有记录被选中");return;}
	        	var rowIndex=$(regexp).datagrid("getRowIndex",selectRow);
	            formOpts["data"]=selectRow;
	    		formOpts["urlSave"]=urlUpdate;
	    		var title="修改记录序号:"+(rowIndex+1);
	    		var div=$("<div></div>");
	    		div.kiaCrudForm(formOpts);
	            div.dialog({
	              title:title
    		      ,modal:true
    		     //,onBeforeOpen:function(){$(this).kiaCrudForm(formOpts);}
	             ,onClose:function(){$(this).dialog("destroy",true);}
	             ,onDestroy:function(){$(regexp).datagrid("reload");}
    	        });
	        }
            };
            var btnRemove={iconCls:"icon-remove"
		        ,text:"删除"
		       ,handler:function(){
	            			var selectsRows=$(regexp).datagrid("getSelections");
	            			if(selectsRows.length==0){$.messager.alert("","没有记录被选中");return;}
							var ids="";
							ids=selectsRows.getUnionStr(id,",");
							$.messager.confirm("操作提示","是否删除"+selectsRows.length+"条记录",function(ok){
								if(ok){
							    //var removeRowsAction=basePath+"/common/Datagrid/do/removeRows.action?modelClass="+modelClass;
						        $.post(urlRemove,{ids:ids},function(str){
					              try{
					               var re=new String(str);
                                   re.messager();
						          $(regexp).datagrid("reload");
						         }catch(ex){alert(ex);}
							    });
					          }//if(ok){
					    });
		       }
            };
            var btnRefresh={iconCls:"icon-reload"
	        ,text:"刷新"
	        ,handler:function(){
            	$(regexp).datagrid("reload");
	        }
           };

            var toolbar=[btnAdd,btnUpdate,btnRemove,btnRefresh];
            return toolbar;
};




CrudDatagrid.prototype.getOperaFormatter=function(){
	try{
	var newRow=new this._initRow();
	var regexp=this._regexp;
	var id=this._id;
	var urlRemove=this._urlRemove;
	var urlAdd=this._urlAdd;
	var urlUpdate=this._urlUpdate;
    var formOpts={};
   formOpts["editors"]=this._editors;
	var o= function(value,row,index){
   var span=$("<span></span>");
   var aEdit=$("<a id='aEdit'></a>");
   var aRemove=$("<a></a>");
   var eidtOnclickContext="$('<div></div>').dialog({width:600,height:400});"
   span.append(aEdit);
   span.find("#aEdit")
	   .attr("title","编辑")
	   .attr("href","javascript:void(0)")
	   .addClass("kia-icon")
	   .addClass("edit")
	   .attr("onclick",eidtOnclickContext)
	;
	
	   
	   alert(span.html());
     return span.html();
   
   }
	 return o;
	 
	 }catch(ex){alert(ex);}
}


function dateboxFormatter(value,row,index){

    
	if(value==null||value=='')return '';
	var strFormat="";
	if(typeof(value)=="number"){
		var date=new Date();date.setTime(value);
		return date.toString('yyyy-MM-dd');
	}else{
		return value;
	}

	//alert('value:'+value+" date:"+date.toString('yyyy-MM-dd'));
	
}

function dateTimeboxFormatter(value,row,index){

	if(value==null||value=='')return '';
	var date=new Date();
	date.setTime(value);
	if(date==null){
		return value;
	}
	//alert('value:'+value+" date:"+date.toString('yyyy-MM-dd'));
	return date.toString('yyyy-MM-dd HH:mm:ss');
}







