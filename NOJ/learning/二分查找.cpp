#include<stdio.h>
#include<stdlib.h>
#include<stdafx.h>
void binarysearch(int n,int k,int a[])
{
		int left=0;
		int right=n-1;
		int r=0;
		while(left<=right)
		{
			int middle=(left+right)/2;

			if(k==a[middle])  r=1;
			if(k>a[middle]) left=middle+1;
			else right=middle-1;
		}
		if(r==1) printf("Yes\n");
		    else printf("No\n");
}
int main()
{
	int i,n,m,a[10000],b[50000];
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	scanf("%d",&m);
	for(i=0;i<m;i++)
		scanf("%d",&b[i]);
	for(i=0;i<m;i++)
	    binarysearch(n,b[i],a);
	return 0;
}

