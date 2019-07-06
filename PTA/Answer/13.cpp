#include<iostream>
#include <iomanip>

using namespace std;
int main()
{
 double a,b;
 int c;
 char d;
 cin>>a>>c>>d>>b;
 cout<<d<<' '<<c<<' ';
 cout <<setiosflags(ios::fixed)<< setprecision(2)<< a<<' ';
 cout <<setiosflags(ios::fixed)<< setprecision(2) << b;

}
