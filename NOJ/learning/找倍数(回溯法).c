#include<stdio.h>
#include<stdlib.h>
#define deep 19
int n;//待查的数
int Arr[20]= {0}; //存放由0,1构成的十进制数的每一位
int Crr[20]= {0},t=0; //用于保存
int p;//标记串有效部分的起始下表
int flag=0;//标记否找的最小倍数
void search(int m);
void check();
int main()
{
    int i=0;
    scanf("%d",&n);//输入待查找的数
    while(n!=0)
    {

        search(0);
        if(flag==1)

        {
            for(int i=0; i<t; i++) //从串中有效数开始输出0,1串组成的十进制数

                printf("%d",Crr[i]);

           putchar(10);//换行，相当于printf("\n");

        }
        flag=0;//下一轮

        for(i=0; i<deep; i++)

            Arr[i]=0;
        scanf("%d",&n);

    }

    return 0;

}
void search(int m)//0~20
{

    if(m==deep)//到达搜索深度
    {
        if(flag==0)
        {
            check();
            if(flag==1)    return;
        }
    }
    else
    {
        Arr[m]=0;
        search(m+1);
        Arr[m]=1;
        search(m+1);
    }

}
void check()

{

    int i=0;

    while(Arr[i]==0 &&i<deep)    i++;//查找串中有效数的起始位置



    ///////串中所有的数都为0

    if(i==deep)    return ;

    p=i;//从p(Arr[i]=1)位置开始,串中数有效

    if(p==deep-1)///////只有最后一位有效时,待查的数是1才满足倍数关系

    {
        if(n==1)  flag=1;

        return ;//不n=1与否此时都可以返回

    }

    else
    {
        t=0;

        int Brr[20]= {0}; //用于判断是否满足倍数关系

        for(i=0; i<deep; i++)  Crr[i]=0; //用于保存有效0,1串
        for(i=p; i<deep; i++)
        {
            Brr[t]=Arr[i];
            Crr[t++]=Arr[i];
        }
        for(i=0; i<t-1; i++)

            Brr[i+1]=(Brr[i]*10+Brr[i+1])%n;//一种判断是否是n的倍数的方法
        if(Brr[t-1]%n==0)
        {
            flag=1;
            return ;
        }
    }
}
