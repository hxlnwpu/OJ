#include<stdio.h>
#include<stdlib.h>
void QuickSort(int A[],int n,int left,int right)
{
	int i,j,t;
	if(left<right){
		i=left;
		j=right+1;
		while(1){
			while(i+1<n&&A[++i]<A[left]);
			while(j-1>-1&&A[--j]>A[left]);
			if(i>=j) break;
			t=A[i];
			A[i]=A[j];
			A[j]=t;
		}
		t=A[left],A[left]=A[j],A[j]=t;
		QuickSort(A,n,left,j-1);
		QuickSort(A,n,j+1,right);
	}
}
int main()
{
	int i,n,A[10000];
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&A[i]);
	QuickSort(A,n,0,n-1);
	for(i=0;i<n;i++)
		printf("%d\n",A[i]);
	return 0;

}
