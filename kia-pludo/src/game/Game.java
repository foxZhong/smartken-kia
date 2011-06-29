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
	System.out.println("//\t\t\t��  ʿ  ��  ��  ��\t\t\t\t\t//");
	System.out.println("//\t\t\t\t\t\t\t\t\t//");
	System.out.println("//\t\t\t\t\t\t\t\t\t//");
	System.out.println("*************************************************************************\n\n\n");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~��  ��  ��  ս ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("\n\n��ѡ���ɫ��1.������   2.��ɭ������   3.��˰�ɪ     4.�Ͷ�");
	System.out.print("�����1ѡ���ɫ��");
	int p=input.nextInt();
	switch(p)
	{
	case 1:pa=new Player("������");break;
	case 2:pa=new Player("��ɭ������");break;
	case 3:pa=new Player("��˰�ɪ");break;
	case 4:pa=new Player("�Ͷ�");break;
	}
	System.out.print("\n�����2ѡ���ɫ��");
	 p=input.nextInt();
	switch(p)
	{
	case 1:pb=new Player("������");break;
	case 2:pb=new Player("��ɭ������");break;
	case 3:pb=new Player("��˰�ɪ");break;
	case 4:pb=new Player("�Ͷ�");break;
	}
	System.out.println("^_^"+pa.name+"��ʿ��:  A");
	System.out.println("^_^"+pb.name+"��ʿ��:  B\n");
	System.out.println("\nͼ���� �� ��������       ��   ����          ��  ��ͣ       ��   ʱ�����      ��   ��ͨ��");
	m.updateMap(pa, pb);
	System.out.print("\n�Ƿ�ʼ��Ϸ��(y/n): ");
	this.Isbegin=input.next();
}//initial

public void Judge(Player p1,Player p2)           //�ж�p1����ĸ��Ƿ��ܸ�
{
	     
	
	for(int i=0;i<m.mine.length;i++)
	{
	   if(p1.pos==m.mine[i])     //����
	   { if((p1.pos-=6)<0)
		   p1.pos=0;
	   System.err.println(p1.name+" ˵���ȵ����ף�������");
	     
	     }
	   
	}
	
	for(int i=0;i<m.pause.length;i++)
	{
		if(p1.pos==m.pause[i])    //��ͣ
			{p1.active=false;System.err.println(p1.name+"  ~~>_<~~ Ҫͣһ��");
		     
		      }
		
	}
	
	for(int i=0;i<m.chanle.length;i++)
	{
		if(p1.pos==m.chanle[i])     //ʱ�����
			{p1.pos+=10;System.err.println(p1.name+"˵������ʱ���������ˬ!");
			}
		
	}
	
	if(p1.pos==p2.pos)        //��ͨ�Ի�
		{p2.pos=0;System.out.println(p1.name+" ˵���������ȵ���");}     
	}//judge

public void LuckJudge(Player p1,Player p2)          //�ж�p1�Ƿ����ʱ�����
{
    for(int i=0;i<m.luck.length;i++)
    {
    	if(p1.pos==m.luck[i])
    	{
    		System.err.println("\n�����������̣�������������ѡ��:");
    		System.out.println("\nѡ��1:����˻���λ��      2:���˱�ը��6��");
    		System.out.print("��ѡ���������:");
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
		System.out.println(pa.name+" ��ʤ");
	else
		System.out.println(pb.name+" ��ʤ");
}

public void GameStart()
{
	initial();
	if(!Isbegin.equals("y"))
		{System.out.println("�˳���Ϸ.");
		return;
		}
	do
	{   System.out.println("\n�����ǵ�"+(++times)+"�غ�\n");
	System.out.println("\n"+pa.name+"A���ڵ�λ��: "+pa.pos);
    System.out.println(pb.name+"B���ڵ�λ��: "+pb.pos);
		if(pa.active==true)
		{System.out.println(pa.name+"A��ʼͶ���ӣ���������ĸ�ٰ��س���ʼ");
		new Scanner(System.in).next();
		pa.throwsShifter();
		//int a=input.nextInt();
		//pa.pos+=a;
		this.Judge(pa, pb);
		this.LuckJudge(pa, pb);
		m.updateMap(pa, pb);
		}
		else
			{System.out.println(pa.name+"��ͣһ�غ�");pa.active=true;}
		
		
		System.out.println("\n\n"+pa.name+"A���ڵ�λ��: "+pa.pos);
	    System.out.println("\n"+pb.name+"B���ڵ�λ��: "+pb.pos);
		
	    if(pb.active==true)
		{System.err.println("\n"+pb.name+"B��ʼͶ���ӣ���������ĸ�ٰ��س���ʼ");
		new Scanner(System.in).next();
		pb.throwsShifter();
		//int a=input.nextInt();
		//pb.pos+=a;
		this.Judge(pb, pa);
		this.LuckJudge(pb, pa);
		m.updateMap(pa, pb);}
	    else
			{System.out.println(pb.name+"��ͣһ�غ�");pb.active=true;}
	    
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