#include<stdio.h>
int main()
{
    int A[200], B[100];
    int i, j, t, e;
    for(i=0;; i++)
    {
        scanf("%d", &A[i]);
        if((getchar())=='\n') break;
    }
    for(j=0;; j++)
    {
        scanf("%d", &B[j]);
        if((getchar())=='\n') break;
    }
    for(t=i+1; t<i+j+2; t++)
        A[t]=B[t-i-1];
    t=i+j+2;
    for(j=0; j<t; j++)
        for(i=0; i<t; i++)
            if(A[j]<A[i])
            {
                e=A[j];
                A[j]=A[i];
                A[i]=e;
            }
    for(i=0; i<t-1; i++)
        if(A[i]!=-1)
            printf("%d ", A[i]);
    printf("%d\n", A[t-1]);
    return 0;
}
