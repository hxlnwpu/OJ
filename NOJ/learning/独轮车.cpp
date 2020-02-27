#include<stdio.h>
struct colornode
{
    int row;//该状态的行
    int col;//该状态的列
    int color;//该状态的颜色(五种颜色，0-R,1-Y,2-B,3-W,4-G)
    int direction;//该状态的方向(四个方向，0-W,1-S,2-E,3-N,西南东北)
    int num;//该状态的最小步数
};
struct colornode s,t;//起点，终点
struct colornode open[2000];//队列
int head,tail,openlen=2000;
int direct[4][2]={{0,-1},{1,0},{0,1},{-1,0}};//向左，下，右，上四个方向转时，行列的增加值
int a[20][20]={0},n=20;//a数组表示迷宫，n为迷宫边长
int b[20][20][5][4] = {0};//b数组表示搜索时的所有状态，0为未访问,1为已访问

void readdata();
void init();
int search();
struct colornode moveahead(struct colornode u);//u向前走一格得到的结点v
struct colornode turntoleft(struct colornode u);//u向左转得到新结点v
struct colornode turntoright(struct colornode u);//u向右转得到新结点v
int islegal(struct colornode v);
int isaim(struct colornode v);
int used(struct colornode v);//判断该点是否是已经到达过的结点
void addtoopen(struct colornode v);//将节点v加入队列
struct colornode takeoutofopen();//从队列头取节点数据
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
        u = takeoutofopen();//从队列头取数据
        //////////////////////////////向前走可能到目标
        v = moveahead(u);//向前走
        if(islegal(v))
        {
            if(isaim(v))
                return(v.num);
            else if(!used(v))
                addtoopen(v);
        }
        //////////////////////////////向左，向右转都不会到目标点
        v=turntoleft(u);//左转
        if(!used(v))
            addtoopen(v);
        /////////////////////////////
        v=turntoright(u);//右转
        if(!used(v))
            addtoopen(v);
    }
    return 0;//起始点没有通路时
}
struct colornode turntoright(struct colornode u)
{
    struct colornode v;
    v=u;
    v.direction = (u.direction+3)%4;//只要改变方向
    v.num = u.num+1;
    return(v);
}
struct colornode turntoleft(struct colornode u)
{
    struct colornode v;
    v=u;
    v.direction = (u.direction+1)%4;//只要改变方向
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
    v.row=u.row+direct[u.direction][0];    //由方向决定行列增减值
    v.col=u.col+direct[u.direction][1];
    v.color = (u.color+1)%5;//颜色循环
    v.direction = u.direction;//直走方向不变
    v.num = u.num+1;//新的位置步长加1
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
    b[v.row][v.col][v.color][v.direction]=1;//走过的点状态记为1
}
//////////////////////////////////////////////////////////////////////
void readdata()
{
    char str[50];
    int Berow,Becol;
    char Becolor,Bedir;
    scanf("%d %d %c %c",&Berow,&Becol,&Becolor,&Bedir);//注意%c之前一定要加空格
    s.row = (Berow-1);
    s.col = (Becol-1);
    switch(Becolor)
    {   case 'R':s.color=0;break;//红色块压地，值为0
        case 'Y':s.color=1;break;
        case 'B':s.color=2;break;
        case 'W':s.color=3;break;
        case 'G':s.color=4;break;
    };
    switch(Bedir)
    {    case 'W':s.direction=0;break;//向左，方向值为0
        case 'S':s.direction=1;break;
        case 'E':s.direction=2;break;
        case 'N':s.direction=3;break;
    };

    int Enrow,Encol;
    char Encolor;
    scanf("%d %d %c",&Enrow,&Encol,&Encolor);//注意%c之前一定要加空格
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
        scanf("%s",str);//输入一行迷宫字符，再转换成迷宫数字
        for(j=0;j<n;j++)
        {    if(str[j]=='X')    a[i][j]=1;//1表示墙
        else    a[i][j]=0;//0表示空格
        }
    }
}
void init()
{
    int i=0,j=0,k=0,l=0;
    for(i=0;i<n;i++)//行
        for(j=0;j<n;j++)//列
            for(k=0;k<5;k++)//颜色
                for(l=0;l<4;l++)//方向
                    b[i][j][k][l]=0;//状态

    head=0;    tail=0;
    s.num=0;//在初始状态走的步数为0
    addtoopen(s);
}
