#include<stdio.h>
// һ���ݹ麯��
void mergesort(int *num,int start,int end);
// ������������������ź����������кϲ�
void merge(int *num,int start,int middle,int end);int main()
{
// ��������
    int num[10000];
    int i,n;
    // ����֮ǰ
    scanf("%d",&n);
    for (i = 0; i < n; i++) {
        scanf("%d",&num[i]);
    }


    // ���кϲ�����
    mergesort(num,0,n-1);

    // ����֮��
    for (i=0; i<n; i++)
    {
        printf("%d\n",num[i]);
    }
    return 0;}
//�����������������ϸ��
void mergesort(int *num,int start,int end){
    int middle;
    if(start<end)
    {
        middle=(start+end)/2;
        // �鲢�Ļ���˼��
        // �����
        mergesort(num,start,middle);
        // ���ұ�
        mergesort(num,middle+1,end);
        // �ϲ�
        merge(num,start,middle,end);

    }

}
//����������ڽ��������ź���������кϲ�
void merge(int *num,int start,int middle,int end)
{
    int n1=middle-start+1;
    int n2=end-middle;
    // ��̬�����ڴ棬�����������������������ߵ�����
    int *L=new int[n1+1];
    int *R=new int[n2+1];
    int i,j=0,k;
    //���½����������鸳ֵ
    for (i=0; i<n1; i++)
    {
        *(L+i)=*(num+start+i);
    }
    // �ڱ�Ԫ��
    *(L+n1)=1000000;
    for (i=0; i<n2; i++)
    {
    *(R+i)=*(num+middle+i+1);
    }
    *(R+n2)=1000000;
    i=0;
    // ���кϲ�
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
