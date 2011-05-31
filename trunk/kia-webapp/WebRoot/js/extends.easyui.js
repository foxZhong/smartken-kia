

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
                      opts["formatter"]=function(date){return date.toString('yyyy-MM-dd');};
                      input.datebox(opts);
                      return input;
        },
        getValue: function(target){
        	
        	var v=target.next().find('.combo-value:first').val();
        	//var d=Kia.util.parseDateTime("yyyy-MM-dd",v);
            //var d=Date.parseExact(v,"yyyy-MM-dd");
            return v;
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
 
 $.fn.panel.defaults.onMove=function(left,top){
 	     if(left<0){
            $(this).panel("move",{left:10});
    	 }
    	 if(top<0){
    		$(this).panel("move",{top:10});
    	 }
    	 var right=left+$(this).width();
    	 var buttom=top+$(this).height();
    	 var wiw=parseInt(window.innerWidth);
    	 var wih=parseInt(window.innerHeight);
    	 if(right>wiw){  
    		 var r=wiw-$(this).width()-30;
    		 $(this).panel("move",{left:r});
    	 }
    	 if(buttom>wih){  
    		  var b=wih-$(this).height()-50;
    		 $(this).panel("move",{top:b});
    	 }
 }
 $.fn.window.defaults.onMove= $.fn.panel.defaults.onMove;
 $.fn.dialog.defaults.onMove= $.fn.panel.defaults.onMove;

 $.fn.form.defaults.success=function(str){ str.messager(null);}
 $.fn.form.defaults.onSubmit=function(){ return $(this).form("validate"); }
 $.fn.form.defaults.onLoadError=function(){
	 $.messager.alert("Error","Can't access to the remote site.","error");
 }
 
 
 $.fn.datagrid.defaults.fit=true;
 $.fn.datagrid.defaults.pagination=true;
 $.fn.datagrid.defaults.nowrap=true;
 $.fn.datagrid.defaults.idField="Id";
 $.fn.datagrid.defaults.rownumbers=true;
 $.fn.datagrid.defaults.pageSize=20;
 