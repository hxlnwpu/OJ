/* PTA ���������Ŀ�� 6-9  ����Ҫ��ʵ��һ����������ͳ����һ������ĳ��λ�����ֵĴ���������-21252�У�2������3�Σ���ú���Ӧ�÷���3��*/

#include <stdio.h>

int Count_Digit ( const int N, const int D );

int main()
{
    int N, D;

    scanf("%d %d", &N, &D);
    printf("%d\n", Count_Digit(N, D));
    return 0;
}

int Count_Digit ( const int N, const int D )
{
    int n=(int) N,d=(int) D,m=1;
    int a[10]= {0},tmp;
    if((n==0)&&(d==0))
        return 1;
    if((n==0)&&(d!=0))
        return 0;
    if(n<0)
        n=-n;
    while(n/m!=0)
    {
        tmp=(n/m)%10;
        a[tmp]=a[tmp]+1;
        m=m*10;
    }

    return a[d];
}
