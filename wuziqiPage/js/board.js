var img_w = new Image();
img_w.src = "img/w.png";
var img_b = new Image();
img_b.src = "img/b.png";

var canvas, context, divMsg, user;
var isPlay = true;
var isWhite = true;
var step = new Array();
var chessData = new Array();

function loadInfo() {
	//绘制
	canvas = document.getElementById("myCanvas");
	context = canvas.getContext("2d");
	drawRect(); // 画棋盘
}

function startChess(){
	
}

function xiexiang_1(xb){
	var arr = new Array();
	for(var index = 0; index < step.length; index++) {
		for (var i=1; i<=4; i++) {
			if(step[index].x==(xb.x-i) && step[index].y==(xb.y-i)){
				arr.push(step[index]);
			}
		}
		for (var i=1; i<=4; i++) {
			if(step[index].x==(xb.x+i) && step[index].y==(xb.y+i)){
				arr.push(step[index]);
			}
		}
	}
	arr.push(xb);
	var result = arr.sort(compare('x'));
	var count = 0;

	for(var i = 0; i < result.length; i++) {
		if(result[i].isWhite==xb.isWhite) {
			count++;
		} else {
			count = 0
		}
		if(count == 5) {
			return true;
		}
	}
	return false;
}

function xiexiang_2(xb){
	var arr = new Array();
	for(var index = 0; index < step.length; index++) {
		for (var i=1; i<=4; i++) {
			if(step[index].x==(xb.x-i) && step[index].y==(xb.y+i)){
				arr.push(step[index]);
			}
		}
		for (var i=1; i<=4; i++) {
			if(step[index].x==(xb.x+i) && step[index].y==(xb.y-i)){
				arr.push(step[index]);
			}
		}
	}
	arr.push(xb);
	var result = arr.sort(compare('x'));

	var count = 0;

	for(var i = 0; i < result.length; i++) {
		if(result[i].isWhite==xb.isWhite) {
			count++;
		} else {
			count = 0
		}
		if(count == 5) {
			return true;
		}
	}
	return false;
}

function hengxiang(xb) {
	var arr = new Array();
	var heng_l = xb.x - 4;
	var heng_r = xb.x + 4;
	for(var index = 0; index < step.length; index++) {
		if(step[index].y == xb.y && step[index].x <= heng_r && step[index].x >= heng_l) {
			arr.push(step[index]);
		}
	}
	var result = arr.sort(compare('x'));
	
	var count = 0;

	for(var i = 0; i < result.length; i++) {
		if(result[i].isWhite==xb.isWhite) {
			count++;
		} else {
			count = 0
		}
		if(count == 5) {
			return true;
		}
	}
	
	return false;
}

function zongxiang(xb) {
	var arr = new Array();
	var zong_u = xb.y + 4;
	var zong_d = xb.y - 4;
	for(var index = 0; index < step.length; index++) {
		if(step[index].x == xb.x && step[index].y <= zong_u && step[index].y >= zong_d) {
			arr.push(step[index]);
		}
	}
	var result = arr.sort(compare('y'));
	
	var count = 0;

	for(var i = 0; i < result.length; i++) {
		if(result[i].isWhite==xb.isWhite) {
			count++;
		} else {
			count = 0
		}
		if(count == 5) {
			return true;
		}
	}
	
	return false;
}


function ifOver(xb) {
	var heng = hengxiang(xb);
	var zong = zongxiang(xb);
	var xie_1 = xiexiang_1(xb);
	var xie_2 = xiexiang_2(xb);
	if(heng || zong || xie_1 || xie_2){
		return true;
	}
	return false;
}

function play(e) {
	if(isPlay){
		var x = e.offsetX;
		var y = e.offsetY;
		var xb = changeScreenXYtoArrayXY(x, y);
		for(var i = 0; i < step.length; i++) {
			var value = step[i];
			if(xb.x == value.x && xb.y == value.y && step.length > 0) {
				alert("buxing");
				return;
			}
		}
		step.push(xb);
		var zb = changeArrayXYtoScreenXY(xb.x, xb.y);
		drawChess(isWhite, zb.y, zb.x);
		if(ifOver(xb)) {
			alert("游戏结束");
			isPlay=false;
		}
	}
}


function compare(property) {
	return function(a, b) {
		var value1 = a[property];
		var value2 = b[property];
		return value1 - value2;
	}
}

//绘制棋子
function drawChess(type, x, y) {
	//	alert("落子")
	if(type) {
		context.drawImage(img_w, x - 18, y - 18);
		isWhite = false;
	}
	if(!type) {
		context.drawImage(img_b, x - 18, y - 18);
		isWhite = true;
	}
}
//将屏幕坐标转换为数组下标
function changeScreenXYtoArrayXY(i, j) {
	var xn = parseInt((i - 40) / 40);
	var yn = parseInt((j - 40) / 40);
	var xb = xn * 40 + 40;
	var xe = (xn + 1) * 40 + 40;
	var yb = yn * 40 + 40;
	var ye = (yn + 1) * 40 + 40;
	//矫正x坐标到交叉点的x值，并计算下标xn
	if((xe - i) > (i - xb)) {
		i = xb;
	} else {
		i = xe;
		xn++;
	}
	//矫正y坐标到交叉点的y值，并计算下标yn
	if((ye - j) > (j - yb)) {
		j = yb;
	} else {
		j = ye;
		yn++;
	}
	//边界坐标处理
	xn = xn < 0 ? 0 : xn;
	xn = xn > 14 ? 14 : xn;
	yn = yn < 0 ? 0 : yn;
	yn = yn > 14 ? 14 : yn;
	return {
		x: xn,
		y: yn,
		isWhite: isWhite
	};
}
//将数组下标转换为屏幕坐标
function changeArrayXYtoScreenXY(i, j) {
	return {
		x: (j * 40 + 40),
		y: (i * 40 + 40),
		isWhite: isWhite
	};
}

//绘制棋盘
function drawRect() {
	//棋盘纵横线
	for(var i = 1; i < 16; i++) {
		var xb = i - 1;
		context.strokeText(xb, 36 + xb * 40, 25);
		context.strokeText(xb, 20, 44 + xb * 40);
		//纵线					
		context.beginPath();
		context.moveTo(40 * i, 40);
		context.lineTo(40 * i, 600);
		context.closePath();
		context.stroke();
		//横线
		context.beginPath();
		context.moveTo(40, 40 * i);
		context.lineTo(600, 40 * i);
		context.closePath();
		context.stroke();
	}
}

step[{
	x: 1,
	y: 2,
	isWhite: true
}, {
	x: 1,
	y: 2,
	isWhite: true
}]