#include<stdio.h>//弗洛伊德算法
#define MAX 30   //最大的顶点个数
typedef char Dtype;    //顶点类型
typedef int Etype;       //边的权值类型
typedef struct
{
    Dtype vex[MAX];//顶点表
    Etype edge[MAX][MAX];//邻接矩阵
    int n, e;            //实际的顶点数和边数
} MGraph;

void shortpath_f(MGraph G, int P[30][30][30], int D[30][30], int v, int w)
{
    int i, u;
    for(v=0; v<G.n; v++)
        for(w=0; w<G.n; w++)
        {
            D[v][w]=G.edge[v][w];
            for(u=0; u<G.n; u++) P[v][w][u]=0;
            if(D[v][w]<10000)
            {
                P[v][w][v]=1;
                P[v][w][w]=1;
            }
        }
    for(u=0; u<G.n; u++)
        for(v=0; v<G.n; v++)
            for(w=0; w<G.n; w++)
                if((D[v][u]+D[u][w])<D[v][w])
                {
                    D[v][w]=D[v][u]+D[u][w];
                    for(i=0; i<G.n; i++)
                        P[v][w][i]=P[v][u][i]||P[u][w][i];
                }
}

int main()
{
    MGraph G;
    int n, i, j, a, t=0,  m,  e;
    int A[10][10], B[30][30][30], F[30][30], p[20],q[20];
    scanf("%d", &n);
    G.n=n;
    for(i=0; i<n; i++)
        for(j=0; j<n; j++)
            scanf("%d", &A[i][j]);
   scanf("%d", &m);
    for(i=0;i<m; i++)
    {
        scanf("%d%d", &p[i], &q[i]);
    }
    for(i=0; i<n; i++)
        for(j=0;j<n; j++)
            G.edge[i][j]=A[i][j];
    for(i=0;i<m;i++)
    {
        shortpath_f(G, B, F, p[t],q[t]);
        a=p[t];
        e=q[t];
        printf("%d\n", F[a][e]);
        t=t+1;

    }
    return 0;
}

