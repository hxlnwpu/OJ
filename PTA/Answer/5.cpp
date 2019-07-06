/* PTA 6-11  本题要求实现一个函数，求N个集合元素A[]的中位数，即序列中第⌊N/2+1⌋大的元素。其中集合元素的类型为自定义的ElementType。*/
#include <stdio.h>

#define MAXN 10
typedef float ElementType;

ElementType Median( ElementType A[], int N );

int main ()
{
    ElementType A[MAXN];
    int N, i;

    scanf("%d", &N);
    for ( i=0; i<N; i++ )
        scanf("%f", &A[i]);
    printf("%.2f\n", Median(A, N));

    return 0;
}
ElementType Median( ElementType A[], int N ) //我的
{
    int i,j;
    for(i=0;i<N;i++)
		{
		for(j=0;j<=N-i;j++)
			if(A[j]>A[j+1])
			{
				ElementType t=A[j];
				A[j]=A[j+1];
				A[j+1]=t;
			}
	}
	return A[N/2+1];
}

ElementType Median( ElementType A[], int N){   //正确的
    int i, j, p;
    ElementType s;

    //将数组排序
    for ( p = N / 2; p > 0; p /= 2){
        for ( i = p; i < N; i++){
            s = A[ i ];
            for (j = i;j >= p;j -= p ){
                if ( s < A[ j - p ])
                    A[ j ] = A[ j - p ];
                else
                    break;
            }
            A[ j ] = s;
        }
    }

    return A[ N / 2 ];
}
