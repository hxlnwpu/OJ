#include <stdio.h>
#include <math.h>
void search(int);
void init();              //��ʼ��
void printresult();        //��ӡ���
int isprime(int);         //�жϸ����Ƿ�������
void swap(int,int);       //����a[m]��a[i]
int a[21];                //a������������
int main()
{
	init();
	search(2);            //�ݹ�����
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
	if(m>20)                       //���Ѿ�������Ҷ���ʱ
	{
		if(isprime(a[1]+a[20]))        //���a[1]+a[20]Ҳ������
			printresult();            //�����ǰ��
		return;
	}
	else
	{
		for(i=m;i<=20;i++)           //(������)
		{
			swap(m,i);              //����a[m]��a[i]
			if(isprime(a[m-1]+a[m]))  //�ж�a[m-1]+a[m]�Ƿ�������
				search(m+1);       //�ݹ�������һ��λ��
			swap(m,i);             //��a[m]��a[i]������
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
