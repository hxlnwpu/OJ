#include<iostream>
#include<iomanip>

using namespace std;

int main()
{
    float years,hours;
    cin>>years>>hours;
    cout<<setiosflags(ios::fixed)<<setprecision(2);   
    if(years>=5)
    {
        if(hours<=40)
            cout<<hours*50<<endl;
        else
            cout<<40*50+(hours-40)*50*1.5<<endl;
    }
    else
    {
        if(hours<=40)
            cout<<hours*30<<endl;
        else
            cout<<40*30+(hours-40)*30*1.5<<endl;
    }

  return 0;
}
