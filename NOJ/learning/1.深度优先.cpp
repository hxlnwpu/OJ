#include<stdio.h>//迪杰斯特拉算法
#define MaxVertexNum 100   //最大的顶点个数
typedef char VertexType;    //顶点类型
typedef int EdgeType;       //边的权值类型
typedef struct
{
    VertexType vexs[MaxVertexNum];//顶点表
    EdgeType edges[MaxVertexNum][MaxVertexNum];//邻接矩阵
    int n, e;            //实际的顶点数和边数
} MGraph;
int Shortest(MGraph *G, int P[], int D[], int N, int e) //Dijkstra算法
{
    int min, i, j, k;
    int final[10]= {1,0};
    for(i=1; i<=N; i++)
    {
        D[i]=G->edges[e][i];
        P[i]=0;
    }
    D[e]=0;
    P[e]=-1;
    final[1]=0;
    final[e]=1;
    for(i=1; i<N; i++)
    {
        min=10000+1;
        for(k=1; k<=N; k++)
            if(final[k]==0 && D[k]<min)
            {
                j=k;
                min=D[k];
            }
        final[j]=1;
        for(k=1; k<=N; k++)
            if(final[k]==0 && (D[j]+G->edges[j][k]<D[k]))
            {
                D[k]=D[j]+G->edges[j][k];
                P[k]=j;
            }
    }

    return 1;
}
int main()
{
    MGraph G;
    int n, m, i, j, t=0, A[100], B[100], C[100], D[100], F[100], E[100];
    scanf("%d%d", &n, &m);

    for(i=1; i<=n; i++)
        scanf("%d%d", &A[i], &B[i]);
    for(i=1; i<=m; i++)
        scanf("%d%d", &C[i], &D[i]);


    for(i=1; i<=n+1; i++)
        for(j=1; j<=n+1; j++)
            for(t=1; t<=n; t++)
            {
                if(i==A[t] && j==B[t])
                {
                    G.edges[i][j]=1;
                    break;
                }
                else if(t==n)
                    G.edges[i][j]=10000;


            }
    for(i=1; i<=m; i++)
    {
        Shortest(&G, E, F, n+1, C[i]);
        if(F[D[i]]<10000)
            printf("Y\n");
        else printf("N\n");
    }
    return 0;
}
