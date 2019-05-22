var canvas;
var context;

$(function(){
	drawRect()
})

function moveInChess(user_id) {

}

function takeBack(user_id) {

}

function drawRect() {
	//创建棋盘背景  
	canvas = document.getElementById("canvas");
	context = canvas.getContext("2d");
	context.fillStyle = "#E6C39D";
	context.fillRect(0, 0, 1024, 768);
	//标题
	context.fillStyle = "#00f";
	context.font = "40px 黑体";
	context.strokeText('五子棋', 330, 50);
	//新游戏  
	context.strokeRect(790, 140, 120, 30);
	context.fillStyle = '#00f';
	context.font = '25px Arial';
	context.strokeText('再来一局', 800, 165);
	//游戏说明  
	context.fillStyle = '#00f';
	context.font = '15px Arial';
	context.strokeText('游戏规则：玩家执黑色', 780, 200);
	context.strokeText('棋子先手，电脑执白色棋子', 750, 220);
	context.strokeText('后手，任何一方形成五子连', 750, 240);
	context.strokeText('珠，游戏终止。', 750, 260);
	//棋盘纵横线  
	for(var i = 1; i < 16; i++) {
		context.beginPath();
		context.moveTo(40 * i + 140, 80);
		context.lineTo(40 * i + 140, 640);
		context.closePath();
		context.stroke();
		context.beginPath();
		context.moveTo(180, 40 * i + 40);
		context.lineTo(740, 40 * i + 40);
		context.closePath();
		context.stroke();
	}
}