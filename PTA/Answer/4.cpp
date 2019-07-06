/*PTA 基础编程题目集 6-10  本题要求实现一个打印非负整数阶乘的函数。 void Print_Factorial ( const int N ); 其中N是用户传入的参数，其值不超过1000。如果N是非负整数，则该函数必须在一行中打印出N!的值，否则打印“Invalid input”。*/


#include <stdio.h>

void Print_Factorial ( const int N );

int main()
{
    int N;

    scanf("%d", &N);
    Print_Factorial(N);
    return 0;
}

/*
void Print_Factorial ( const int N )  #超出范围，大数乘法
{
    int n=(int) N;
    int result=1;
    if(n<=0)
    {
        printf("Invalid input");
    }
    else
    {
        for(int i=n; i>1; i--)
            result=result*i;
        printf("%d",result);
    }
}*/
void Print_Factorial ( const int N) {
    int fact[2568] = {0};
    fact[0] = 1;
    int n = 0, k = 1; // n 为进的数，k 为当前结果的总位数
    for (int i=2; i<=N; i++) {
        for (int j=0; j<k; j++) {
            int temp = i * fact[j] + n;
            fact[j] = temp  % 10;
            n = temp / 10;
            if (n && j==k-1) {
                k++;
            } // 当有进位且已经处理到最前位时才开拓目标数组的下一位
        }
    }
    for (int i=k-1; i>=0; i--) {
        if (N >= 0) {
            printf("%d", fact[i]);
        } else {
            printf("Invalid input");
        }
    }
    printf("\n");
}
