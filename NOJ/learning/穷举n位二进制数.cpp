	#include <iostream>
	using namespace std;
	int n,c[20];
	void Search(int m)
	{
	    int i;

	    if(m==n)
	    {
	        for(i=0;i<n;i++)
	        cout<<c[i];
	        cout<<endl;
	    }
	    else
	    {
	        c[m]=0;Search(m+1);
	        c[m]=1;Search(m+1);
	    }
	}
	int main()
	{
	    int m=0;
	    cin>>n;
	    Search(m);
	    return 0;
	}
