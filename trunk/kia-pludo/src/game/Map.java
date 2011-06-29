package game;

public class Map {
int[] map=new int[100];
int[] mine={5,13,17,33,38,50,64,80,94};
int[] luck={6,23,40,55,69,83};
int[] pause={9,27,60,93};
int[] chanle={20,25,45,63,72,88,90};


public void initial()         //初始化地图数组
{
	for(int i=0;i<map.length;i++)
	    map[i]=0;
	for(int i=0;i<mine.length;i++)
		map[mine[i]]=1;           //1为地雷
	for(int i=0;i<luck.length;i++)
		map[luck[i]]=2;          //2为幸运轮盘
	for(int i=0;i<pause.length;i++)
		map[pause[i]]=3;          //3为暂停
	for(int i=0;i<chanle.length;i++)
		map[chanle[i]]=4;          //4为时空隧道
}

public void printgird(int a)        //打印单个格
{
	switch(a)
	{
	case 0:System.out.print("∷");break;
	case 1:System.out.print("★");break;
	case 2:System.out.print("¤");break;
	case 3:System.out.print("■");break;
	case 4:System.out.print("〓");break;
	case 5:System.out.print("Ａ");break;
	case 6:System.out.print("Ｂ");break;
	case 7:System.out.print("@@");break;
	
	}
}

public void printmap()
{
	
	System.out.println("\n\n");
	for(int i=0;i<31;i++)          //打印第一横行
		this.printgird(map[i]);
	System.out.println();
	
	for(int i=31;i<35;i++)          //打印右竖行
	{
		System.out.print("\t\t\t\t\t\t\t");
		
		this.printgird(map[i]);
		System.out.println();
	}
	
	for(int i=65;i>=35;i--)          //打印第二横行
		this.printgird(map[i]);
	System.out.println();
	
	for(int i=66;i<69;i++)          //打印左竖行
	{
		this.printgird(map[i]);
		System.out.println();
	}
	
	for(int i=69;i<100;i++)            //打印第三横行
		this.printgird(map[i]);          
}

public void updateMap(Player a,Player b)    //利用玩家A和玩家B的位置来更新地图
{
	
	this.initial();
	if(a.pos==0&&b.pos==0)
		{map[0]=7;}
	else
	{map[a.pos]=5;
	  map[b.pos]=6;}
	
		
	this.printmap();
	
}
}//Map

