/*PTA ���������Ŀ�� 6-10  ����Ҫ��ʵ��һ����ӡ�Ǹ������׳˵ĺ����� void Print_Factorial ( const int N ); ����N���û�����Ĳ�������ֵ������1000�����N�ǷǸ���������ú���������һ���д�ӡ��N!��ֵ�������ӡ��Invalid input����*/


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
void Print_Factorial ( const int N )  #������Χ�������˷�
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
    int n = 0, k = 1; // n Ϊ��������k Ϊ��ǰ�������λ��
    for (int i=2; i<=N; i++) {
        for (int j=0; j<k; j++) {
            int temp = i * fact[j] + n;
            fact[j] = temp  % 10;
            n = temp / 10;
            if (n && j==k-1) {
                k++;
            } // ���н�λ���Ѿ�������ǰλʱ�ſ���Ŀ���������һλ
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
