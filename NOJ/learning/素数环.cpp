#include <stdio.h>
#include <math.h>
void search(int);
void init();              //初始化
void printresult();        //打印结果
int isprime(int);         //判断该数是否是素数
void swap(int,int);       //交换a[m]和a[i]
int a[21];                //a数组存放素数环
int main()
{
	init();
	search(2);            //递归搜索
}
int isprime(int num)
{
	int i,k;
	k=sqrt(num);
	for(i=2;i<=k;i++)
		if(num%i==0)
			return(0);
	return(1);
}
void printresult()
{
	int i;
	for(i=1;i<=20;i++)
		printf("%3d",a[i]);
	printf("\n");
}
void search(int m)
{
	int i;
	if(m>20)                       //当已经搜索到叶结点时
	{
		if(isprime(a[1]+a[20]))        //如果a[1]+a[20]也是素数
			printresult();            //输出当前解
		return;
	}
	else
	{
		for(i=m;i<=20;i++)           //(排列树)
		{
			swap(m,i);              //交换a[m]和a[i]
			if(isprime(a[m-1]+a[m]))  //判断a[m-1]+a[m]是否是素数
				search(m+1);       //递归搜索下一个位置
			swap(m,i);             //把a[m]和a[i]换回来
		}
	}
}
void swap(int m, int i)
{
	int t;
	t=a[m];
	a[m]=a[i];
	a[i]=t;
}
void init()
{
	int i;
	for(i=0;i<21;i++)
		a[i]=i;
}
