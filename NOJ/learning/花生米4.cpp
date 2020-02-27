#include<stdio.h>
int num[10]={0};//每堆花生米数量
int n;//(0~10)
int search()//直接根据n的只判断Jerry取的先后次序(算法中没有循环)
{
    int count=0;
    if(n==1)  return 1;//只有一堆花生米，Jerry取走该堆数量-1即可赢
    else
    {    for(int i=0;i<n;i++)
            if(num[i]==1)//统计单粒堆的堆数
                count++;
        if(count==n)//n堆花生米，都是单粒堆
        {
            if(n%2==0)//由于n取0~10，与花生米(二)的前10粒算法相同
                return 0;
            else
                return 1;
        }
        else//至少有一堆不是单粒堆
        {
            if(n==2)//只有2堆花生米
            {
                //若Jerry取完后两堆只剩下(1,1)(2,2)....(k,k),则Jerry必赢
                //因为只要之后每次Tom取之后，Jerry取与Tom相同的数量就必赢
                if(num[0]==num[1])  return 0;
                else     return 1;
            }
            else//多于2堆花生米
            {    int L1,L2;//标记单粒堆和多粒堆数量的奇偶
                if(count>0 &&count%2==0)//(有单粒堆)单粒堆的数量为偶数（注意都不大于10）
                     L1=0;             //让对方先取，Jerry能取道最后一粒
                else L1=1;
                if((n-count)%2==0)//多粒堆的数量为偶数
                    L2=0;
                else L2=1;
                //////////////////////////////////////??????
                if(L1==1 &&L2==1)//单粒堆数量和多粒堆数量均为奇数
                    return 1;
                else
                    return 0;//单粒堆数量和多粒堆数量中有偶数，则让对方取数成(单粒堆数量和多粒堆数量)均奇，
                            //在对方取数成均奇之前Jerry则一直取数保持(单粒堆数量和多粒堆数量)非均奇
                //////////////////////////////////////
            }
        }
    }
}
int main()
{
    scanf("%d",&n);//输入花生米堆数(0~10之间)
    while(n)
    {
        for(int i=0;i<n;i++)
            scanf("%d",&num[i]);//每堆花生米的数量num[i](0~100之间)（除去苦的那粒花生米 ）
        int temp=search();
        printf("%d\n",temp);
        scanf("%d",&n);//下一轮测试
    }
    return 0;
}
