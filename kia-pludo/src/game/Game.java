 package game;

import java.util.*;

public class Game {
Player pa,pb;
Map m=new Map();
Scanner input=new Scanner(System.in);
String Isbegin;
int times=0;

public void initial()
{   
	System.out.println("*************************************************************************");
	System.out.println("//\t\t\t\t\t\t\t\t\t//");
	System.out.println("//\t\t\t\t\t\t\t\t\t//");
	System.out.println("//\t\t\t骑  士  飞  行  棋\t\t\t\t\t//");
	System.out.println("//\t\t\t\t\t\t\t\t\t//");
	System.out.println("//\t\t\t\t\t\t\t\t\t//");
	System.out.println("*************************************************************************\n\n\n");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~两  人  对  战 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("\n\n请选择角色：1.戴高乐   2.艾森豪威尔   3.麦克阿瑟     4.巴顿");
	System.out.print("请玩家1选择角色：");
	int p=input.nextInt();
	switch(p)
	{
	case 1:pa=new Player("戴高乐");break;
	case 2:pa=new Player("艾森豪威尔");break;
	case 3:pa=new Player("麦克阿瑟");break;
	case 4:pa=new Player("巴顿");break;
	}
	System.out.print("\n请玩家2选择角色：");
	 p=input.nextInt();
	switch(p)
	{
	case 1:pb=new Player("戴高乐");break;
	case 2:pb=new Player("艾森豪威尔");break;
	case 3:pb=new Player("麦克阿瑟");break;
	case 4:pb=new Player("巴顿");break;
	}
	System.out.println("^_^"+pa.name+"的士兵:  A");
	System.out.println("^_^"+pb.name+"的士兵:  B\n");
	System.out.println("\n图例： ¤ 幸运轮盘       ★   地雷          ■  暂停       〓   时空隧道      ∷   普通格");
	m.updateMap(pa, pb);
	System.out.print("\n是否开始游戏？(y/n): ");
	this.Isbegin=input.next();
}//initial

public void Judge(Player p1,Player p2)           //判断p1到达的格是否功能格
{
	     
	
	for(int i=0;i<m.mine.length;i++)
	{
	   if(p1.pos==m.mine[i])     //踩雷
	   { if((p1.pos-=6)<0)
		   p1.pos=0;
	   System.err.println(p1.name+" 说：踩到地雷，气死了");
	     
	     }
	   
	}
	
	for(int i=0;i<m.pause.length;i++)
	{
		if(p1.pos==m.pause[i])    //暂停
			{p1.active=false;System.err.println(p1.name+"  ~~>_<~~ 要停一局");
		     
		      }
		
	}
	
	for(int i=0;i<m.chanle.length;i++)
	{
		if(p1.pos==m.chanle[i])     //时光隧道
			{p1.pos+=10;System.err.println(p1.name+"说：进入时光隧道，真爽!");
			}
		
	}
	
	if(p1.pos==p2.pos)        //普通吃机
		{p2.pos=0;System.out.println(p1.name+" 说：哈哈，踩到了");}     
	}//judge

public void LuckJudge(Player p1,Player p2)          //判读p1是否进入时空隧道
{
    for(int i=0;i<m.luck.length;i++)
    {
    	if(p1.pos==m.luck[i])
    	{
    		System.err.println("\n来到幸运轮盘，你有两种运气选择:");
    		System.out.println("\n选择1:与敌人互换位置      2:敌人被炸退6步");
    		System.out.print("你选择的运气是:");
    		int luck=input.nextInt();
    		switch(luck)
    		{
    		case 1:
    			int tem;
    			tem=p1.pos;
    			p1.pos=p2.pos;
    			p2.pos=tem;
    			break;
    		case 2:
    			if((p2.pos-=6)<0)
    			 p2.pos=0;
    			this.Judge(p2, p1);
    			break;
    		}
    	}
    }
}//LuckJudge

public void result()
{
	if(pa.pos>pb.pos)
		System.out.println(pa.name+" 获胜");
	else
		System.out.println(pb.name+" 获胜");
}

public void GameStart()
{
	initial();
	if(!Isbegin.equals("y"))
		{System.out.println("退出游戏.");
		return;
		}
	do
	{   System.out.println("\n现在是第"+(++times)+"回合\n");
	System.out.println("\n"+pa.name+"A所在的位置: "+pa.pos);
    System.out.println(pb.name+"B所在的位置: "+pb.pos);
		if(pa.active==true)
		{System.out.println(pa.name+"A开始投骰子，按任意字母再按回车开始");
		new Scanner(System.in).next();
		pa.throwsShifter();
		//int a=input.nextInt();
		//pa.pos+=a;
		this.Judge(pa, pb);
		this.LuckJudge(pa, pb);
		m.updateMap(pa, pb);
		}
		else
			{System.out.println(pa.name+"暂停一回合");pa.active=true;}
		
		
		System.out.println("\n\n"+pa.name+"A所在的位置: "+pa.pos);
	    System.out.println("\n"+pb.name+"B所在的位置: "+pb.pos);
		
	    if(pb.active==true)
		{System.err.println("\n"+pb.name+"B开始投骰子，按任意字母再按回车开始");
		new Scanner(System.in).next();
		pb.throwsShifter();
		//int a=input.nextInt();
		//pb.pos+=a;
		this.Judge(pb, pa);
		this.LuckJudge(pb, pa);
		m.updateMap(pa, pb);}
	    else
			{System.out.println(pb.name+"暂停一回合");pb.active=true;}
	    
	    if(pa.pos==99||pb.pos==99)
	    	{System.out.println("\n*************************************************************************");
		System.out.println("//\t\t\t\t\t\t\t\t\t//");
		System.out.println("//\t\t\t\t\t\t\t\t\t//");
		System.out.println("//\t\t\t  GAME OVER  \t\t\t\t\t//");
		System.out.println("//\t\t\t\t\t\t\t\t\t//");
		System.out.println("//\t\t\t\t\t\t\t\t\t//");
		System.out.println("*************************************************************************\n\n\n");
		result();
		Isbegin="n";
	    	}
	    
	}while(Isbegin.endsWith("y"));
}
}//Game