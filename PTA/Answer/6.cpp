/* PTA 6-12 判断奇偶性 本题要求实现判断给定整数奇偶性的函数。*/
#include <stdio.h>

int even( int n );

int main()
{
    int n;

    scanf("%d", &n);
    if (even(n))
        printf("%d is even.\n", n);
    else
        printf("%d is odd.\n", n);

    return 0;
}
int even( int n )
{
    if(n%2==0)
        return 1;
    else return 0;
}
