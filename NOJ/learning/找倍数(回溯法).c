#include<stdio.h>
#include<stdlib.h>
#define deep 19
int n;//�������
int Arr[20]= {0}; //�����0,1���ɵ�ʮ��������ÿһλ
int Crr[20]= {0},t=0; //���ڱ���
int p;//��Ǵ���Ч���ֵ���ʼ�±�
int flag=0;//��Ƿ��ҵ���С����
void search(int m);
void check();
int main()
{
    int i=0;
    scanf("%d",&n);//��������ҵ���
    while(n!=0)
    {

        search(0);
        if(flag==1)

        {
            for(int i=0; i<t; i++) //�Ӵ�����Ч����ʼ���0,1����ɵ�ʮ������

                printf("%d",Crr[i]);

           putchar(10);//���У��൱��printf("\n");

        }
        flag=0;//��һ��

        for(i=0; i<deep; i++)

            Arr[i]=0;
        scanf("%d",&n);

    }

    return 0;

}
void search(int m)//0~20
{

    if(m==deep)//�����������
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

    while(Arr[i]==0 &&i<deep)    i++;//���Ҵ�����Ч������ʼλ��



    ///////�������е�����Ϊ0

    if(i==deep)    return ;

    p=i;//��p(Arr[i]=1)λ�ÿ�ʼ,��������Ч

    if(p==deep-1)///////ֻ�����һλ��Чʱ,���������1�����㱶����ϵ

    {
        if(n==1)  flag=1;

        return ;//��n=1����ʱ�����Է���

    }

    else
    {
        t=0;

        int Brr[20]= {0}; //�����ж��Ƿ����㱶����ϵ

        for(i=0; i<deep; i++)  Crr[i]=0; //���ڱ�����Ч0,1��
        for(i=p; i<deep; i++)
        {
            Brr[t]=Arr[i];
            Crr[t++]=Arr[i];
        }
        for(i=0; i<t-1; i++)

            Brr[i+1]=(Brr[i]*10+Brr[i+1])%n;//һ���ж��Ƿ���n�ı����ķ���
        if(Brr[t-1]%n==0)
        {
            flag=1;
            return ;
        }
    }
}
