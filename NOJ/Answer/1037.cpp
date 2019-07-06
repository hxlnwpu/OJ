#include <iostream>

using namespace std;

int main()
{
    int a[20],b[20];
    int n,m;
    int ai=0,bi=0;
    cin>>n;
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    } 
    cin>>m;
    for(int i=0;i<m;i++)
    {
        cin>>b[i];
    }
    while(ai<n&&bi<m)
    {
        if(a[ai]<=b[bi])
        {
            cout<<a[ai]<<endl;
            ai++;
        }
        else
        {
            cout<<b[bi]<<endl;
            bi++;
        }  
    } 
    while(ai<n)
        cout<<a[ai++]<<endl;
    while(bi<m)
        cout<<b[bi++]<<endl;
    
    return 0;
}