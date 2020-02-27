#include<stdio.h>//迪杰斯特拉算法
#define MaxVertexNum 100    //最大的顶点个数
typedef char VertexType;    //顶点类型
typedef int EdgeType;       //边的权值类型
typedef struct{
	VertexType vexs[MaxVertexNum];//顶点表
    EdgeType edges[MaxVertexNum][MaxVertexNum];//邻接矩阵
	int n, e;            //实际的顶点数和边数
}MGraph;
int Shortest(MGraph *G, int P[], int D[], int N, int e);
int main(){
	MGraph G;
	int n, m, i, j, s1, s2, t=0, A[100], B[100], C[100], D[100], F[100];
	scanf("%d%d", &n, &m);

	for(i=1;i<=m;i++)
		scanf("%d%d%d", &A[i], &B[i], &C[i]);
	scanf("%d%d", &s1, &s2);
    for(i=1;i<=n;i++)
	   for(j=1;j<=n;j++)
		   for(t=1;t<=m;t++){
			   if(i==A[t] && j==B[t]){
			       G.edges[i][j]=C[t];
				   break;
			   }
			   else
			       G.edges[i][j]=10000;
		   }
    Shortest(&G, D, F, n, s1);
    if(F[s2]<10000)
	    printf("%d\n", F[s2]);
    else printf("%d\n", -1);
    return 0;
}
int Shortest(MGraph *G, int P[], int D[], int N, int e){
	int min, i, j, k;
	int final[100]={1,0};
	for(i=1;i<=N;i++){
		D[i]=G->edges[e][i];
		P[i]=0;
	}
	D[e]=0;
	P[e]=-1;
    final[1]=0;
    final[e]=1;
	for(i=1;i<N;i++){
		min=10000+1;      //min=INFINITY+1;
		for(k=1;k<=N;k++)
			if(final[k]==0 && D[k]<min){
				j=k;
				min=D[k];
			}
		final[j]=1;
		for(k=1;k<=N;k++)
			if(final[k]==0 && (D[j]+G->edges[j][k]<D[k])){
				D[k]=D[j]+G->edges[j][k];
				P[k]=j;
			}
	}

	return 1;
}
