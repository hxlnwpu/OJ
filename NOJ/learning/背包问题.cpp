#include <stdio.h>
#include <conio.h>
int n;//物品数量
int c;//背包容量
int v[100];//各个物品的价值
int w[100];//各个物品的重量
int cw=0;//当前背包重量
int cp=0;//当前背包中物品价值
int bestp=0;//当前最优价值
int perp[10];//单位物品价值排序后
int order[10];//物品编号
int put[10];//设置是否装入
void knapsack()     //按单位价值排序
{
    int i,j;
    int temporder = 0;
    int temp = 0;

    for(i=1;i<=n;i++)
        perp[i]=v[i]/w[i];
    for(i=1;i<=n-1;i++)
    {
        for(j=i+1;j<=n;j++)
            if(perp[i]<perp[j]) //冒泡排序perp[],order[],sortv[],sortw[]
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
    if(bound(i+1)>bestp)//符合条件搜索右子数
        backtrack(i+1);
}
double bound(int i)   //计算上界函数
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
