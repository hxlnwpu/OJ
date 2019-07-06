#include<iostream>
#include<iomanip>

using namespace std;

int main()
{
    float water;
    cin>>water;
    cout<<setiosflags(ios::fixed)<<setprecision(2);   //setiosflags和setprecision都是控制浮点数输出
    if(water<=15)
        cout<<water*4/3<<endl;
    else
        cout<<2.5*water-17.5<<endl;

  return 0;
}
