#include<stdio.h>
int List[1001]={0};//��ȡ��i�������׵��ж�(List[0]����)
void search()
{
    int i;
    for(int i=1;i<=10;i++)//1~10��ʱÿ���˹��жϵó�����
    {                     //���Կ���;��List[i]=1,�����List[i-1]=0��List[i-5]=0
        if(i%2==0)    List[i]=1;
        else    List[i]=0;
    }
    for(i=11;i<=1000;i++)
    {
        if(List[i-1]==1 &&List[i-5]==1 &List[i-10]==1)
            List[i]=0;//���ȡ1,5,10����Ӧ��Jerry��ȡ�Ż�Ӯ����ǰ��Tom��ȡ������Tom��ôȡ��Jerry����Ӯ
        else
            List[i]=1;//���Tom��ȡJerry���䣬��Jerry��ȡJerry��Ӯ��Ϊʲô��������ǰ��Jerry��ȡ
    }
}
int main()
{
    int n;
    search();
    scanf("%d",&n);//�����һ������
    while(n)
    {
        printf("%d\n",List[n]);
        scanf("%d",&n);
    }
    return 0;
}
