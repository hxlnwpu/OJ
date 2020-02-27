#include <stdio.h>
#include <stdlib.h>
#define MAX 20
#define INFINITY 10000

int A[MAX][MAX];
int D[MAX][MAX]= {0}; /*D[v1][v2]表示v1到v2的最短路径*/
int P[MAX][MAX];/*P[v1]如果为1则表明v3是v1-v2最短路径上的顶点*/
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
        for(w=0; w<n; w++) /*对各节点之间距离进行初始化*/
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
    for(i=0; i<n; i++) /*向邻接矩阵赋值*/
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
