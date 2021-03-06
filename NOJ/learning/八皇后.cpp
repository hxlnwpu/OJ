#include<stdio.h>
#include<math.h>
void search(int);
void printresult();       //打印结果
int  canplace(int,int);     //判断该位置能否放置皇后
void place(int,int);      //在该位置能否放置皇后
void takeout(int,int);    //把该位置放置皇后去掉
int a[8];              //a[i]存放第i个皇后的位置
int main()
{
	search(0);            //递归搜索
}
void search(int m)
{
	int i;
	if(m>=8)                //当已经找出一组解时
		printresult();         //输出当前结果
	else
	{
		for(i=0;i<8;i++)        //对当前行0到7列的每一个位置
		{
			if(canplace(m,i))   //判断第m个格子是否能放堡垒
			{
				place(m,i);    //在(m,i)格子上放置一个皇后
				search(m+1);  //递归搜索下一行
				takeout(m,i);  //把(m,i)格子上的皇后去掉
			}
		}
	}
}
int canplace(int row, int col)
{
	int i;
	for(i=0;i<row;i++)
		if(fabs(i-row)==fabs(a[i]-col)||a[i]==col)
			return(0);
	return(1);
}
void place(int row, int col)
{
	a[row]=col;
}
void takeout(int row, int col)
{
	a[row]=-1;
}
void printresult()
{
	int i,j;
	for(i=0;i<8;i++)
	{
		for(j=0;j<8;j++)
			if(a[i]==j)
				printf(" A ");
			else
				printf(" . ");
		printf("\n");
	}
	printf("\n");
}
