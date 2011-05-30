


var _basePath="";
var _dgRegexp="#DG";
var _modelClass="";
var _idField="id";
var _initRow=function(){return {};};

function saveRow(rowIndex){
	$(_dgRegexp).each(function(index){
		var rows=$(this).datagrid("getRows");
		var row=rows[rowIndex];
		$(this).datagrid("endEdit",rowIndex);
		if(!row['editing']) return ;
        var saveRowAction=_basePath+"common/Datagrid/do/saveRow.action?modelClass="+_modelClass;
        //alert(saveRowAction);
        $.post(saveRowAction,row,function(str){ 
    	var json=Kia.util.strToJson(str);
    	//alert(json.title);
    	Kia.util.handleJsonResult(json);
    	row['editing']=false;
    	row["removed"]=false;
    	$(_dgRegexp).datagrid("refreshRow",rowIndex);
    });
	});
}

function editRow(rowIndex){
	   $(_dgRegexp).each(function(index){
		var rows=$(this).datagrid("getRows");
		var row=rows[rowIndex];
		//$(this).datagrid("endEdit",rowIndex);
	    row['editing']=true;
	    $(this).datagrid('refreshRow',rowIndex);
	    $(this).datagrid('beginEdit',rowIndex);
	});

}

function removeRowsHandler(){
	   // alert("remove");
		var selectsRows=$(_dgRegexp).datagrid("getSelections");
		var ids="";
		$.each(selectsRows,function(index,row){
			var rowIndex=$(_dgRegexp).datagrid("getRowIndex",row);
			ids+=","+row[_idField];
			//row["removed"]=true;
			//$(_dgRegexp).datagrid("refreshRow",rowIndex);
		})
		//alert(ids);
		$.messager.confirm("操作提示","是否删除"+selectsRows.length+"条记录",function(ok){
		    var removeRowsAction=_basePath+"/common/Datagrid/do/removeRows.action?modelClass="+_modelClass;
	        $.post(removeRowsAction,{ids:ids},function(str){
	          var json=Kia.util.strToJson(str);
	          Kia.util.handleJsonResult(json);
	          $(_dgRegexp).datagrid("reload");
		});

    });
    //if(!row['editing']) return ;

}

function appendRowHandler(){
	var newRow=new _initRow();
	$(_dgRegexp).datagrid("appendRow",newRow);	 
}

function reloadHandler(){
	$(_dgRegexp).datagrid("reload");
	 
}

function cancelEditRow(rowIndex){
	$(_dgRegexp).each(function(index){
		var rows=$(this).datagrid("getRows");
		var row=rows[rowIndex];
		row['editing']=false;
		$(this).datagrid("cancelEdit",rowIndex);
		$(this).datagrid("refreshRow",rowIndex);
		//if(!row['editing']) return ;
	});
}

function operaFormatter(value,row,index){
	var returnHtml="";
	var aEidt="<a title='编辑' href='javascript:void(0)' class='kia-icon edit' onclick='editRow("+index+");'></a>";
    var aSave="<a title='保存' href='javascript:void(0)' class='kia-icon ok-blue' onclick='saveRow("+index+");'></a>";	
    var aCancel="<a title='取消' href='javascript:void(0)' class='kia-icon stop-red' onclick='cancelEditRow("+index+");'></a>";
    if(row["editing"]){
      returnHtml= aSave+aCancel;
    }else {
      returnHtml= aEidt;
    }

    return returnHtml;
}

function stateFormatter(value,row,index){
   var iconCls="flag-green";
   if(row["removed"]){
	   iconCls="flag-red";
   }
   return "<div class='kia-icon "+iconCls+"'></div>";
}

function dateboxFormatter(value,row,index){

	if(value==null||value=='')return '';
	//var date= Kia.util.parseDateTime("yyyy-MM-dd hh:mm:ss",value);
	//var date=new Date(value);
	var date=new Date();
	date.setTime(value);
	if(date==null){
		return value;
	}
	//alert('value:'+value+" date:"+date.toString('yyyy-MM-dd'));
	return date.toString('yyyy-MM-dd');
}

function dblClickRowHandler(rowIndex,row){
	//alert(row['editing']);
	if(row['editing']){
		cancelEditRow(rowIndex);
	}else{
		editRow(rowIndex);
	}		
}

var btnAdd={iconCls:"icon-add"
	,text:"新建"
	,handler:appendRowHandler
};

var btnRemove={iconCls:"icon-remove"
	,text:"删除"
	,handler:removeRowsHandler
};

var btnRefresh={iconCls:"icon-reload"
	,text:"刷新"
	,handler:reloadHandler
};


var toolbar=[btnAdd,btnRemove,btnRefresh];


function editorsResizeHandler(target,width){
	      var input = $(target);
          if ($.boxModel == true){
                input.width(width - (input.outerWidth() - input.width()));
            } else {
                input.width(width);
          }
}

$.extend($.fn.datagrid.defaults.editors, {

    kiaDatebox: {
        init: function(container, options){
                      var input = $('<input type="text" class="datagrid-editable-input">').appendTo(container);
                      var opts=options||{};
                      opts["editable"]=false;
                      opts["formatter"]=function(date){return date.format('yyyy-MM-dd');};
                      input.datebox(opts);
                      return input;
        },
        getValue: function(target){
        	
        	var v=target.next().find('.combo-value:first').val();
        	//var d=Kia.util.parseDateTime("yyyy-MM-dd",v);
        	//alert("v:"+v+"  d:"+d)
            var d=Date.parseExact(v,"yyyy-MM-dd");
        	return d.toString("yyyy-MM-dd");
        },
        setValue: function(target, value){
        	//alert("set:"+value+":"+target.val());
        	if(value==null||value=="")return;
        	//var d=new Date(value);
        	var d=new Date(parseInt(value));
    
        	//alert('value:'+value+" d:"+d.toString());
            $(target).datebox("setValue",d.toString("yyyy-MM-dd"));
        },
        resize:editorsResizeHandler
    }
    
   ,    kiaDoublebox: {
        init: function(container, options){
            var input = $('<input type="text" class="datagrid-editable-input">').appendTo(container);
            var opt=options||{};
            input.numberbox({
            	increment:10
            	,precision:2
            });
            return input;
        },

        getValue: function(target){
            return $(target).val();
        },
        setValue: function(target, value){
            $(target).val(value);
        },
        resize: editorsResizeHandler

    }
   
   ,kiaIntbox: {
        init: function(container, options){
            var input = $('<input type="text" class="datagrid-editable-input">').appendTo(container);
            var opt=options||{};
            input.numberbox({
            	increment:10
            	,precision:0
            });
            return input;
        },

        getValue: function(target){
            return $(target).val();
        },
        setValue: function(target, value){
            $(target).val(value);
        },
        resize: editorsResizeHandler

    }
    



});


