#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 100
typedef char infotype;
typedef struct tagBTNode{
    infotype info;
    struct tagBTNode* lchild;
    struct tagBTNode* rchild;
}BinTreeNode,*btree;
typedef btree QType;
typedef struct tagQueue{
    QType *base;
    int front;
    int rear;
}Queue;
void intqueue(Queue *Q)
{
    Q->base= (QType *)malloc(MAX*sizeof(QType));
    Q->front = Q->rear = 0;
}
int EnQueue(Queue *Q,QType e)
{
    if((Q->rear+1)%MAX== Q->front) return 0;
    Q->rear = (Q->rear+1)%MAX;
    Q->base[Q->rear]=e;
    return 1;
}
int QueueEmpty(Queue Q)
{
    return Q.front == Q.rear;
}

void DestoryQueue(Queue *Q)
{
    if(Q->base) free(Q->base);
    Q->base = NULL;
    Q->front = Q->rear = 0;
}

int DeQueue(Queue *Q,QType *e)
{
    if(Q->front == Q->rear) return 0;
    Q->front = (Q->front+1)%MAX;
    if(e!=NULL) {
        *e=Q->base[Q->front];
        return 1;
    }
    return 0;
}
void leoltraverse(btree T ) {
    Queue qu;
    btree p;
    intqueue(&qu);

    if ( !T ) {
        return;
    }
    EnQueue ( &qu, T );
    while ( !QueueEmpty( qu ) )  {
        DeQueue ( &qu, &p );
		printf ( "%c",p->info );
        if ( p->lchild != NULL )
            EnQueue ( &qu, p->lchild );
        if ( p->rchild != NULL )
            EnQueue ( &qu, p->rchild );
     }

     DestoryQueue(&qu);
}
void DistoryBinTree (btree &T )
{
    if ( T != NULL )
    {
        DistoryBinTree (T->lchild);
        DistoryBinTree (T->rchild);
        free(T);
        T=NULL;
    }
}

void CreateBinTree_bracket(btree &T, char* str, int l, int r)
{
    int cnt,i;
	if(str[l] == '#'){
		T=NULL;
		return;
	}
    if ( !( T = (btree) malloc(sizeof(BinTreeNode)) ) ) exit(-1);
    T->info = str[l];
    if(l==r){
		T->lchild = T->rchild = NULL;
		return;
    }
    i=l+2;
    for(cnt=0; cnt!=0 || str[i]!=',' ; ++i){
		switch(str[i]){
			case '(': ++cnt;break;
			case ')': --cnt;break;
		}
    }
    CreateBinTree_bracket(T->lchild, str, l+2, i-1);
	CreateBinTree_bracket(T->rchild, str, i+1, r-1);
}
int main()
{
	int l,r;
	char str[100];
    btree BT = NULL;
    gets(str);
    l=0;
    r=strlen(str)-1;

    CreateBinTree_bracket(BT, str, l , r);
	leoltraverse( BT );
	printf("\n");
    DistoryBinTree( BT );
    return 0;
}
