#include <stdio.h>
int f[8]={-409,-407,-206,-202,202,206,407,409};
int step(int s,int e)
{
    int map[42000]={0};
    int d[42000]={0},ds[42000]={0};
    int start,endd,x,y,i;
    for(i=0;i<204;i++)
    {
        map[i]=1;
        map[i+204]=1;
        map[i*204]=1;
        map[i*204+1]=1;
        map[i*204+203]=1;
        map[i*204+202]=1;
        map[204*202+i]=1;
        map[204*203+i]=1;
    }
    start=0;
    endd=1;
    d[start]=s;
    map[s]=1;
    ds[start]=0;
    while(start<endd)
    {
        x=d[start];
        y=ds[start];
        if(x==e)
            break;
        for(i=0;i<8;i++)
        {
            if(map[x+f[i]]==0)
            {
                map[x+f[i]]=1;
                d[endd]=x+f[i];
                ds[endd]=y+1;
                endd++;
            }
        }
        start++;
    }
    return(y);
}
int main()
{
    int n,a,b,c,d,i;
    int e[100]={0};
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        scanf("%d%d%d%d",&a,&b,&c,&d);
        e[i]=step((a+1)*204+b+1,(c+1)*204+d+1);
    }
    for(i=0;i<n;i++)
    {
        printf("%d\n",e[i]);
    }
    return(0);
}
