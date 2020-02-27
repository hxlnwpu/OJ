#include <stdio.h>
#include <stdlib.h>
typedef struct
{
    int i,j;
    int e;
}Triple;
typedef struct Node
{
    Triple data;
    struct Node *next;
}SMatrix,*TSMatrix;


void CreatSmatrix(TSMatrix *M,int t)
{
    TSMatrix p,s;
    int a,b,c;
    int i=0;
    p=(*M)=(TSMatrix) malloc (sizeof(SMatrix));
    for(;i<t;i++)
    {
        s=(TSMatrix) malloc (sizeof(SMatrix));
        scanf("%d %d %d",&a,&b,&c);
        s->data.i=a;
        s->data.j=b;
        s->data.e=c;
        p->next=s;
        p=s;
    }
    p->next=NULL;
}
 void Add(TSMatrix *M,TSMatrix *T,int n)
{
    TSMatrix m,s,t,ts;
	ts=(TSMatrix)malloc(sizeof(SMatrix));//��tsһ���ռ�
    int sum;
    m=(*M)->next;
    t=(*T)->next;
    while(1)//ȫ��������ADD�ĺ���,��whileѭ��һֱ����
    {
		if(m==NULL)//����һ����������ʱ��
		{
			while(1)//ѭ�����tֱ��������
			{
				if(t==NULL)return;
				printf("%d %d %d\n",t->data.i,t->data.j,t->data.e);
			}

		}
		else if(t==NULL)//���ڶ�����������ʱ��
		{
			while(1)//ѭ�����mֱ��������
			{
				if(m==NULL)return;
				printf("%d %d %d\n",m->data.i,m->data.j,m->data.e);
			}

		}

		int x,y;//�ֱ���m��t��Ϊһά���������
		x=m->data.i*n+m->data.j;
		y=t->data.i*n+t->data.j;
		if(x==y)//�������
		{
			printf("%d %d %d\n",m->data.i,m->data.j,m->data.e+t->data.e);
			m=m->next;
			t=t->next;
		}
		else if(x<y)
		{
			printf("%d %d %d\n",m->data.i,m->data.j,m->data.e);
			m=m->next;
		}
		else
		{
			printf("%d %d %d\n",t->data.i,t->data.j,t->data.e);
			t=t->next;
		}

    }
}

void Printf(TSMatrix *M)
{
    TSMatrix r=(*M)->next;
	while(r!=NULL)
	{
		printf("%d %d %d\n",r->data.i,r->data.j,r->data.e);
		r=r->next;
	}
}
int main()
{
    int m,n,t1,t2;
    TSMatrix M,T,C;
    scanf("%d %d %d %d",&m,&n,&t1,&t2);
    CreatSmatrix(&M,t1);
    CreatSmatrix(&T,t2);
    Add(&M,&T,n);//������Ҳ���ݽ�ȥ
    return 0;
}


