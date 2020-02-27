#include<stdio.h>
struct gstation
{
    int num;//number of gas station
    double dis;// distance to the start
    double fee;// cost of per L
} GS[51];
int count=0,n;
double b[1000]= {0}; //cost of one routine
double restv[51];//the rest of oil when arrived to NO.i station
double distance;
double volume,MilesPerL,cost1;
int a[51],c[51];//state of gas station
double min=100000;
void check()
{
    int i;
    for(i=1; i<=n; i++)
        if(a[i]==1)
        {
            b[count]+=(volume-restv[i])*GS[i].fee+2;
        }
    b[count]+=cost1;
    if(b[count]<min)
    {
        min=b[count++];
        for(i=1; i<=n; i++)
            c[i]=a[i];
    }
}
void search(int m)
{
    if(m>n)
        check();
    else if(m<n)
    {
        if(restv[m]*MilesPerL>=GS[m+1].dis-GS[m].dis)
        {
            a[m]=0;
            restv[m+1]=restv[m]-(GS[m+1].dis-GS[m].dis)/MilesPerL;
            search(m+1);
        }
        if(restv[m]*MilesPerL<GS[m+1].dis-GS[m].dis ||restv[m]<=0.5*volume)  //attention: the rest of oil must be <= half of the volume!
        {
            a[m]=1;
            restv[m+1]=volume-(GS[m+1].dis-GS[m].dis)/MilesPerL;
            search(m+1);
        }
    }
    else
    {
        if(restv[m]*MilesPerL>=distance-GS[m].dis)
        {
            a[m]=0;
            search(m+1);
        }
        else
        {
            a[m]=1;
            search(m+1);
        }
    }
}
int  main()
{
    int i,j=0,flag=0;
    scanf("%lf",&distance);
    scanf("%lf %lf %lf %d",&volume,&MilesPerL,&cost1,&n);
    for(i=1; i<=n; i++)
    {
        scanf("%lf %lf",&GS[i].dis,&GS[i].fee);
        GS[i].num=i;
    }
    restv[1]=volume-GS[1].dis/MilesPerL;
    search(1);
    for(j=1; j<=n; j++)
        if(c[j]==1) flag++;
    printf("%.2lf %d\n",min,flag);
    for(j=1; j<=n; j++)
        if(c[j]==1)
            printf("%d ",j);  //printf("%d",c[n]);
    printf("\n");
    return 0;
}
