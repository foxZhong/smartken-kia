// JavaScript Document
function displayDetail(type, opt) {
	var displayP = window.document.getElementById(type);
	if (type == 'd1') {
		if (opt == 1) {
			displayP.innerHTML = '<p>���Եģ������������Ǿ�Ӫ��Χ�ڵ�Ʒ�ƣ����������Ʒ��ר����ͬ�����ۣ��п��ܻ�����ϻ�����������Բ������ǵ�ȫ����ѿͷ��绰400-8810-400��ѯר����Ļ�Ʒ������ֻ��绰������ṩ��Ʒ�ĳ����ı�׼���š�[<a class="font4" href="#" onclick="displayDetail(\'d1\',0);return false;" title="������ϸ">������ϸ</a>]</p>';
		} else {
			displayP.innerHTML = '<p>���Եģ������������Ǿ�Ӫ��Χ�ڵ�Ʒ�ƣ����������Ʒ��ר����ͬ�����ۣ���...[<a class="font4" href="#" onclick="displayDetail(\'d1\',1);return false;" title="�鿴��ϸ">�鿴��ϸ</a>]</p>';
		}
	}else if (type == 'd2') {
		if (opt == 1) {
			displayP.innerHTML = '<p>��Ԥ����Ʒ����ָ��ǰ������δ��ʽ���е���Ʒ����Ϊ����������Ʒ���߹���������Ʒ��Ϊ�����ܼ�ʱ�յ�����������Ʒ����������Ԥ����Ʒ�����¶�������[<a class="font4" href="#" onclick="displayDetail(\'d2\',0);return false;" title="������ϸ">������ϸ</a>]</p>';
		} else {
			displayP.innerHTML = '<p>��Ԥ����Ʒ����ָ��ǰ������δ��ʽ���е���Ʒ����Ϊ����������Ʒ���߹���...[<a class="font4" href="#" onclick="displayDetail(\'d2\',1);return false;" title="�鿴��ϸ">�鿴��ϸ</a>]</p>';
		}
	}
}
function allForm(){
	var uName = document.getElementById("userName");
    var uPass = document.getElementById("passWord");
    var yz = document.getElementById("yanzheng");
    if(uName.value==""){
    	yz.className="font3";
    	yz.innerHTML="�û�������Ϊ�գ�";
    	return false;
    }
    if(uPass.value==""){
    	yz.className="font3";
    	yz.innerHTML="���벻��Ϊ�գ�";
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
var BoxHeight = $G(ObjId).offsetHeight;   			//��ȡ����߶�
var MinHeight = 5;									//���������С�߶�
var MaxHeight = 30;					 			//����������߶�
var BoxAddMax = 1;									//��������ʼֵ
var Every_Add = 0.1;								//ÿ�εĵ�(��)����  [��ֵԽ���ٶ�Խ��]
var Reduce    = (BoxAddMax - Every_Add);
var Add       = (BoxAddMax + Every_Add);
//�رն���**************************************
if (method == "Close"){
var Alter_Close = function(){						//����һ�������[�ݼ�]ѭ��
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
//�򿪶���**************************************
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