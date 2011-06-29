package com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import enums.EDirections;

//敌方坦克类
public class EmeyTank extends Tank {

	int step;      //随机移动步数
	Random r;      //随机数对象 
	EDirections[] dirs;     //方向数组

//构造方法
	EmeyTank(int x, int y, Client client, boolean stand) {
		super(x, y, client, stand);
		r = new Random();
		this.tankcolor = Color.GREEN;
		this.ptcolor = Color.BLACK;
		// TODO Auto-generated constructor stub
	}

	public void Draw(Graphics g) {
		this.draw(g);
		this.Move();
	}

	public void Move() {
		this.setDirection();
		this.move();

	}

	public void setDirection() {
		if (step == 0) {
			step = r.nextInt(12) + 3;
			dirs = EDirections.values();
			dir = dirs[r.nextInt(dirs.length)];
			if (dir != EDirections.STOP)
				ptdir = dir;
		} else
			step--;
		if (r.nextInt(40) > 25)
			this.fire(ptdir);

	}

}
