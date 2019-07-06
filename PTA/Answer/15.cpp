#include<iostream>

 using namespace std;

 int main()
 {
     int speed=0;
     cin>>speed;
     if(speed<=60)
        cout<<"Speed: "<<speed<<" - OK"<<endl;
     else
        cout<<"Speed: "<<speed<<" - Speeding"<<endl;

     return 0;
 }
