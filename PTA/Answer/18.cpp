#include<iostream>
#include<iomanip>

using namespace std;

int main()
{
    float water;
    cin>>water;
    cout<<setiosflags(ios::fixed)<<setprecision(2);   //setiosflags��setprecision���ǿ��Ƹ��������
    if(water<=15)
        cout<<water*4/3<<endl;
    else
        cout<<2.5*water-17.5<<endl;

  return 0;
}
