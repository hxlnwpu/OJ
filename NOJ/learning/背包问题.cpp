#include <stdio.h>
#include <conio.h>
int n;//��Ʒ����
int c;//��������
int v[100];//������Ʒ�ļ�ֵ
int w[100];//������Ʒ������
int cw=0;//��ǰ��������
int cp=0;//��ǰ��������Ʒ��ֵ
int bestp=0;//��ǰ���ż�ֵ
int perp[10];//��λ��Ʒ��ֵ�����
int order[10];//��Ʒ���
int put[10];//�����Ƿ�װ��
void knapsack()     //����λ��ֵ����
{
    int i,j;
    int temporder = 0;
    int temp = 0;

    for(i=1;i<=n;i++)
        perp[i]=v[i]/w[i];
    for(i=1;i<=n-1;i++)
    {
        for(j=i+1;j<=n;j++)
            if(perp[i]<perp[j]) //ð������perp[],order[],sortv[],sortw[]
        {
            temp = perp[i];
            perp[i]=perp[i];
            perp[j]=temp;

            temporder=order[i];
            order[i]=order[j];
            order[j]=temporder;
            temp = v[i];
            v[i]=v[j];
            v[j]=temp;

            temp=w[i];
            w[i]=w[j];
            w[j]=temp;
        }
    }
}
void backtrack(int i)
{
    double bound(int i);
    if(i>n)
    {
        bestp = cp;
        return;
    }
    if(cw+w[i]<=c)
    {
        cw+=w[i];
        cp+=v[i];
        put[i]=1;
        backtrack(i+1);
        cw-=w[i];
        cp-=v[i];
    }
    if(bound(i+1)>bestp)//������������������
        backtrack(i+1);
}
double bound(int i)   //�����Ͻ纯��
{
    int leftw= c-cw;
    int b = cp;
    while(i<=n&&w[i]<=leftw)
    {
        leftw-=w[i];
        b+=v[i];
        i++;
    }
    if(i<=n)
        b+=v[i]/w[i]*leftw;
    return b;

}

int main()
{
    int j,k,B[15],r=0;
    for(j=0;j<n;j++)
    {
        scanf("%d%d",&n,&c);
        if(n==0&&c==0) break;
        else
        {
            for(k=0;k<n;k++)
                scanf("%d",&w[k]);
            for(k=0;k<n;k++)
                scanf("%d",&v[k]);
            knapsack();
            backtrack(1);
            B[j]=bestp;
            r++;
        }
    }
    for(k=0;k<r;k++)
        printf("%d\n",B[k]);

    return 0;
}
