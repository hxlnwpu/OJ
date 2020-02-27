#include <stdio.h>
#include <math.h>
void search(int,int);
int canplace(int,int);
void readdata();           //��������
void printresult();        //��ӡ���
int a[20][20];             //a�������Թ�
int s,t;
int main()
{
	int row, col;
	readdata();
	row=s/20;
	col=s%20;
	search(row,col);        //�ݹ�����
	printresult();
}
void search(int row, int col)
{
	int r,c;
	a[row][col]=1;
	r=row;                  //��
	c=col-1;
	if(canplace(r,c))        //�ж�(r,c)λ���Ƿ��Ѿ��߹�
		search(r,c);        //�ݹ�����(r,c)
	r=row+1;                //��
	c=col;
	if(canplace(r,c))        //�ж�(r,c)λ���Ƿ��Ѿ��߹�
		search(r,c);        //�ݹ�����(r,c)
	r=row;                  //��
	c=col+1;
	if(canplace(r,c))        //�ж�(r,c)λ���Ƿ��Ѿ��߹�
		search(r,c);        //�ݹ�����(r,c)
	r=row-1;                //��
	c=col;
	if(canplace(r,c))        //�ж�(r,c)λ���Ƿ��Ѿ��߹�
		search(r,c);        //�ݹ�����(r,c)
}
void printresult()
{
	int i,j;
	for(i=0;i<20;i++)
	{
		for(j=0;j<20;j++)
			printf("%3d",a[i][j]);
		printf("\n");
	}
}
void readdata()
{
	int i,j;
	for(i=0;i<20;i++)
	{
		for(j=0;j<20;j++)
			scanf("%d",&a[i][j]);
	}
}
int canplace(int row, int col)
{
	if(row>=0&&row<20&&col>=0&&col<20&&a[row][col]==0)
		return 1;
	else
		return 0;
}
