#include<stdlib.h>
#include<stdio.h>
#define MAX	10000
#define MAXVEX 20
#define INFINITY 10000
typedef struct
{
    char  vexs[MAXVEX];		/* ������Ϣ */
    int   arcs[MAXVEX][MAXVEX];	/* �ڽӾ�����Ϣ */
    int   arcCount, vexCount;	/* ͼ�Ķ������ */
} Graph, *PGraph;
typedef struct
{
	    char vertex;	/* ������Ϣ */
        int length;	/* ���·������ */
	    int  prevex;	/* ��v0����vi(i=1,2,��n-1)�����·����vi��ǰ������ */
} Path;
void CreateGraph(PGraph pG){
    int i,j;
    scanf ("%d",&pG->vexCount); /* ���붥�������������Ƿ�����ߵ������Ϣ�ı�־ */
    for(i=0;i<pG->vexCount;i++)	/* ��ʼ���ڽӾ��� */
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
    graph.arcs[0][0]=1;	/*��ʾ����v0�ڼ���U�� */
    for (i=1;i<graph.vexCount;i++)
    {
        /* ��ʼ������V-U�ж���ľ���ֵ */
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
            /*��V-U��ѡ������ֵ��С����*/
            if ( (graph.arcs[j][j]==0) && (dist[j].length<min) )
            {
                min=dist[j].length;
                minvex=j;
            }
        if (minvex==0)	/* ��v0û��·������ͨ������V-U�еĶ��� */
            break;
        graph.arcs[minvex][minvex]=1;	/* ����V-U��·����С�Ķ���Ϊminvex */
		for (j=1; j<graph.vexCount; j++)
        {
            /* ��������V-U�еĶ�������·�� */
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
