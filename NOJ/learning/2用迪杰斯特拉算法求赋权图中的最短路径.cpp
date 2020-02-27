#include <stdio.h>
#include <stdlib.h>
#define MAX 20
#define INFINITY 10000

int A[MAX][MAX];
int D[MAX][MAX]= {0}; /*D[v1][v2]��ʾv1��v2�����·��*/
int P[MAX][MAX];/*P[v1]���Ϊ1�����v3��v1-v2���·���ϵĶ���*/
void GetPath(int v,int w)
{
    if(P[v][w]==w)return;
    GetPath(v,P[v][w]);
    printf("%d\n",P[v][w]);
    GetPath(P[v][w],w);
}
void shortpath(int n)
{
    int v,w,u;
    for(v=0; v<n; v++)
    {
        for(w=0; w<n; w++) /*�Ը��ڵ�֮�������г�ʼ��*/
        {
            D[v][w]=A[v][w];
            for(u=0; u<n; u++)
                P[v][w]=w;
        }
    }
    for(u=0; u<n; u++)
    {
        for(v=0; v<n; v++)
            for(w=0; w<n; w++)
            {
                if(D[v][u]+D[u][w]<D[v][w])
                {
                    D[v][w]=D[v][u]+D[u][w];
                    P[v][w]=P[v][u];

                }
            }
    }
}
int main()
{
    int n,i,j;
    int a,b;
    scanf("%d",&n);
    for(i=0; i<n; i++) /*���ڽӾ���ֵ*/
    {
        for(j=0; j<n; j++)
        {
            scanf("%d",&A[i][j]);
        }
    }
    scanf("%d%d",&a,&b);
    printf("%d\n",a);
    shortpath(n);
    GetPath(a,b);
    printf("%d\n",b);
    return 0;
}
