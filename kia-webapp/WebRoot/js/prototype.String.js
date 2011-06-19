/**
 require  jquery,easyui,dateJs
 */

String.prototype.strip=function() {
    return this.replace(/^\s+/, '').replace(/\s+$/, '');
}
   
String.prototype.stripTags=function() {
    return this.replace(/<\w+(\s+("[^"]*"|'[^']*'|[^>])+)?>|<\/\w+>/gi, '');
    }
  
String.prototype.toArray=function() {
    return this.split('');
    }
    
String.prototype.isJson=function() {
    var str = this;
    if (str.blank()) return false;
    str = str.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, '@');
    str = str.replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']');
    str = str.replace(/(?:^|:|,)(?:\s*\[)+/g, '');
    return (/^[\],:{}\s]*$/).test(str);
   }
 
String.prototype.toJson=function(){
	  try{
		return eval("("+this.toString()+")");
	  }catch(ex){return {};}
	}
  
String.prototype.isDateTimeFormat=function (pattern){
	  if(pattern.length!=this.toString().length)return false;
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
   
String.prototype.isDateTime=function(){
       var formats=["yyyy-MM-dd"
    	           ,"yy-MM-dd"
    	           ,"yyyy-MM-dd HH:mm:ss"
    	           ,"yy-MM-dd HH:mm:ss"
    	           ,"yyyy/MM/dd"
    	           ,"dd/MM/yyyy"
    	           ]
       var isDt=false;
       for(var f in formats){
    	   if(this.isDateTimeFormat(f)){
    		   isDt=true;
    		   break;
    	   }
       }
       return isDt;
    }
   
String.prototype.messager=function(hander){
	   var json=this.toJson();
	   try{
       var msg=json["msg"]||"";
	   var title=json["title"]||"操作";
	   var icon=json["icon"]||"info";
	   var action=json["action"]||"show";
	   var result=false;
       if(action=="alert"){
		   $.messager.alert(title,msg,icon,hander);
	   }else if(action=="confirm"){
		   $.messager.confirm(title,msg,hander);
	   }else if(action=="prompt"){
		   $.messager.prompt(title,msg,hander);
	   }else {
		   $.messager.show({title:title
			                ,msg:msg
			                ,timeout:5000
			                ,showType:"slide"
			                ,showSpeed:500
		   });
	   }
	 }catch(ex){
		 $.messager.alert("","The result context is not a messager json format","error");
	 }
}

