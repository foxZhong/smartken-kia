
//require jquery easyui


 function fnHtmlInnerFrame(url)
 {
	 return "<iframe scrolling='no' frameborder='0' src='"+url+"' style='width:100%;height:100%;overflow:hidden;'></iframe>";
 }
 
 /**
 jQuery.fn.extend({
	 
	 kiaDiv:function(){
	    loadInnerFrame:function(url){
	           alert(url);
	           $(this).html("<iframe scrolling='no' frameborder='0' src='"+url+"' style='width:100%;height:100%;overflow:hidden;'></iframe>");
	         }
	 } //kiaForm:function(){
 }); //jQuery.fn.entends({
 
 
 $.extend($.fn.validatebox.defaults.rules, {

    minLength: {
                validator: function(value, param){
                              return value.length >= param[0];},
                message: 'Please enter at least {0} characters.'

    }

});
 **/