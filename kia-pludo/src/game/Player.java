package game;

public class Player {

	String name;
	int pos;
	boolean active;

public Player(String name)       //�������Ĺ��췽��
{
	this.name=name;
this.pos=0;	
active=true;
}

public void throwsShifter()    //����׳����ӣ�����ǰ�ƶ�����õ�������
{
	int i=(int)(Math.random()*6+1);
	System.out.println("\n"+this.name+"�õ���������Ϊ "+i);
	
	this.pos=(this.pos+i);
	if(this.pos>99)        //������99��ʱ����Ȼͣ��99����
		this.pos=99;
	
}
}
