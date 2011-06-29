// JavaScript Document
function displayDetail(type, opt) {
	var displayP = window.document.getElementById(type);
	if (type == 'd1') {
		if (opt == 1) {
			displayP.innerHTML = '<p>可以的，但必须是我们经营范围内的品牌，由于这类货品跟专卖店同步销售，有可能会产生断货情况。您可以拨打我们的全国免费客服电话400-8810-400查询专卖店的货品情况，手机电话查货请提供产品的出厂的标准货号。[<a class="font4" href="#" onclick="displayDetail(\'d1\',0);return false;" title="隐藏详细">隐藏详细</a>]</p>';
		} else {
			displayP.innerHTML = '<p>可以的，但必须是我们经营范围内的品牌，由于这类货品跟专卖店同步销售，有...[<a class="font4" href="#" onclick="displayDetail(\'d1\',1);return false;" title="查看详细">查看详细</a>]</p>';
		}
	}else if (type == 'd2') {
		if (opt == 1) {
			displayP.innerHTML = '<p>“预售商品”是指提前发售尚未正式发行的商品，多为限量纪念版产品或者国外限量产品，为了您能及时收到正常发货商品，建议您将预售商品单独下订单购买。[<a class="font4" href="#" onclick="displayDetail(\'d2\',0);return false;" title="隐藏详细">隐藏详细</a>]</p>';
		} else {
			displayP.innerHTML = '<p>“预售商品”是指提前发售尚未正式发行的商品，多为限量纪念版产品或者国外...[<a class="font4" href="#" onclick="displayDetail(\'d2\',1);return false;" title="查看详细">查看详细</a>]</p>';
		}
	}
}
function allForm(){
	var uName = document.getElementById("userName");
    var uPass = document.getElementById("passWord");
    var yz = document.getElementById("yanzheng");
    if(uName.value==""){
    	yz.className="font3";
    	yz.innerHTML="用户名不能为空！";
    	return false;
    }
    if(uPass.value==""){
    	yz.className="font3";
    	yz.innerHTML="密码不能为空！";
    	return false;    
    }
    return true;
}
function $G(Read_Id) { return document.getElementById(Read_Id) }
function Effect(ObjectId,parentId){
var Obj_Display = $G(ObjectId).style.display;
	if (Obj_Display == 'none'){
	Start(ObjectId,'Opens');
	$G(parentId).innerHTML = "<a href=# onClick=javascript:Effect('"+ObjectId+"','"+parentId+"');>-</a>"
	}else{ 
	Start(ObjectId,'Close');
	$G(parentId).innerHTML = "<a href=# onClick=javascript:Effect('"+ObjectId+"','"+parentId+"');>+</a>"
	}
}
function Start(ObjId,method){
var BoxHeight = $G(ObjId).offsetHeight;   			//获取对象高度
var MinHeight = 5;									//定义对象最小高度
var MaxHeight = 30;					 			//定义对象最大高度
var BoxAddMax = 1;									//递增量初始值
var Every_Add = 0.1;								//每次的递(减)增量  [数值越大速度越快]
var Reduce    = (BoxAddMax - Every_Add);
var Add       = (BoxAddMax + Every_Add);
//关闭动作**************************************
if (method == "Close"){
var Alter_Close = function(){						//构建一个虚拟的[递减]循环
	BoxAddMax /= Reduce;
	BoxHeight -= BoxAddMax;
	if (BoxHeight <= MinHeight){
		$G(ObjId).style.display = "none";
		window.clearInterval(BoxAction);
	}
	else $G(ObjId).style.height = BoxHeight;
}
var BoxAction = window.setInterval(Alter_Close,1);
}
//打开动作**************************************
else if (method == "Opens"){
var Alter_Opens = function(){
	BoxAddMax *= Add;
	BoxHeight += BoxAddMax;
	if (BoxHeight >= MaxHeight){
		$G(ObjId).style.height = MaxHeight;
		window.clearInterval(BoxAction);
	}else{
	$G(ObjId).style.display= "block";
	$G(ObjId).style.height = BoxHeight;
	}
}
var BoxAction = window.setInterval(Alter_Opens,1);
}
}