//快速排序
#include<iostream>
using namespace std;


void quickSort(int *A,int left,int right)
{
    if(left<right)
    {
        int i=left,j=right,x=A[left];
        while(i<j)
        {
            while(i<j&& A[j]>=x) j--;
            if(i<j) A[i++]=A[j];
            while(i<j&&A[i]<x)  i++;
            if(i<j) A[j--]=A[i];
        }
        A[i]=x;
        quickSort(A,left,i-1);
        quickSort(A,i+1,right);
    }      
}
int main()
{
    int A[10000],n;
    cin>>n;
    for(int i=0;i<n;i++)
        cin>>A[i];
    quickSort(A,0,n-1);
    for(int i=0;i<n;i++)
        cout<<A[i]<<endl;
    return 0;
}
