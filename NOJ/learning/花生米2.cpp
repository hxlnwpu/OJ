#include<stdio.h>
int List[1001]={0};//对取第i粒花生米的判断(List[0]不用)
void search()
{
    int i;
    for(int i=1;i<=10;i++)//1~10粒时每次人工判断得出规律
    {                     //可以看出;若List[i]=1,则必有List[i-1]=0，List[i-5]=0
        if(i%2==0)    List[i]=1;
        else    List[i]=0;
    }
    for(i=11;i<=1000;i++)
    {
        if(List[i-1]==1 &&List[i-5]==1 &List[i-10]==1)
            List[i]=0;//如果取1,5,10粒后应由Jerry先取才会赢，则当前让Tom先取，不论Tom怎么取，Jerry都会赢
        else
            List[i]=1;//如果Tom先取Jerry会输，则Jerry先取Jerry会赢（为什么？），当前让Jerry先取
    }
}
int main()
{
    int n;
    search();
    scanf("%d",&n);//输入第一个测例
    while(n)
    {
        printf("%d\n",List[n]);
        scanf("%d",&n);
    }
    return 0;
}
