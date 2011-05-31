
Array.prototype.getUnionStr=function(field,split){
	//if(!(filed instanceof String))return "";
	try{
	//if(!filed.isString())return "";
	var unionStr="";
	if(!split){
		split=",";
	}
	for(var i=0;i<this.length;i++){
		var tempVal=this[i][field];
		unionStr=unionStr+tempVal+split;
	}
		unionStr=unionStr.substr(0,unionStr.lastIndexOf(split));
	return unionStr;
	}catch(ex){alert(ex);}
}
