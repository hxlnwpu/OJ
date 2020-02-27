
#include<iostream>

using namespace std;

bool dp[1001][1001];
//dp[i][j]表示还剩i粒花生米，并且当前可以取j粒的时候,要使对方取走最后一粒，是否应该先取
int main()
{
	int n;
	cin>>n;
	while(n!=0)
    {
        for(int i=2;i<=n;++i)
        {
            for(int j=1;j<i-1;++j)
            {
                bool flag=false;
                for(int k=1;k<=j&&k<=i;++k)
				if(!dp[i-k][2*k])
				{
					flag=true;
					break;
				}
			dp[i][j]=flag;
            }

		for(int j=i-1;j<=n;++j)
			dp[i][j]=true;
        }
	cout<<dp[n][1]<<endl;
	cin>>n;
    }
}
