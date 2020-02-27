#include<stdio.h>
#include<stdlib.h>
typedef int ElemType;
typedef struct tagLNode{
    ElemType data;
    struct tagLNode *next;
    }LNode,*LinkList;
void creat(LinkList *L,int n)//尾插法创建链表
{
	LinkList p,s;
	int i;
	p=*L=(LinkList)malloc(sizeof(LNode));
	for(i=0;i<n;i++){
		s=(LinkList)malloc(sizeof(LNode));
		scanf("%d",&(s->data));
		p->next=s,p=s;
	}
	p->next=NULL;
}
void consist(LinkList *La,LinkList *Lb){//合并且输出链表
		LinkList pa,pb,pc,q;
	pa=(*La)->next;
	pb=(*Lb)->next;
	pc=(*La);
	while(pa&&pb){
		if(pa->data<=pb->data){
			pc->next=pa;
			pc=pa;
			pa=pa->next;
		}
		else{
		  pc->next=pb;
		  pc=pb;
		  pb=pb->next;
		}
	}
	pc->next=pa?pa:pb;
    free(*Lb);

	q=(*La)->next;
	while(q){
		printf("%d\n",q->data);
		q=q->next;
	}
}

int main()
{
	int n,m;
	LinkList La,Lb;
	scanf("%d",&n);
	creat(&La,n);
	scanf("%d",&m);
	creat(&Lb,m);
	consist(&La,&Lb);
    return 0;
}


