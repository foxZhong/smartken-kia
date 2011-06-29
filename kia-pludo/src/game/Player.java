package game;

public class Player {

	String name;
	int pos;
	boolean active;

public Player(String name)       //带参数的构造方法
{
	this.name=name;
this.pos=0;	
active=true;
}

public void throwsShifter()    //玩家抛出骰子，并向前移动所获得的骰子数
{
	int i=(int)(Math.random()*6+1);
	System.out.println("\n"+this.name+"得到的骰子数为 "+i);
	
	this.pos=(this.pos+i);
	if(this.pos>99)        //当超出99格时，仍然停在99格内
		this.pos=99;
	
}
}
