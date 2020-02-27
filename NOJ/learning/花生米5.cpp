#include<stdio.h>
#include<iostream>
int a[10002][10002],sum=1,flag=0,n;
using namespace std;
void Search()
{
    int i,j,k;
    for(i=1;i<=100;i++)
           a[i][i]=1;
     for(i=1;i<=100;i++){
         flag=0;
         sum=1;
        for(j=1;j<i;j++)
        {
           sum=sum+j;
           for(k=sum;k<=3*sum;k++)
           {
               if(k>0&&k<=i-sum)
                 {
                     if(a[i-sum][k]==1)
                       flag=1;
                 }
           }
           if(flag==1)
                a[i][j]=1;
            else
                a[i][j]=0;

        }}
       /* for(i=1;i<=100;i++)
           for(j=1;j<=100;j++)
             {cout<<a[i][j]<<" ";
             if(j==10)
                cout<<endl;}*/
                /*cout<<a[15][1]<<endl;
                cout<<a[79][1]<<endl;*/
}

int main()
{
    double m;
    scanf("%lf",&m);
    while(m>0)
    {
        n=(int)m*10;
        Search();
        cout<<a[n][1]<<endl;
        scanf("%lf",&m);

     }
     return 0;
}
