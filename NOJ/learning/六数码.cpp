#include<stdio.h>
#include<string.h>
int lcs_length(char x[], char y[]);
int main()
{
	char x[201],y[201];
	int len;
    scanf("%s%s",x,y);
	len=lcs_length(x,y);
	printf("%d\n",len);
}
int lcs_length(char x[], char y[] )
{
	int m,n,i,j,l[201][201];
	m=strlen(x);
	n=strlen(y);
	for(i=0;i<m+1;i++)
		l[i][0]=0;
	for(j=0;j<n+1;j++)
		l[0][j]=0;
	for(i=1;i<=m;i++)
		for(j=1;j<=n;j++)
			if(x[i-1]==y[j-1])     //i,j从1开始，但字符串是从0开始
				l[i][j]=l[i-1][j-1]+1;
			else if(l[i][j-1]>l[i-1][j])
				l[i][j]=l[i][j-1];
			else
				l[i][j]=l[i-1][j];
	return l[m][n];
}
