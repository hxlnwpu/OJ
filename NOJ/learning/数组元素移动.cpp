#include<stdio.h>
#include<stdlib.h>
int main()
{
    int n,i,k,a[100];
    scanf("%d",&n);
    for(i=0;i<n;i++)
        scanf("%d",&a[i]);
    scanf("%d",&k);
    for(i=n-k;i<n;i++)
        printf("%d\n",a[i]);
    for(i=0;i<n-k;i++)
       printf("%d\n",a[i]);
     return 0;
}
