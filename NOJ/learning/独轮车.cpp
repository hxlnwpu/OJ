#include<stdio.h>
struct colornode
{
    int row;//��״̬����
    int col;//��״̬����
    int color;//��״̬����ɫ(������ɫ��0-R,1-Y,2-B,3-W,4-G)
    int direction;//��״̬�ķ���(�ĸ�����0-W,1-S,2-E,3-N,���϶���)
    int num;//��״̬����С����
};
struct colornode s,t;//��㣬�յ�
struct colornode open[2000];//����
int head,tail,openlen=2000;
int direct[4][2]={{0,-1},{1,0},{0,1},{-1,0}};//�����£��ң����ĸ�����תʱ�����е�����ֵ
int a[20][20]={0},n=20;//a�����ʾ�Թ���nΪ�Թ��߳�
int b[20][20][5][4] = {0};//b�����ʾ����ʱ������״̬��0Ϊδ����,1Ϊ�ѷ���

void readdata();
void init();
int search();
struct colornode moveahead(struct colornode u);//u��ǰ��һ��õ��Ľ��v
struct colornode turntoleft(struct colornode u);//u����ת�õ��½��v
struct colornode turntoright(struct colornode u);//u����ת�õ��½��v
int islegal(struct colornode v);
int isaim(struct colornode v);
int used(struct colornode v);//�жϸõ��Ƿ����Ѿ�������Ľ��
void addtoopen(struct colornode v);//���ڵ�v�������
struct colornode takeoutofopen();//�Ӷ���ͷȡ�ڵ�����
///////////////////////////////////////////////////////////////////////////////////////////////////////
int main()
{
    readdata();
    init();
    int number=search();
    printf("%d\n",number);
    return 0;
}
///////////////////////////////////////////////////////////////////////////////////////
int search()
{
    struct colornode u,v;
    while(head != tail)
    {
        u = takeoutofopen();//�Ӷ���ͷȡ����
        //////////////////////////////��ǰ�߿��ܵ�Ŀ��
        v = moveahead(u);//��ǰ��
        if(islegal(v))
        {
            if(isaim(v))
                return(v.num);
            else if(!used(v))
                addtoopen(v);
        }
        //////////////////////////////��������ת�����ᵽĿ���
        v=turntoleft(u);//��ת
        if(!used(v))
            addtoopen(v);
        /////////////////////////////
        v=turntoright(u);//��ת
        if(!used(v))
            addtoopen(v);
    }
    return 0;//��ʼ��û��ͨ·ʱ
}
struct colornode turntoright(struct colornode u)
{
    struct colornode v;
    v=u;
    v.direction = (u.direction+3)%4;//ֻҪ�ı䷽��
    v.num = u.num+1;
    return(v);
}
struct colornode turntoleft(struct colornode u)
{
    struct colornode v;
    v=u;
    v.direction = (u.direction+1)%4;//ֻҪ�ı䷽��
    v.num = u.num+1;
    return(v);
}
int used(struct colornode v)
{
    if(b[v.row][v.col][v.color][v.direction]==0)
        return 0;
    else
        return 1;
}
int isaim(struct colornode v)
{
    if(v.row==t.row &&v.col==t.col &&v.color==t.color)
        return 1;
    else
        return 0;
}
int islegal(struct colornode v)
{
    if(v.row>=0 &&v.row<n &&v.col>=0 &&v.col<n &&a[v.row][v.col]==0)
        return 1;
    else return 0;
}
struct colornode moveahead(struct colornode u)
{
    struct colornode v;
    v.row=u.row+direct[u.direction][0];    //�ɷ��������������ֵ
    v.col=u.col+direct[u.direction][1];
    v.color = (u.color+1)%5;//��ɫѭ��
    v.direction = u.direction;//ֱ�߷��򲻱�
    v.num = u.num+1;//�µ�λ�ò�����1
    return(v);
}
struct colornode takeoutofopen()
{
    struct colornode v;
    v=open[head++];
    head=head%openlen;
    return v;
}
void addtoopen(struct colornode v)
{
    open[tail++]=v;
    tail = tail%openlen;
    b[v.row][v.col][v.color][v.direction]=1;//�߹��ĵ�״̬��Ϊ1
}
//////////////////////////////////////////////////////////////////////
void readdata()
{
    char str[50];
    int Berow,Becol;
    char Becolor,Bedir;
    scanf("%d %d %c %c",&Berow,&Becol,&Becolor,&Bedir);//ע��%c֮ǰһ��Ҫ�ӿո�
    s.row = (Berow-1);
    s.col = (Becol-1);
    switch(Becolor)
    {   case 'R':s.color=0;break;//��ɫ��ѹ�أ�ֵΪ0
        case 'Y':s.color=1;break;
        case 'B':s.color=2;break;
        case 'W':s.color=3;break;
        case 'G':s.color=4;break;
    };
    switch(Bedir)
    {    case 'W':s.direction=0;break;//���󣬷���ֵΪ0
        case 'S':s.direction=1;break;
        case 'E':s.direction=2;break;
        case 'N':s.direction=3;break;
    };

    int Enrow,Encol;
    char Encolor;
    scanf("%d %d %c",&Enrow,&Encol,&Encolor);//ע��%c֮ǰһ��Ҫ�ӿո�
    t.row = (Enrow-1);
    t.col = (Encol-1);
    switch(Encolor)
    {    case 'R':t.color=0;break;
        case 'Y':t.color=1;break;
        case 'B':t.color=2;break;
        case 'W':t.color=3;break;
        case 'G':t.color=4;break;
    };

    int i=0,j=0;
    for(i=0;i<n;i++)
    {
        scanf("%s",str);//����һ���Թ��ַ�����ת�����Թ�����
        for(j=0;j<n;j++)
        {    if(str[j]=='X')    a[i][j]=1;//1��ʾǽ
        else    a[i][j]=0;//0��ʾ�ո�
        }
    }
}
void init()
{
    int i=0,j=0,k=0,l=0;
    for(i=0;i<n;i++)//��
        for(j=0;j<n;j++)//��
            for(k=0;k<5;k++)//��ɫ
                for(l=0;l<4;l++)//����
                    b[i][j][k][l]=0;//״̬

    head=0;    tail=0;
    s.num=0;//�ڳ�ʼ״̬�ߵĲ���Ϊ0
    addtoopen(s);
}
