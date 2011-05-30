

// 声明一个全局对象Namespace，用来注册命名空间
Class = new Object();

// 全局对象仅仅存在register函数，参数为名称空间全路径，如"Grandsoft.GEA"
Class.forName = function(fullNS)
{
    // 将命名空间切成N部分, 比如Grandsoft、GEA等
    var nsArray = fullNS.split('.');
    var sEval = "";
    var sNS = "";
    for (var i = 0; i < nsArray.length; i++)
    {
        if (i != 0) sNS += ".";
        sNS += nsArray[i];
        // 依次创建构造命名空间对象（假如不存在的话）的语句
        // 比如先创建Grandsoft，然后创建Grandsoft.GEA，依次下去
        sEval += "if (typeof(" + sNS + ") == 'undefined') " + sNS + " = new Object();"
    }
    if (sEval != "") eval(sEval);
}

Class.forName("Kia.util");
 
Kia.util={
   isDateFormat:function (pattern,val){
	  if(pattern.length!=val.length)return false;
		  var reg=pattern;
		  reg=reg.replace(/yyyy/,"[0-9]{4}"); 
		  reg=reg.replace(/yy/,"[0-9]{2}"); 
		  reg=reg.replace(/MM/,"((0[1-9])|1[0-2])"); 
		  reg=reg.replace(/M/,"(([1-9])|1[0-2])"); 
		  reg=reg.replace(/dd/,"((0[1-9])|([1-2][0-9])|30|31)"); 
		  reg=reg.replace(/d/,"([1-9]|[1-2][0-9]|30|31))"); 
		  reg=reg.replace(/HH/,"(([0-1][0-9])|20|21|22|23)"); 
		  reg=reg.replace(/H/,"([0-9]|1[0-9]|20|21|22|23)"); 
		  reg=reg.replace(/mm/,"([0-5][0-9])"); 
		  reg=reg.replace(/m/,"([0-9]|([1-5][0-9]))"); 
		  reg=reg.replace(/ss/,"([0-5][0-9])"); 
		  reg=reg.replace(/s/,"([0-9]|([1-5][0-9]))"); 
		  var regexp=new RegExp("^"+reg+"$"); 
		  return regexp.test(val);
}
,
parseDateTime:function (pattern,str){
	if(pattern.length!=str.length)return null;
	var yearIndex=pattern.indexOf("yyyy");
	var monthIndex=pattern.indexOf("MM");
	var dayIndex=pattern.indexOf("dd");
	var hourIndex=pattern.indexOf("HH");
	var minuteIndex=pattern.indexOf("mm");
	var secondIndex=pattern.indexOf("ss");
	var d=new Date();
	try{
	//	alert(pattern+":"+str+":"+yearIndex+":"+monthIndex+":"+dayIndex);
	if(yearIndex==-1||monthIndex==-1||dayIndex==-1)return null;
	var year=parseInt(str.substr(yearIndex,4));
	var month=parseInt(str.substr(monthIndex,2));
	var day=parseInt(str.substr(dayIndex,2));
    d.setFullYear(year,month-1,day);
	if(hourIndex!=-1){var hour=parseInt(str.substr(hourIndex,2));d.setHours(hour);}	
	if(minuteIndex!=-1){var minute=parseInt(str.substr(minute,2));d.setMinutes(minute);}
    if(secondIndex!=-1){var second=parseInt(str.substr(secondIndex,2));d.setSeconds(second);}
	return d;
	}catch(ex){return null;}
}
,	
strToJson:function(jsonStr){	  
	  return eval('('+jsonStr+')');
	}
,
handleJsonResult:function(json){
	   var msg=json["msg"]||"";
	   var title=json["title"]||"操作";
	   var icon=json["icon"]||"info";
	   var action=json["action"]||"show";
	   var result=false;
	   if(action=="show"){
		   $.messager.show({title:title
			                ,msg:msg
			                ,timeout:5000
			                ,showType:"slide"
			                ,showSpeed:500
		   });
	   }else if(action=="alert"){
		   $.messager.alert(title,msg,icon,function(){ return true;});
	   }else if(action=="confirm"){
		   $.messager.confirm(title,msg,function(y){ return y;});
	   }else if(action=="prompt"){
		   $.messager.prompt(title,msg,function(val){return val;});
	   }
	}
}




  

 
 


 

 
 
 
 



 
Class.forName("Kia.setting");

Kia.setting={
	dateboxFormat:"yyyy-MM-dd"
    ,precision:2
}  
 jQuery.fn.extend({

kiaLoadFields:function(){
	  $(this).find("input:enabled").each(function(){
		  
		  if($(this).hasClass("easyui-combobox")){
			  $(this).combobox();
		  }else if($(this).hasClass("kia-intbox")){
			  $(this).kiaIntbox();
		  }else if($(this).hasClass("kia-doublebox")){
			  $(this).kiaDoublebox();
		  }else if($(this).hasClass("kia-combogrid")){
	  	      $(this).kiaCombogrid();
		  }else if($(this).hasClass("kia-datebox")){
			  $(this).kiaDatebox();
		  }
	  });
	  return true;
	  
 }
 
 ,kiaIframe:function(url){
	  $(this).html("<iframe scrolling='no' frameborder='0' src='"+url+"' style='width:99%;height:99%;overflow:hidden;'></iframe>");
 }
 
 ,kiaAuthFields:function(authJson){
	     var authObject=$(this);
	     //var authUrl=url||authObject.attr("authUrl")||null;
         if(!authJson) return false;	     
	    	 authObject.find("input").each(function(){
		    	    var fieldName=$(this).attr("name")||null;
			    	    if(fieldName){
			    	    var authValue=authJson[fieldName];
			    	    switch(authValue){
			    	      case 0:$(this).addClass('invisible').attr("disabled","disabled");break;
			    	      case 1:$(this).addClass('readonly').attr("readonly","true");break;
			    	      default:$(this).addClass('editable');
			    	    }
		    	    }
	    	 });
	       return true;
 }
 

 
 ,kiaCombogrid:function(){
	   
		              var thisObj=$(this);
		              var thisName=thisObj.attr('name');
		              var thisValueField=thisObj.attr("valueField")||"id";
		              var thisTextField=thisObj.attr("textField")||"name";
		              var thisUrl=thisObj.attr("url")||"";
		              var thisRequired=thisObj.attr("required")||true; 
		              var selecterWidth=thisObj.attr("selecterWidth")||60; 
		              var thisDisabled=thisObj.attr("disabled");
		              var thisDataClass=thisObj.attr("dataClass")||"";
		              var thisWidth=thisObj.width();
		              var thisHeight=thisObj.height();
		              thisObj.width(thisWidth-selecterWidth);
		              var thisValue=thisObj.val()||"";

		              //var selecterId="selecter-"+thisName;
		              //alert(_comboData);
		              var selecterObj=$("<input>").width(selecterWidth); //.attr('id',selecterId);
				      thisObj.before(selecterObj);
				      //var selecterObj=$("#"+selecterId);
				       thisObj.combobox({
				    	   hasDownArrow:false
				    	   ,editable:false
				    	   ,required:thisRequired
				    	   ,textField:thisTextField
				    	   ,valueField:thisValueField
		                  });
				       selecterObj.combogrid({
				    	    panelWidth:thisWidth
				    	   ,disabled:thisDisabled
				    	   ,idField:thisValueField
				    	   ,textField:thisValueField
				    	   ,value:thisValue
				    	   ,columns:[[{field:thisValueField,width:selecterWidth},
                                      {field:thisTextField,width:thisWidth}]]
                           ,onChange:function(nv,ov){
				    	                if(!nv||!ov||nv==ov)return;
                                        thisObj.combobox("select",nv);
                                       	}
				    	  ,onSelect:function(index,r){
				        	             thisObj.combobox("select",r[thisValueField]);
				                    }
				    	  }); //$("#"+selecterId).combogrid({
				      //$.getJSON(thisUrl,function(gridData){ 
				       var gridData=_comboData[thisDataClass];
				          
				         if(gridData){
				          // alert(gridData["total"]);
				           var grid=selecterObj.combogrid('grid');
				    	   grid.datagrid("loadData",gridData);
				    	   thisObj.combobox('loadData',gridData["rows"]);
				         }

				      //});  //$.getJSON(thisUrl,function(grid){
	 }  // kiaComboBox:function(){
 
 ,kiaDatebox2:function(){
	 try{
	 var thisObject=$(this);
	 var thisValue=thisObject.attr("value")||"";
	 var formatValue="";
	 if(thisValue!=""){
		 //var d=new Date(thisValue);
		 //formatValue=d.format(Kia.custom.setting.dbDateFormat);
		 var d=Date.parse(thisValue);
		 formatValue=d.toString(Kia.custom.setting.dbDateFormat);
		 thisObject.val(formatValue);
		 //alert(formatValue);
	 }
	 thisObject.datebox({
		 onChange:Kia.easyui.datebox.onChangeHandler
		 ,onSelect:function(date){
	    	 thisObject.datebox("setValue",date.format(Kia.custom.setting.dbDateFormat));  
	 }
	 });
	 var dateCombotext= thisObject.next().find("input:first");
      dateCombotext.blur(function(){
    	  if($(this).val()==null||$(this).val()=="")return;
    	  //alert($(this).val());
    	  var re= Kia.util.isDateFormat(Kia.custom.setting.dbDateFormat,$(this).val());
    	  if(re){
    		 var cal=dateboxObj.datebox("calendar");
    		 var opts=cal.calendar("options");
    		 var d=opts["current"];
    		 //thisObject.val(d.format(Kia.custom.dbDateFormat));
    		 thisObject.datebox("setValue",d.format(Kia.custom.setting.dbDateFormat));
    	  }else{
    		  $.messager.show({title:"输入错误",
    			               msg:"日期格式必须符合"+Kia.custom.setting.dbDateFormat}
    		  );
    		  //dateboxObj.datebox("setValue",thisDateboxValue);
    		  //thisObject.val(formatValue);
    		  thisObject.datebox("setValue",formatValue);
    	  }
    	  //if(!isDbDateFormat(thisObject.val())){
    		//  $("#"+dateboxId).datebox("setValue","");
    		  //$.messager.alert("输入错误","日期格式");
    	  //}
      });
      }catch (ex){alert(ex);}
 }
 ,kiaDatebox:function(){
	
	 var thisObject=$(this);
	 var thisValue=thisObject.attr("value")||"";
	 var formatValue="";
	 if(thisValue!=""){
		 try{
		 //var d=Date.parse(thisValue,"%a %h %d %T %z %G");
		 var d=new Date(thisValue);
		 formatValue=d.toString(Kia.custom.setting.dbDateFormat);
		 thisObject.val(formatValue);
		 }catch(ex){alert(ex);}
	 }else{
		 thisObject.val("");
	 }
	 thisObject.datebox({
		 validType:"date['yyyy-MM-dd']"
	 });
 }
 ,kiaDoublebox:function(){
	 $(this).numberbox({
		     increment:10
            ,precision:Kia.setting.precision
	 });
 }
 
  ,kiaIntbox:function(){
	 $(this).numberbox({
		     increment:10
            ,precision:0
	 });
 }
 
 }); //jQuery.fn.entends({

$.extend($.fn.validatebox.defaults.rules, {

    minLength: {
                validator: function(value, param){
                              return value.length >= param[0];},
                message: 'Please enter at least {0} characters.'
    }  //minLength: {
   ,date:{
	            validator:function(value,param){
	                      var pattern=param[0]||Kia.setting.dateboxFormat;
	                      return Kia.util.isDateFormat(pattern,value);
	            }
                ,message: '日期格式必须符合 {0}'
   }

});   //$.extend($.fn.validatebox.defaults.rules, {

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



 $.fn.datebox.defaults.formatter = function(fdate) {
	 if(fdate)
	 {return fdate.toString(Kia.setting.dateboxFormat);}
	 else{
		 return "";
	 }
 }
 
 $.fn.datebox.defaults.parser = function(s) { 
	 //Tue Mar 22 00:00:00 CST 2011
	 //%a %h %d %T %z %G
	 try{
		 if(!s||s=="") return new Date();
    	 return Date.parse(s);
     }catch(ex){
    	 return new Date();
     }
	
 }
 
 


var CrudDatagrid=function(dgRegexp,basePath,modelClass,idField,initRow){
	this._basePath=basePath||"";
    this._dgRegexp=dgRegexp||"#DG";
    this._modelClass=modelClass||"";
    this._idField=idField||"id";
    this._initRow=initRow||function(){return {};};
    //alert("init");
}

CrudDatagrid.prototype={
	init:function(opts){
	    	var btnAdd={iconCls:"icon-add",text:"新建"
	        ,handler:function(){
	    			var newRow=new this._initRow();
	                $(this._dgRegexp).datagrid("appendRow",newRow);	
	        }
            };
            var btnRemove={iconCls:"icon-remove"
		        ,text:"删除"
		       ,handler:function(){
	            			var selectsRows=$(this._dgRegexp).datagrid("getSelections");
							var ids="";
							$.each(selectsRows,function(index,row){
								var rowIndex=$(this._dgRegexp).datagrid("getRowIndex",row);
								ids+=","+row[this._idField];
							})
							//alert(ids);
							$.messager.confirm("操作提示","是否删除"+selectsRows.length+"条记录",function(ok){
							    var removeRowsAction=_basePath+"/common/Datagrid/do/removeRows.action?modelClass="+this._modelClass;
						        $.post(removeRowsAction,{ids:ids},function(str){
                                   str.handleMessager();
						          $(_dgRegexp).datagrid("reload");
							});
					
					    });
		       }
            };
            var btnRefresh={iconCls:"icon-reload"
	        ,text:"刷新"
	        ,handler:function(){
            	$(this._dgRegexp).datagrid("reload");
	        }
           };

            var toolbar=[btnAdd,btnRemove,btnRefresh];
            opts["toolbar"]=toolbar;
            opts["onDblClickRow"]=function(rowIndex,rowData){
            		if(row['editing']){
		              this.cancelEditRow(rowIndex);
	               }else{
		              this.beginEditRow(rowIndex);
	               }		
            }
            for(var i in opts){
            	alert(opts[i]);
            }
            $(this).datagrid(opts);
            alert("init");
	}
    ,
	saveRow:function(rowIndex){

		var rows=$(this).datagrid("getRows");
		var row=rows[rowIndex];
		$(this).datagrid("endEdit",rowIndex);
		if(!row['editing']) return ;
	        var saveRowAction=this._basePath+"common/Datagrid/do/saveRow.action?modelClass="+this._modelClass;
	        //alert(saveRowAction);
	        $.post(saveRowAction,row,function(str){ 
			    	//var json=Kia.util.strToJson(str);
			    	//alert(json.title);
			    	//Kia.util.handleJsonResult(json);
			        str.handleMessager();
			    	row['editing']=false;
			    	row["removed"]=false;
			    	$(this._dgRegexp).datagrid("refreshRow",rowIndex);
            });
	}
    ,
    beginEidtRow:function(rowIndex){
			var rows=$(this._dgRegexp).datagrid("getRows");
			var row=rows[rowIndex];
			//$(this).datagrid("endEdit",rowIndex);
		    row['editing']=true;
		    $(this._dgRegexp).datagrid('refreshRow',rowIndex);
		    $(this._dgRegexp).datagrid('beginEdit',rowIndex);
    }
    ,
    cancelEditRow:function(rowIndex){
		var rows=$(this._dgRegexp).datagrid("getRows");
		var row=rows[rowIndex];
		row['editing']=false;
		$(this._dgRegexp).datagrid("cancelEdit",rowIndex);
		$(this._dgRegexp).datagrid("refreshRow",rowIndex);
		//if(!row['editing']) return ;
    }

}

function getOperaFormatter(objName){
	var o= function(value,row,index){
    	 var returnHtml="";
	     var aEidt="<a title='编辑' href='javascript:void(0)' class='kia-icon edit' onclick='"+objName+".beginEditRow("+index+");'></a>";
         var aSave="<a title='保存' href='javascript:void(0)' class='kia-icon ok-blue' onclick='"+objName+".saveRow("+index+");'></a>";	
         var aCancel="<a title='取消' href='javascript:void(0)' class='kia-icon stop-red' onclick='"+objName+".cancelEditRow("+index+");'></a>";
         if(row["editing"]){
           returnHtml= aSave+aCancel;
       }else {
         returnHtml= aEidt;
       }
        return returnHtml;
    }
	 return o;
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
	var date=new Date();
	date.setTime(value);
	if(date==null){
		return value;
	}
	//alert('value:'+value+" date:"+date.toString('yyyy-MM-dd'));
	return date.toString('yyyy-MM-dd');
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





