var img_w = new Image();
img_w.src = "img/w.png";
var img_b = new Image();
img_b.src = "img/b.png";

var canvas, context, divMsg, user;
var isWhite = true;
var step = new Array();

function loadInfo() {
	//绘制
	canvas = document.getElementById("myCanvas");
	context = canvas.getContext("2d");
	drawRect(); // 画棋盘
}

function play(e) {
	var x = e.offsetX;
	var y = e.offsetY;
	var xb = changeScreenXYtoArrayXY(x, y);
	//	console.log(xb);
	console.log(step);
	for(var i=0; i<step.length; i++){
		var value = step[i];
		if(xb.i == value.i && xb.j == value.j && step.length > 0) {
			alert("不行");
			return;
		}
	}
	alert("可以");
	step.push(xb);
	var zb = changeArrayXYtoScreenXY(xb.i, xb.j);
	drawChess(isWhite, zb.x, zb.y);
}

//绘制棋子
function drawChess(type, x, y) {
	alert("落子")
	//	console.log(type);
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
function changeScreenXYtoArrayXY(x, y) {
	var xn = parseInt((x - 40) / 40);
	var yn = parseInt((y - 40) / 40);
	var xb = xn * 40 + 40;
	var xe = (xn + 1) * 40 + 40;
	var yb = yn * 40 + 40;
	var ye = (yn + 1) * 40 + 40;
	//矫正x坐标到交叉点的x值，并计算下标xn
	if((xe - x) > (x - xb)) {
		x = xb;
	} else {
		x = xe;
		xn++;
	}
	//矫正y坐标到交叉点的y值，并计算下标yn
	if((ye - y) > (y - yb)) {
		y = yb;
	} else {
		y = ye;
		yn++;
	}
	//边界坐标处理
	xn = xn < 0 ? 0 : xn;
	xn = xn > 14 ? 14 : xn;
	yn = yn < 0 ? 0 : yn;
	yn = yn > 14 ? 14 : yn;
	return {
		i: xn,
		j: yn
	};
}
//将数组下标转换为屏幕坐标
function changeArrayXYtoScreenXY(i, j) {
	return {
		x: (i * 40 + 40),
		y: (j * 40 + 40)
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