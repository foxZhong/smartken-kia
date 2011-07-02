$(document).ready(function()
  {
	
	$('#listTable .listTR:even').hover(function(){
    	$(this).removeClass("listTrMouseOutEven").addClass("listTrMouseOver");},function(){
    	$(this).removeClass("listTrMouseOver").addClass("listTrMouseOutEven");})	 
    	
    $('#listTable .listTR:odd').hover(function(){
        	$(this).removeClass("listTrMouseOutOdd").addClass("listTrMouseOver");},function(){
        	$(this).removeClass("listTrMouseOver").addClass("listTrMouseOutOdd");})	
  }
);


$(document).ready(function()
  {
	
	$('#context').show('slow');
	$('.listTR:even').addClass("listTrMouseOutEven");
	$('.listTR:odd').addClass("listTrMouseOutOdd");
  }
);