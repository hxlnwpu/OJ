/*6-8 简单阶乘计算   本题要求实现一个计算非负整数阶乘的简单函数。 */

#include <stdio.h>

int Factorial( const int N );

int main()
{
    int N, NF;

    scanf("%d", &N);
    NF = Factorial(N);
    if (NF)  printf("%d! = %d\n", N, NF);
    else printf("Invalid input\n");

    return 0;
}

int Factorial( const int N )
{
    if(N>0){
    int result=1;
    int n=(int) N;
    for(int i=n;i>1;i--)
      result=result*i;
    return result;
    }
    else if(N==0) return 1;
    else return 0;
}
