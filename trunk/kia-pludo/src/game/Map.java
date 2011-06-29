package game;

public class Map {
int[] map=new int[100];
int[] mine={5,13,17,33,38,50,64,80,94};
int[] luck={6,23,40,55,69,83};
int[] pause={9,27,60,93};
int[] chanle={20,25,45,63,72,88,90};


public void initial()         //��ʼ����ͼ����
{
	for(int i=0;i<map.length;i++)
	    map[i]=0;
	for(int i=0;i<mine.length;i++)
		map[mine[i]]=1;           //1Ϊ����
	for(int i=0;i<luck.length;i++)
		map[luck[i]]=2;          //2Ϊ��������
	for(int i=0;i<pause.length;i++)
		map[pause[i]]=3;          //3Ϊ��ͣ
	for(int i=0;i<chanle.length;i++)
		map[chanle[i]]=4;          //4Ϊʱ�����
}

public void printgird(int a)        //��ӡ������
{
	switch(a)
	{
	case 0:System.out.print("��");break;
	case 1:System.out.print("��");break;
	case 2:System.out.print("��");break;
	case 3:System.out.print("��");break;
	case 4:System.out.print("��");break;
	case 5:System.out.print("��");break;
	case 6:System.out.print("��");break;
	case 7:System.out.print("@@");break;
	
	}
}

public void printmap()
{
	
	System.out.println("\n\n");
	for(int i=0;i<31;i++)          //��ӡ��һ����
		this.printgird(map[i]);
	System.out.println();
	
	for(int i=31;i<35;i++)          //��ӡ������
	{
		System.out.print("\t\t\t\t\t\t\t");
		
		this.printgird(map[i]);
		System.out.println();
	}
	
	for(int i=65;i>=35;i--)          //��ӡ�ڶ�����
		this.printgird(map[i]);
	System.out.println();
	
	for(int i=66;i<69;i++)          //��ӡ������
	{
		this.printgird(map[i]);
		System.out.println();
	}
	
	for(int i=69;i<100;i++)            //��ӡ��������
		this.printgird(map[i]);          
}

public void updateMap(Player a,Player b)    //�������A�����B��λ�������µ�ͼ
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

