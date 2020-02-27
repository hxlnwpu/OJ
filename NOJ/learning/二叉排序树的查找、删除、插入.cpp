#include<stdio.h>
int main()
{
    int i, j, h, t=0, a, b, c, d, e, f;
    int A[200], B[200], C[200];
    scanf("%d", &a);
    for(i=0; i<a; i++)
        scanf("%d", &A[i]);
    scanf("%d%d", &f, &b);
    scanf("%d", &c);
    scanf("%d", &d);
    for(j=0; j<a; j++)
    {
        h=0;
        for(t=0; t<a; t++)
        {
            if(j==t) h++;
            else if(A[j]!=A[t]) h++;
            else break;
        }
        if(h!=a) A[j]=-1;
    }
    t=0;
    for(j=0; j<a; j++)
        if(A[j]!=-1)
        {
            B[t]=A[j];
            t++;
        }
    for(j=0; j<t; j++)
        for(i=0; i<t; i++)
        {
            if(B[j]<B[i])
            {
                e=B[j];
                B[j]=B[i];
                B[i]=e;
            }
        }
    for(j=0; j<t-1; j++)
        printf("%d ", B[j]);
    printf("%d\n", B[t-1]);
    for(h=t-1; h>=0; h--)
        if(B[h]>f && B[h]<b)
            break;
    if(h==-1)
        printf("NOT FOUND\n");
    else
    {
        for(i=0; i<h; i++)
            if(B[i]>f && B[i]<b)
                printf("%d ", B[i]);
        printf("%d\n", B[h]);
    }
    j=0;
    if(B[t-1]==c) j++;
    if(j!=1)
    {
        for(i=0; i<t-1; i++)
            if(B[i]!=c)
                printf("%d ", B[i]);
        printf("%d\n", B[t-1]);
    }
    else
    {
        for(i=0; i<t-2; i++)
            printf("%d ", B[i]);
        printf("%d\n", B[t-2]);
    }
    j=0;
    for(i=0; i<t; i++)
        if(B[i]!=c)
        {
            C[j]=B[i];
            j++;
        }
    h=0;
    for(i=0; i<j; i++)
        if(C[i]==d)
            h++;
    if(h!=0)
    {
        for(i=0; i<j-1; i++)
            printf("%d ", C[i]);
        printf("%d\n", C[j-1]);
    }
    else
    {
        C[j]=d;
        for(t=0; t<=j; t++)
            for(i=0; i<=j; i++)
                if(C[t]<C[i])
                {
                    e=C[t];
                    C[t]=C[i];
                    C[i]=e;
                }
        for(i=0; i<j; i++)
            printf("%d ", C[i]);
        printf("%d\n", C[j]);
    }
    return 0;
}

