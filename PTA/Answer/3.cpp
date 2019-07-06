/* PTA 基础编程题目集 6-9  本题要求实现一个函数，可统计任一整数中某个位数出现的次数。例如-21252中，2出现了3次，则该函数应该返回3。*/

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
