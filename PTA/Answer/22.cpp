#include<iostream>
#include<iomanip>  
using namespace std;

int  main()
{
    double y,sum=1,k=1,m=1,n=1;
    int i=1;
    cin>>y;
    while(k>=y)
    {
        m *= i;  
        n = n*(2 * i + 1);
        k=m/n;
        sum+=k;
        i++;
    }
    sum=sum*2;
    cout<<setiosflags(ios::fixed)<<setprecision(6);
    cout<<sum<<endl;
   
}
