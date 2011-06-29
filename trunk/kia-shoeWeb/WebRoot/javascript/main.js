// JavaScript Document
var slideShowSpeed = 4000;
var crossFadeDuration = 2;
var Pic = new Array();

Pic[0] = 'image/001.jpg'
Pic[1] = 'image/002.jpg'
Pic[2] = 'image/003.jpg'

var t;
var j = 0;
var p = Pic.length;
var preLoad = new Array();
for (i = 0; i < p; i++) {
preLoad[i] = new Image();
preLoad[i].src = Pic[i];
}
function Switch(){
    for(var x=0;x<3;x++){
	    if(j==x){
			document.getElementById("s"+x).className="borderRed";
		}else{
			document.getElementById("s"+x).className="";
		}
	}
	var SlideShow=document.getElementById("SlideShow");
	SlideShow.style.filter="blendTrans(duration=crossFadeDuration)";
	SlideShow.filters.blendTrans.Apply();
	SlideShow.src = preLoad[j].src;
	SlideShow.filters.blendTrans.Play();
	j = j + 1;
	if (j > (p - 1)) j = 0;
	t = setTimeout('Switch()', slideShowSpeed);
}

function mouseover(op){
	for(var i=0;i<3;i++){
		if(op==i){
			document.getElementById("s"+i).className="borderRed";
		}else{
			document.getElementById("s"+i).className="";
		}
	}
	j=op;
	var SlideShow=document.getElementById("SlideShow");
	SlideShow.style.filter="blendTrans(duration=crossFadeDuration)";
	SlideShow.filters.blendTrans.Apply();
	SlideShow.src = preLoad[j].src;
	SlideShow.filters.blendTrans.Play();
	clearTimeout(t);
}
function mouseout(op){
	j=parseInt(op);
	Switch();
}
