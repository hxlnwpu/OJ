#include<stdlib.h>
#include<stdio.h>
#define MAX	10000
#define MAXVEX 20
#define INFINITY 10000
typedef struct
{
    char  vexs[MAXVEX];		/* 顶点信息 */
    int   arcs[MAXVEX][MAXVEX];	/* 邻接矩阵信息 */
    int   arcCount, vexCount;	/* 图的顶点个数 */
} Graph, *PGraph;
typedef struct
{
	    char vertex;	/* 顶点信息 */
        int length;	/* 最短路径长度 */
	    int  prevex;	/* 从v0到达vi(i=1,2,…n-1)的最短路径上vi的前趋顶点 */
} Path;
void CreateGraph(PGraph pG){
    int i,j;
    scanf ("%d",&pG->vexCount); /* 输入顶点数、边数和是否输入边的相关信息的标志 */
    for(i=0;i<pG->vexCount;i++)	/* 初始化邻接矩阵 */
        for(j=0;j<pG->vexCount;j++)
			scanf("%d",&pG->arcs[i][j]);
}
void dijkstra(Graph graph, Path dist[])
{
    int i,j,minvex;
    int  min=0;
    dist[0].length=0;
    dist[0].prevex=0;
    dist[0].vertex=graph.vexs[0];
    graph.arcs[0][0]=1;	/*表示顶点v0在集合U中 */
    for (i=1;i<graph.vexCount;i++)
    {
        /* 初始化集合V-U中顶点的距离值 */
        dist[i].length=graph.arcs[0][i];
        dist[i].vertex=graph.vexs[i];
        if (dist[i].length!=MAX)  dist[i].prevex=0;
        else  dist[i].prevex=-1;
    }
    for (i=1;i<graph.vexCount;i++)
    {
        min=MAX;
        minvex=0;
        for (j=1;j<graph.vexCount;j++)
            /*在V-U中选出距离值最小顶点*/
            if ( (graph.arcs[j][j]==0) && (dist[j].length<min) )
            {
                min=dist[j].length;
                minvex=j;
            }
        if (minvex==0)	/* 从v0没有路径可以通往集合V-U中的顶点 */
            break;
        graph.arcs[minvex][minvex]=1;	/* 集合V-U中路径最小的顶点为minvex */
		for (j=1; j<graph.vexCount; j++)
        {
            /* 调整集合V-U中的顶点的最短路径 */
            if (graph.arcs[j][j]==1)
                continue;
            if (dist[j].length>dist[minvex].length+graph.arcs[minvex][j])
            {
                dist[j].length=dist[minvex].length+graph.arcs[minvex][j];
                dist[j].prevex=minvex;
            }
        }
    }
}
int main()
{
	int i;
	Graph T;
	Path a[100];
	CreateGraph(&T);
	dijkstra(T,a);
	for(i=0;i<T.vexCount-1;i++)
		printf("%d ",a[i].length);
	printf("%d",a[i].length);
	printf("\n");
	return 0;
}
