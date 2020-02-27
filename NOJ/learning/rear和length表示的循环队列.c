#include<stdio.h>
#include<stdlib.h>
int M;
typedef int ElemType;
typedef struct tagQueue{
	ElemType *base;
	int front;
	int rear;
}Queue;
void Inqueue(Queue *Q){
	Q->base=(ElemType *)malloc(M*sizeof(ElemType));
	Q->front=Q->rear=0;
}
int QueueEmpty(Queue *Q){
	return Q->front==Q->rear;
}

int DQueue(Queue *Q, ElemType *e)
{
	if(Q->front==Q->rear) return 0;
	Q->front=(Q->front+1)% M;
	if(e!=NULL) *e=Q->base[Q->front];
	return 1;
}
int EQueue(Queue *Q, ElemType e)
{
	if((Q->rear+1)% M==Q->front) return 0;
	Q->rear=(Q->rear+1)% M;
	Q->base[Q->rear]=e;
	return 1;
}
int QueueL(Queue *Q){
	return Q->rear-Q->front;
}
void shutqueue(Queue *Q)
{
	if(Q->base) free(Q->base);
	Q->base=NULL;
	Q->front=Q->rear=0;
}

int main()
{
	Queue Q;
	int a[100], n, m, e, i;
	scanf("%d%d", &n, &m);
	for(i=0;i<n;i++)
		scanf("%d", &a[i]);
	M=m+1;
	Inqueue(&Q);
	for(i=0;i<n;i++){
		if(a[i]==0){
			DQueue(&Q, &e);
			printf("%d\n", e);
		}
		else if((Q.rear+1)% M==Q.front){
			printf("No\n");
	        continue;
		}
		else EQueue(&Q, a[i]);
	}
	shutqueue(&Q);
	return 0;
}




