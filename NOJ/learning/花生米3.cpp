
#include<iostream>

using namespace std;

bool dp[1001][1001];
//dp[i][j]��ʾ��ʣi�������ף����ҵ�ǰ����ȡj����ʱ��,Ҫʹ�Է�ȡ�����һ�����Ƿ�Ӧ����ȡ
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
