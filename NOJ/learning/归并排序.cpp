#include<stdio.h>
// 一个递归函数
void mergesort(int *num,int start,int end);
// 这个函数用来将两个排好序的数组进行合并
void merge(int *num,int start,int middle,int end);int main()
{
// 测试数组
    int num[10000];
    int i,n;
    // 排序之前
    scanf("%d",&n);
    for (i = 0; i < n; i++) {
        scanf("%d",&num[i]);
    }


    // 进行合并排序
    mergesort(num,0,n-1);

    // 排序之后
    for (i=0; i<n; i++)
    {
        printf("%d\n",num[i]);
    }
    return 0;}
//这个函数用来将问题细分
void mergesort(int *num,int start,int end){
    int middle;
    if(start<end)
    {
        middle=(start+end)/2;
        // 归并的基本思想
        // 排左边
        mergesort(num,start,middle);
        // 排右边
        mergesort(num,middle+1,end);
        // 合并
        merge(num,start,middle,end);

    }

}
//这个函数用于将两个已排好序的子序列合并
void merge(int *num,int start,int middle,int end)
{
    int n1=middle-start+1;
    int n2=end-middle;
    // 动态分配内存，声明两个数组容纳左右两边的数组
    int *L=new int[n1+1];
    int *R=new int[n2+1];
    int i,j=0,k;
    //将新建的两个数组赋值
    for (i=0; i<n1; i++)
    {
        *(L+i)=*(num+start+i);
    }
    // 哨兵元素
    *(L+n1)=1000000;
    for (i=0; i<n2; i++)
    {
    *(R+i)=*(num+middle+i+1);
    }
    *(R+n2)=1000000;
    i=0;
    // 进行合并
    for (k=start; k<=end; k++)
    {
        if(L[i]<=R[j])
        {
            num[k]=L[i];
            i++;
        }
        else
       {
            num[k]=R[j];
            j++;
        }
    }
    delete [] L;
    delete [] R;
}
