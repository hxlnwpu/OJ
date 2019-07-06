#include<iostream>

using namespace std;

int main()
{
    double open,high,low,close;
    cin>>open>>high>>low>>close;
    if(close>open)
    {
        if(low<open&&low<close)
        {
            if(high>open&&high>close)
                cout<<"R-Hollow with Lower Shadow and Upper Shadow"<<endl;
            else 
                cout<<"R-Hollow with Lower Shadow"<<endl;
        }
        else if(high>open&&high>close)
        {
            cout<<"R-Hollow with Upper Shadow"<<endl;
        }
        else
        {
            cout<<"R-Hollow"<<endl;
        }    
    }
    else if(close<open)
    {
        if(low<open&&low<close)
        {
            if(high>open&&high>close)
                cout<<"BW-Solid with Lower Shadow and Upper Shadow"<<endl;
            else 
                cout<<"BW-Solid with Lower Shadow"<<endl;
        }
        else if(high>open&&high>close)
        {
            cout<<"BW-Solid with Upper Shadow"<<endl;
        }
        else
        {
            cout<<"BW-Solid"<<endl;
        }    
    }
    else if(close==open)
    {
        if(low<open&&low<close)
        {
            if(high>open&&high>close)
                cout<<"R-Cross with Lower Shadow and Upper Shadow"<<endl;
            else 
                cout<<"R-Cross with Lower Shadow"<<endl;
        }
        else if(high>open&&high>close)
        {
            cout<<"R-Cross with Upper Shadow"<<endl;
        }
        else
        {
            cout<<"R-Cross"<<endl;
        }    
    }
    return 0;
}