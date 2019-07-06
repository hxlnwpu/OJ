#include<iostream>
#include<iomanip>    

using namespace std;

int main()
{
    int a,b,count=0,sum=0;
    cin>>a>>b;
    for(int i=a;i<=b;i++)
    {
        count++;
        sum+=i;
        cout<<setw(5)<<setiosflags(ios::right)<<i;
        if(count%5==0 || i==b)
            cout<<endl;
    }  
    cout<<"Sum = "<<sum<<endl;
    return 0; 
}
